package io.bna.ccibook.partitionll;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
public interface PartitionLlStrategy<T extends Comparable<T>> {
    void partition(LinkedList<T> list, T k);
}
