package io.bna.ccibook.common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brand on 11/25/2016.
 */
public class BiGraphNode<T> {
    public T data;
    public List<BiGraphNode<T>> in = new ArrayList<>(),
                                out = new ArrayList<>();

    public BiGraphNode(T data) {
        this.data = data;
    }

    public void mapTo(BiGraphNode<T> node) {
        if(!out.contains(node)) {
            out.add(node);
            if(!node.in.contains(this)) {
                node.in.add(this);
            }
        }
    }

    public void removeTo(BiGraphNode<T> node) {
        if(out.contains(node)) {
            out.remove(node);
            if(node.in.contains(this)) {
                node.in.remove(this);
            }
        }
    }

    public void mapBoth(BiGraphNode<T> node) {
        node.mapTo(this);
        mapTo(node);
    }

    public void removeBoth(BiGraphNode<T> node) {
        node.removeTo(this);
        removeTo(node);
    }
}
