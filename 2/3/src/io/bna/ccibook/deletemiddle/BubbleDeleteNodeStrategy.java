package io.bna.ccibook.deletemiddle;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
public class BubbleDeleteNodeStrategy<T> implements DeleteMiddleNodeStrategy<T> {
    @Override
    public void delete(LinkedList<T> node) {
        if(node == null || node.isDeleted)
            throw new IllegalArgumentException("Node should not be null");
        if(node.next == null || node.next.isDeleted)
            node.isDeleted = true;
        else {
            node.data = node.next.data;
            node.next = node.next.next;
        }
    }
}
