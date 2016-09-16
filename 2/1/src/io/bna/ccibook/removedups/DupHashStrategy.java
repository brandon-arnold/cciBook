package io.bna.ccibook.removedups;

import io.bna.ccibook.common.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by brand on 9/16/2016.
 */
public class DupHashStrategy<T> implements DupRemovalStrategy<T> {

    @Override
    public void removeDups(LinkedList<T> head) {
        Set<T> elements = new HashSet<T>();
        elements.add(head.getData());
        while(head.next != null) {
            if(!elements.contains(head.next.getData())) {
                elements.add(head.next.getData());
                head = head.next;
            } else
                head.next = head.next.next;
        }
    }
}
