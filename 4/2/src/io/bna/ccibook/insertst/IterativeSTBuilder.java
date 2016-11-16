package io.bna.ccibook.insertst;

import io.bna.ccibook.common.BinaryNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by brand on 11/16/2016.
 */
public class IterativeSTBuilder implements SortedInsertionStrategy {
    class Range {
        int begin;
        int end;

        public Range(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }

    @Override
    public BinaryNode<Integer> makeTree(Integer[] list) {
        BinaryNode<Integer> root = null;
        Queue<Range> toVisit = new ArrayDeque<>();
        toVisit.add(new Range(0, list.length - 1));
        while(!toVisit.isEmpty()) {
            Range curVisit = toVisit.remove();
            int mid = (curVisit.begin + curVisit.end) / 2;
            int left = mid - 1;
            int right = mid + 1;
            if(null == root) {
                root = new BinaryNode<>(list[mid]);
            } else {
                insert(root, list[mid]);
            }
            if(left >= curVisit.begin) {
                toVisit.add(new Range(curVisit.begin, left));
            }
            if(right <= curVisit.end) {
                toVisit.add(new Range(right, curVisit.end));
            }
        }
        return root;
    }

    private void insert(BinaryNode<Integer> root, Integer val) {
        if (val < root.data) {
            if(null == root.left) {
                root.left = new BinaryNode<>(val);
            } else {
                insert(root.left, val);
            }
        } else {
            if(null == root.right) {
                root.right = new BinaryNode<>(val);
            } else {
                insert(root.right, val);
            }
        }
    }
}
