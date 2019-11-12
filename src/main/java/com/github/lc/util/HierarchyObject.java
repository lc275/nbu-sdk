package com.github.lc.util;

import java.util.LinkedList;
import java.util.List;

public interface  HierarchyObject<H extends HierarchyObject> {
    default void addChild(H h){
        if(getChildren()==null){
            setChildren(new LinkedList<>());
        }
        getChildren().add(h);
    };

    boolean ifParentOf(H h);

    boolean ifRoot();

    List<H> getChildren();

    void setChildren(List<H> list);
}
