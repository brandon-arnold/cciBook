package io.bna.ccibook.partitionll;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
public class InsertLesserAtBeginningStrategy<T extends Comparable<T>> implements PartitionLlStrategy<T> {
    @Override
    public void partition(LinkedList<T> list, T k) {
        if(list == null || list.next == null) return;
        LinkedList<T> curNode = list;
        T tmpData;
        LinkedList<T> tmpNext;
        while(curNode.next != null) {
            // iterate through nodes less than k and move them to the beginning
            while (curNode.next != null && curNode.next.data.compareTo(k) < 0) {
                tmpData = list.data;
                list.data = curNode.next.data;
                curNode.next.data = tmpData;
                tmpNext = list.next;
                list.next = curNode.next;
                curNode.next = curNode.next.next;
                list.next.next = tmpNext;
            }
            //iterate through nodes greater than k and ignore them
            while (curNode.next != null && curNode.next.data.compareTo(k) >= 0)
                curNode = curNode.next;
        }
    }
}
