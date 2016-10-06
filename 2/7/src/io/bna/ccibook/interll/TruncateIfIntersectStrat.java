package io.bna.ccibook.interll;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 10/5/2016.
 */
public class TruncateIfIntersectStrat implements IntersectionSearchStrategy {
    @Override
    public LinkedList hasIntersection(LinkedList ll1, LinkedList ll2) {
        if(ll1.getTail() != ll2.getTail()) {
            return null;
        }
        int len1 = ll1.getLength(),
            len2 = ll2.getLength();
        LinkedList cur1 = ll1, cur2 = ll2;
        if(len1 > len2) {
            cur1 = ll1.getNth(len1 - len2);
        } else {
            cur2 = ll2.getNth(len2 - len1);
        }
        while(cur1 != cur2) {
            if(cur1 != null) { cur1 = cur1.next; }
            else { return null; }
            if(cur2 != null) { cur2 = cur2.next; }
            else { return null; }
        }
        return cur1;
    }
}
