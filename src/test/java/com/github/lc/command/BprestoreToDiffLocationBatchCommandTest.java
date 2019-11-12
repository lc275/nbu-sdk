package com.github.lc.command;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class BprestoreToDiffLocationBatchCommandTest {

    @Test
    public void renameFileContent() {
        BprestoreToDiffLocationBatchCommand cmd = new BprestoreToDiffLocationBatchCommand();
        List<String> filePathList = Arrays.asList("/s/1.txt", "/s/2.txt", "/s/b/");
        cmd.setFilePathList(filePathList);
        cmd.setTargetDirectory("/t/");
        String result = cmd.renameFileContent();
        String expected="change /s/1.txt to /t/1.txt\n" +
                "change /s/2.txt to /t/2.txt\n" +
                "change /s/b/ to /t/b/";
        Assert.assertTrue(expected.equals(result));
    }

    @Test
    public void fileNamesContent() {
        BprestoreToDiffLocationBatchCommand cmd = new BprestoreToDiffLocationBatchCommand();
        List<String> filePathList = Arrays.asList("/s/1.txt", "/s/2.txt", "/s/b/");
        cmd.setFilePathList(filePathList);
        cmd.setTargetDirectory("/t/");
        String result = cmd.fileNamesContent();
        String expected="/s/1.txt\n" +
                "/s/2.txt\n" +
                "/s/b/";
        Assert.assertTrue(expected.equals(result));
    }
}