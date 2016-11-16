package io.bna.ccibook.isbalanced;

import io.bna.ccibook.common.BinaryNode;

import java.util.Stack;

/**
 * Created by brand on 11/14/2016.
 */
public class IterativeBalanceChecker<T> implements ValidatedBalancedStrategy<T> {
    @Override
    public boolean isBalanced(BinaryNode<T> root) {
        BinaryNode<T> cur = root,
                      lastVisited = null;
        Stack<BinaryNode<T>> toVisit = new Stack<BinaryNode<T>>();
        while(cur != null || !toVisit.isEmpty()) {
            if(cur != null) {
                toVisit.push(cur);
                cur = cur.left;
            } else {
                BinaryNode<T> peek = toVisit.peek();
                if(peek.right != null && peek.right != lastVisited) {
                    cur = peek.right;
                } else {
                    // begin visit
                    int lDepth = peek.left == null ? 0 : peek.left.depth,
                        rDepth = peek.right == null ? 0 : peek.right.depth;
                    if(Math.abs(lDepth - rDepth) > 1) {
                        return false;
                    }
                    peek.depth = Math.max(lDepth, rDepth) + 1;
                    // end visit
                    lastVisited = toVisit.pop();
                }
            }
        }
        return true;
    }
}
