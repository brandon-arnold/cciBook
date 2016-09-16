package io.bna.ccibook.kthtolast;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
public interface KthToLastStrategy<T> {
    T kthToLast(LinkedList<T> list, int k);
}
