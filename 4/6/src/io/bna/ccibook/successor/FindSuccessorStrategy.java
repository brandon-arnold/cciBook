package io.bna.ccibook.successor;

import io.bna.ccibook.common.BinaryNode;

/**
 * Created by brand on 11/17/2016.
 */
public interface FindSuccessorStrategy<T extends Comparable<T>> {
    T getSuccessor(BinaryNode<T> node) throws Exception;
}
