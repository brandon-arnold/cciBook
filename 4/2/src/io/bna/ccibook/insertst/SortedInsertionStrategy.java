package io.bna.ccibook.insertst;

import io.bna.ccibook.common.BinaryNode;

/**
 * Created by brand on 11/16/2016.
 */
public interface SortedInsertionStrategy {
    BinaryNode<Integer> makeTree(Integer[] list);
}
