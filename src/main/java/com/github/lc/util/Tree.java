package com.github.lc.util;

import java.util.LinkedList;
import java.util.List;

public class Tree <N extends HierarchyObject>{
    private List<N> flatNodeList;
    public  Tree(List<N> list){
        flatNodeList=list;
    }
    public List<N> buildTree(){
        List<N> tree = new LinkedList<>();
        flatNodeList.forEach(node->{
            if(node.ifRoot()){
                tree.add(node);
                build(node);
            }
        });
        return tree;
    }

    private void build(N n) {
        List<N> children = getChildren(n);
        if (!children.isEmpty()) {
            for (N child : children) {
                n.addChild(child);
                build(child);
            }
        }
    }
    private List<N> getChildren(N node){
        List<N> childrenList = new LinkedList<>();
        flatNodeList.forEach(m->{
            if( node.ifParentOf(m)){
                childrenList.add(m);
            }
        });
        return  childrenList;
    }
}
