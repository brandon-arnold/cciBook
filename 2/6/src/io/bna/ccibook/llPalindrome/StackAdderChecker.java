package io.bna.ccibook.llPalindrome;

import io.bna.ccibook.common.LinkedList;

import java.util.Stack;

/**
 * Created by brand on 9/30/2016.
 */
public class StackAdderChecker<T> implements IsPalindromeStrategy<T> {
    @Override
    public boolean isPalindrome(LinkedList<T> x) {
        LinkedList<T> cur = x;
        Stack<T> xs = new Stack<>();
        int count = 0;
        while(cur != null) {
            xs.push(cur.data);
            cur = cur.next;
            count++;
        }
        cur = x;
        for(int i = 0; i < (count / 2); i++) {
            if(!xs.pop().equals(cur.data)) { return false; }
            cur = cur.next;
        }
        return true;
    }
}
