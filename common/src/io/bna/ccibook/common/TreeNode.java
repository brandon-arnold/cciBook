package io.bna.ccibook.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brand on 11/25/2016.
 */
public class TreeNode<T> {
    public T data;
    public TreeNode<T> parent = null;
    public List<TreeNode<T>> children = new ArrayList<>();

    public TreeNode(T data) {
        this.data = data;
    }

    public void addChild(TreeNode<T> child) throws Exception {
        if(child.parent != null && child.parent != this) {
            throw new Exception("Node already has a parent.");
        }
        if(!children.contains(child)) {
            children.add(child);
        }
        child.parent = this;
    }

    public void removeChild(TreeNode<T> child) throws Exception {
        if(this != child.parent) {
            throw new Exception("Node provided is not a child");
        }
        if(children.contains(child)) {
            children.remove(child);
        }
        child.parent = null;
    }
}
