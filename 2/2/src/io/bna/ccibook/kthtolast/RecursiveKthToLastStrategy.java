package io.bna.ccibook.kthtolast;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
public class RecursiveKthToLastStrategy<T> implements KthToLastStrategy<T> {
    private T kData;

    @Override
    public T kthToLast(LinkedList<T> list, int k) {
        if (k < 1) throw new IllegalArgumentException("Argument 'k' must exceed 0.");
        recurseToK(list, k);
        return kData;
    }

    private int recurseToK(LinkedList<T> list, int k) {
        if(list == null) return 0;
        int lenList = recurseToK(list.next, k) + 1;
        if(k == lenList) kData = list.getData();
        return lenList;
    }
}
