package io.bna.ccibook.common;

/**
 * Created by brand on 11/14/2016.
 */
public class BinaryNode<T> {
    public BinaryNode<T> right = null, left = null;
    public T data;
    public Integer depth;

    public BinaryNode(T data) {
        this.data = data;
    }

}
