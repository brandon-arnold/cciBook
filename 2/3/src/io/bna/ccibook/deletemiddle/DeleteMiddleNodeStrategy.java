package io.bna.ccibook.deletemiddle;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
public interface DeleteMiddleNodeStrategy<T> {
    void delete(LinkedList<T> node);
}
