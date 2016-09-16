package io.bna.ccibook.kthtolast;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
public class RunnerKthToLastStrategy<T> implements KthToLastStrategy<T> {
    @Override
    public T kthToLast(LinkedList<T> list, int k) {
        LinkedList<T> runner = list;
        if(k < 1) throw new IllegalArgumentException("Argument 'k' must exceed 0.");
        for(int i = 1; i < k; i++)
            if(runner == null)
                throw new IllegalArgumentException("List length must exceed k.");
            else
                runner = runner.next;
        while(runner.next != null) {
            runner = runner.next;
            list = list.next;
        }
        return list.getData();
    }
}
