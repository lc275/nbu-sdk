package com.github.lc.request.path;

/**
 *  uri path constants class
 * naming pattern:request method+resource
 */
public class UriPath {
    public static final String POST_NETBACKUP_LOGIN = "/login";

    public static final String GET_PING = "/ping";

    public static final String GET_ADMIN_JOBS = "/admin/jobs";

    public static final String GET_ADMIN_JOBS_BY_ID = "/admin/jobs/{jobId}";

    public static final String GET_ADMIN_JOBS_FILE_LISTS="/admin/jobs/{jobId}/file-lists";

    public static final String DELETE_ADMIN_JOBS = "/admin/jobs/{jobId}";

    public static final String POST_ADMIN_JOBS_RESTART = "/admin/jobs/{jobId}/restart";

    public static final String POST_ADMIN_JOBS_CANCLE ="/admin/jobs/{jobId}/cancel";

    public static final String GET_CATALOG_IMAGES = "/catalog/images";

    public static final String DELETE_CATALOG_IMAGES_CONTENT = "/catalog/images/contents/{requestId}";

    public static final String POST_CONFIG_POLICY = "/config/policies/";

    public static final String PUT_CONFIG_POLICY = "/config/policies/{policyName}";

    public static final String DELETE_CONFIG_POLICY = "/config/policies/{policyName}";

    public static final String GET_CONFIG_POLICIES = "/config/policies/";

    public static final String GET_CONFIG_POLICY = "/config/policies/{policyName}";

    public static final String GET_CONFIG_HOSTS = "/config/hosts/hostmappings";

    public static final String GET_CATALOG_IMAGES_CONTENTS = "/catalog/images/contents/{requestId}";

    public static final String GET_CATALOG_IMAGES_REQUESTID = "/catalog/images/{backupId}/contents";

    public static final String GET_STORAGE_UNITS = "/storage/storage-units";

    public static final String GET_STORAGE_UNITS_REPLICATION_RELATIONSHIP = "/storage/storage-units/{storageUnitName}/replication-relationships";

    public static final String GET_CONFIG_SLPS = "/config/slps";

    public static final String  PUT_POLICY_SCHEDULE="/config/policies/{policyName}/schedules/{scheduleName}";

    private UriPath() {
    }
}
