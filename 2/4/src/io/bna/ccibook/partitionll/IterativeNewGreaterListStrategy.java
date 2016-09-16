package io.bna.ccibook.partitionll;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
public class IterativeNewGreaterListStrategy<T extends Comparable<T>> implements PartitionLlStrategy<T> {

    @Override
    public void partition(LinkedList<T> head, T k) {
        LinkedList<T> next = head;

        // if head's data exceeds k, we want to replace it with a node
        // that does not exceed k
        while(next != null && next.data.compareTo(k) >= 0)
            next = next.next;
        if(next == null) return;
        else if(next != head){
            T tmp = head.data;
            head.data = next.data;
            next.data = tmp;
        }

        // We are now ensured that the list begins with something less than k
        // Next, find a node that is greater than k, to seed a list in which
        // we will keep all nodes greater than k
        next = head;
        while(next.next != null && next.next.data.compareTo(k) < 0)
            next = next.next;
        LinkedList<T> greater = next.next;
        next.next = greater.next;
        greater.next = null;

        // At this time, either next points to the tail of the list,
        // or to remaining nodes that may or may not be greater than k.
        // If the latter, traverse the remainder of the list, adding nodes to the greater
        // list or leaving them in the main list.
        while(next.next != null) {
            if(next.next.data.compareTo(k) >= 0) {
                LinkedList<T> greaterTail = greater.getTail();
                greaterTail.next = next.next;
                next.next = next.next.next;
                greaterTail.next.next = null;
            } else next.next = next.next.next;
        }

        //put the greater list at the end
        next.next = greater;
    }
}
