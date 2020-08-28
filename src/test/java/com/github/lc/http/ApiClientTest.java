package com.github.lc.http;

import com.github.lc.request.AdminJobsByIdGetReq;
import com.github.lc.request.AdminJobsGetReq;
import com.github.lc.request.CatalogImagesGetReq;
import com.github.lc.request.TokenProvider;
import com.github.lc.request.enumeration.Query;
import com.github.lc.response.AdminJobsByIdResp;
import com.github.lc.response.AdminJobsResp;
import com.github.lc.response.CatalogImagesResp;
import com.github.lc.schema.JobDetailsAttributes;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class ApiClientTest {

    @Test
    public void execute() {
        ApiClient apiClient = buildApiClient();


        //simply request singleJob;
        Integer jobId = 17380;
        AdminJobsByIdGetReq req = new AdminJobsByIdGetReq(jobId);
        AdminJobsByIdResp resp = apiClient.execute(req, AdminJobsByIdResp.class);


        //build a more complex request
        CatalogImagesGetReq catalogImagesGetReq = new CatalogImagesGetReq();
        String startTime = "2018-01-09T10:03:22.000Z";
        String endTime = "2018-01-09T10:03:23.000Z";
        int pageLimit = 100;
        catalogImagesGetReq.putQuery(Query.FILTER, "backupTime ge " + startTime + " and backupTime le " + endTime);
        catalogImagesGetReq.putQuery(Query.PAGE_LIMIT, pageLimit);
        CatalogImagesResp catalogImagesResp = apiClient.execute(catalogImagesGetReq, CatalogImagesResp.class);
    }

    @Test
    public void loopToEnd() {
        ApiClient apiClient = buildApiClient();
        AdminJobsGetReq req = new AdminJobsGetReq();
        List<JobDetailsAttributes> jobList = new LinkedList<>();
        //loop request the job to end,and add JobDetailsAttributes to list
        apiClient.loopToEnd(req,
                AdminJobsResp.class,
                adminJobsResp -> adminJobsResp.getData().forEach(jobDetails -> jobList.add(jobDetails.getAttributes())));
    }

    private ApiClient buildApiClient() {
        String nbuMasterIp = "10.238.0.54";
        int port = 1556;
        return new ApiClient(nbuMasterIp, port, new TokenProvider() {
            @Override
            public String getToken(String masterIpAddress) {
                return "tokenGetFromLoginInterface";
            }
        });
    }
}