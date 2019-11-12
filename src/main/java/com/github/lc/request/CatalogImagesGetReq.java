package com.github.lc.request;

import com.github.lc.request.path.UriPath;
import com.github.lc.request.enumeration.Query;
import com.github.lc.util.DateFormatUtil;
import org.springframework.util.StringUtils;

import java.util.*;

public class CatalogImagesGetReq extends AbstractReq {

    private static final int MAX_LIMIT = 100;

    @Override
    protected String uri() {
        return UriPath.GET_CATALOG_IMAGES;
    }

    public static CatalogImagesGetReq buildReq(String clientName, String policyName, String startTime, String endTime) {
        CatalogImagesGetReq req = new CatalogImagesGetReq();
        req.putFilter(clientName, policyName, startTime, endTime);
        req.putQuery(Query.PAGE_LIMIT, MAX_LIMIT);
        return req;
    }

    public static CatalogImagesGetReq buildReq(Date startTime) {
        String filter = "backupTime ge ";
        if (startTime == null) {
            filter += "1970-01-01T00:00:00.000Z";//如果开始时间为空，则从头查询
        } else {
            startTime.setTime(startTime.getTime() + 1000);//延后一秒
            String startTimeStr = DateFormatUtil.toUTC(startTime);
            filter += startTimeStr;
        }
        CatalogImagesGetReq req = new CatalogImagesGetReq();
        req.putQuery(Query.FILTER, filter);
        req.putQuery(Query.PAGE_LIMIT, MAX_LIMIT);
        return req;
    }

    public static List<CatalogImagesGetReq> buildPast24HoursReq() {
        List<CatalogImagesGetReq> reqList = new LinkedList<>();
        Calendar instance = Calendar.getInstance();
        instance.clear(Calendar.MINUTE);
        instance.clear(Calendar.SECOND);
        instance.clear(Calendar.MILLISECOND);
        int hourStep = -3;
        int minuteStep = 45;
        int nOuter = 24 / Math.abs(hourStep);
        int nInner = Math.abs(hourStep) * 60 / minuteStep;
        /**
         * 将过去的24小时按小时分割，每hourStep(3小时)一个请求
         * 镜像生成大多集中在22:00-01:00，因此如果分割出的时间段包含了22:00-01:00中的时段，则将该时段按分钟分割，每minuteStep(45分钟)一个请求
         */
        for (int i = 0; i < nOuter; i++) {
            int endHour = instance.get(Calendar.HOUR_OF_DAY);
            String endTime = DateFormatUtil.toUTC(instance.getTime());
            instance.add(Calendar.HOUR_OF_DAY, hourStep);
            int startHour = instance.get(Calendar.HOUR_OF_DAY);
            String startTime = DateFormatUtil.toUTC(instance.getTime());
            if (Arrays.asList(22, 23, 0).contains(startHour) || Arrays.asList(23, 0, 1).contains(endHour)) {
                for (int j = 0; j < nInner; j++) {
                    String mStartTime = DateFormatUtil.toUTC(instance.getTime());
                    instance.add(Calendar.MINUTE, minuteStep);
                    String mEndTime = DateFormatUtil.toUTC(instance.getTime());
                    addReq(reqList, mStartTime, mEndTime);
                }
                instance.add(Calendar.HOUR_OF_DAY, hourStep);
            } else {
                addReq(reqList, startTime, endTime);
            }
        }
        return reqList;
    }

    private static void addReq(List<CatalogImagesGetReq> reqList, String startTime, String endTime) {
        String filter = "backupTime ge " + startTime + " and backupTime le " + endTime;
        System.out.println(filter);
        CatalogImagesGetReq req = new CatalogImagesGetReq();
        req.putQuery(Query.FILTER, filter);
        req.putQuery(Query.PAGE_LIMIT, MAX_LIMIT);
        reqList.add(req);
    }

    private void putFilter(String clientName, String policyName, String startTime, String endTime) {
        List<String> conditions = new ArrayList<>();
        if (!StringUtils.isEmpty(clientName)) {
            conditions.add(" clientName eq " + clientName + " ");
        }
        if (!StringUtils.isEmpty(policyName)) {
            conditions.add(" policyName eq " + policyName + " ");
        }
        if (!StringUtils.isEmpty(startTime)) {
            conditions.add(" backupTime ge " + startTime);
        }
        if (!StringUtils.isEmpty(endTime)) {
            conditions.add(" backupTime le " + endTime);
        }
        String filter = String.join(" and ", conditions).trim();
        this.putQuery(Query.FILTER, filter);
    }

}
