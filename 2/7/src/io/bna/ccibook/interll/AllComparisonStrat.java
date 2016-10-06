package io.bna.ccibook.interll;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 10/5/2016.
 */
public class AllComparisonStrat implements IntersectionSearchStrategy {
    @Override
    public LinkedList hasIntersection(LinkedList ll1, LinkedList ll2) {
        LinkedList cur1 = ll1;
        while(cur1 != null) {
            LinkedList cur2 = ll2;
            while(cur2 != null) {
                if(cur1 == cur2) return cur1;
                cur2 = cur2.next;
            }
            cur1 = cur1.next;
        }
        return null;
    }
}
