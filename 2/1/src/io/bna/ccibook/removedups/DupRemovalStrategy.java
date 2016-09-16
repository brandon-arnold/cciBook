package io.bna.ccibook.removedups;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
public interface DupRemovalStrategy<T> {
    void removeDups(LinkedList<T> head);
}
