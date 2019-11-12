package com.github.lc.schema.policy;

import lombok.Data;

import java.util.List;

@Data
public class PolicyVMware extends PolicyAttributes{
      private boolean applicationConsistent;
      private boolean applicationDiscovery;
      private List<String> applicationProtection;
      private String backupHost;
      private boolean blockIncremental;
      private boolean disableClientSideDeduplication;
      private int discoveryLifetime;
      private String secondarySnapshotMethodArgs;
      private String snapshotMethodArgs;
      private boolean useAccelerator;
      private boolean useReplicationDirector;

}
