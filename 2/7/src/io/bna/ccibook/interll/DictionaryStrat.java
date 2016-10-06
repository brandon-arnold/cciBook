package io.bna.ccibook.interll;

import io.bna.ccibook.common.LinkedList;

import java.util.HashSet;

/**
 * Created by brand on 10/5/2016.
 */
public class DictionaryStrat implements IntersectionSearchStrategy {
    @Override
    public LinkedList hasIntersection(LinkedList ll1, LinkedList ll2) {
        HashSet<LinkedList> nodeHT = new HashSet<>();
        LinkedList cur1 = ll1,
                   cur2 = ll2;
        while(cur1 != null) {
            nodeHT.add(cur1);
            cur1 = cur1.next;
        }
        while(cur2 != null) {
            if(nodeHT.contains(cur2)) return cur2;
            cur2 = cur2.next;
        }
        return null;
    }
}
