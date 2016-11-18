package io.bna.ccibook.successor;

import io.bna.ccibook.common.BinaryNode;

/**
 * Created by brand on 11/17/2016.
 */
public class IterativeInOrderFinder<T extends Comparable<T>> implements FindSuccessorStrategy<T> {
    @Override
    public T getSuccessor(BinaryNode<T> node) throws Exception {
        if(node == null)
            throw new Exception("Must supply a node to getSuccessor().");
        BinaryNode<T> lastNode = null;
        while(node.right == lastNode || node.right == null) {
            if(node.parent != null) {
                if(node.parent.left == node)
                    return node.parent.data;
                else {
                    lastNode = node;
                    node = node.parent;
                }
            } else throw new Exception("No successor exists.");
        }
        return getMinimum(node.right).data;
    }

    private BinaryNode<T> getMinimum(BinaryNode<T> node) throws Exception {
        if(node == null)
            throw new Exception("Must supply a node to getMinimum().");
        BinaryNode<T> min = node;
        while(node != null) {
            min = node;
            node = node.left;
        }
        return min;
    }
}
