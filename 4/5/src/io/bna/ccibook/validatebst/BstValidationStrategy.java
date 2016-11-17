package io.bna.ccibook.validatebst;

import io.bna.ccibook.common.BinaryNode;

/**
 * Created by brand on 11/16/2016.
 */
public interface BstValidationStrategy<T extends Comparable<T>> {
    boolean isBst(BinaryNode<T> b);
}
