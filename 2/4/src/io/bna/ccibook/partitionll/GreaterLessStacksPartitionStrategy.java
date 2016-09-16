package io.bna.ccibook.partitionll;

import io.bna.ccibook.common.LinkedList;

import java.util.Stack;

/**
 * Created by brand on 9/16/2016.
 */
public class GreaterLessStacksPartitionStrategy<T extends Comparable<T>> implements PartitionLlStrategy<T> {
    @Override
    public void partition(LinkedList<T> list, T k) {
        if (list == null || list.next == null) return;

        Stack<T> greater = new Stack<>();
        Stack<T> lesser = new Stack<>();

        // push each node onto the appropriate stack
        LinkedList<T> cur = list;
        while (cur != null) {
            if (cur.data.compareTo(k) < 0)
                lesser.push(cur.data);
            else
                greater.push(cur.data);
            cur = cur.next;
        }

        // if either stack is empty, return as the list is already in the
        // correct form. Else, create a new list popping from the top of the
        // lesser stack
        LinkedList<T> newList;
        if(lesser.empty() || greater.empty())
            return;
        else newList = new LinkedList<>(lesser.pop());

        // pop each stack, lesser first and then greater, onto a new list
        LinkedList<T> curNewNode = newList;
        while(!lesser.empty()) {
            curNewNode.next = new LinkedList<>(lesser.pop());
            curNewNode = curNewNode.next;
        }
        while(!greater.empty()) {
            curNewNode.next = new LinkedList<>(greater.pop());
            curNewNode = curNewNode.next;
        }

        //replace head's data
        list.next = newList.next;
        list.data = newList.data;
    }
}
