package io.bna.ccibook.removedups;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
public class InPlaceDupRemovalStrategy<T> implements DupRemovalStrategy<T> {
    @Override
    public void removeDups(LinkedList<T> head) {
        LinkedList<T> comp;
        while(head.next != null) {
            comp = head;
            while(comp.next != null) {
                if(head.getData() == comp.next.getData())
                    comp.next = comp.next.next;
                else comp = comp.next;
            }
            head = head.next;
        }
    }
}
