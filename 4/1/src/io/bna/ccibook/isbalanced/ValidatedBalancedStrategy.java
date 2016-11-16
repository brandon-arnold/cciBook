package io.bna.ccibook.isbalanced;

import io.bna.ccibook.common.BinaryNode;

/**
 * Created by brand on 11/14/2016.
 */
public interface ValidatedBalancedStrategy<T> {
    boolean isBalanced(BinaryNode<T> root);
}
