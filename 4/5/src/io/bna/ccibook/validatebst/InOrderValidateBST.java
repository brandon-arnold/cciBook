package io.bna.ccibook.validatebst;

import io.bna.ccibook.common.BinaryNode;

import java.util.Stack;

/**
 * Created by brand on 11/16/2016.
 */
public class InOrderValidateBST<T extends Comparable<T>> implements BstValidationStrategy<T> {
    @Override
    public boolean isBst(BinaryNode<T> b) {
        Stack<BinaryNode<T>> toVisit = new Stack<>();
        BinaryNode<T> cur = b;
        T lastVal = null;
        while(!toVisit.isEmpty() || cur != null) {
            if(cur != null) {
                toVisit.push(cur);
                cur = cur.left;
            } else {
                cur = toVisit.pop();
                if(null == lastVal) {
                    lastVal = cur.data;
                } else {
                    if(lastVal.compareTo(cur.data) > 0) {
                        return false;
                    } else {
                        lastVal = cur.data;
                    }
                }
                cur = cur.right;
            }
        }
        return true;
    }
}
