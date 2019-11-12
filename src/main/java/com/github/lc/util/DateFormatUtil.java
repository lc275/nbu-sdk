package com.github.lc.util;

import org.springframework.util.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;

public class DateFormatUtil {
    /**
     * 将yyyy-MM-dd HH:mm:ss 格式的日期
     * 转换为 yyyy-MM-dd'T'HH:mm:ss'Z' 格式
     * @param dateTimeStr
     * @return
     */
    public static String toUTC(String dateTimeStr) throws ParseException {
        Assert.hasLength(dateTimeStr,"日期不能为空");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormat.parse(dateTimeStr);
        return toUTC(date);
    }
    public static String toUTC(Date date){
        Assert.notNull(date,"日期不能为空");
        SimpleDateFormat dateFormatUTC = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        dateFormatUTC.setTimeZone(TimeZone.getTimeZone("UTC"));
        String UTCFormatDate = dateFormatUTC.format(date);
        return UTCFormatDate;
    }
}
