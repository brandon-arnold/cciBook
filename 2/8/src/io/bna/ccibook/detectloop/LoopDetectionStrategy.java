package io.bna.ccibook.detectloop;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 10/5/2016.
 */
public interface LoopDetectionStrategy {
    LinkedList getLoopStart(LinkedList list);
}
