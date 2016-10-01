package io.bna.ccibook.llPalindrome;

import io.bna.ccibook.common.LinkedList;

import java.util.Stack;

/**
 * Created by brand on 9/30/2016.
 */
public class CountStackAdderChecker<T> implements IsPalindromeStrategy<T> {
    @Override
    public boolean isPalindrome(LinkedList<T> x) {
        LinkedList<T> cur = x;
        Stack<T> xs = new Stack<>();
        int length = cur.getLength(),
            curI = length - 1;
        while(curI > length / 2) {
            xs.push(cur.data);
            cur = cur.next;
            curI--;
        }
        if(xs.size() == curI) cur = cur.next;
        while(!xs.isEmpty()) {
            if(!xs.pop().equals(cur.data)) return false;
            cur = cur.next;
        }
        return true;
    }
}
