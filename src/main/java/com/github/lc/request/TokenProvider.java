package com.github.lc.request;

/**
 * Interface to provide a token of NetBackup Master .The Token can be obtained by a redis cache or database;
 * The token can be gotten and refreshed by quartz job.
 */
public interface TokenProvider {
    /**
     * Get the token corresponding to the NetBackup master
     * @param masterIpAddress the ip address of master
     * @return token of the master
     */
    String getToken(String masterIpAddress);
}
