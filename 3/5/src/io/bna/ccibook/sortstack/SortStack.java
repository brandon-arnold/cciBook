package io.bna.ccibook.sortstack;

import java.util.Stack;

/**
 * Created by brand on 11/4/2016.
 */
public class SortStack<T extends Comparable<T>>  {

    public void sort(Stack<T> s) {
        if(s.isEmpty()) {
            return;
        }

        Stack<T> sorted = new Stack<>();
        sorted.push(s.pop());
        int lesserCount = 0;
        while(!s.isEmpty()) {
            T temp = s.pop();
            while (!sorted.isEmpty()) {
                if(temp.compareTo(sorted.peek()) < 0) {
                    s.push(sorted.pop());
                    lesserCount++;
                } else {
                    break;
                }
            }
            sorted.push(temp);
            while(lesserCount > 0) {
                sorted.push(s.pop());
                lesserCount--;
            }
        }

        while(!sorted.isEmpty()) {
            s.push(sorted.pop());
        }
    }
}
