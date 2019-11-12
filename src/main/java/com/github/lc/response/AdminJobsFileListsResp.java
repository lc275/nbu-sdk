package com.github.lc.response;

import com.github.lc.schema.FileListsData;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AdminJobsFileListsResp {
    private FileListsData data;
}
