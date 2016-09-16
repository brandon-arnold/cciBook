package io.bna.ccibook.kthtolast;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
public class KnownSizeKthToLastStrategy<T> implements KthToLastStrategy<T> {
    @Override
    public T kthToLast(LinkedList<T> list, int k) {
        if (k < 1) throw new IllegalArgumentException("Argument 'k' must exceed 0.");
        int listLength = list.getLength();
        for(int i = 0; i < listLength - k; i++)
            list = list.next;
        return list.getData();
    }
}
