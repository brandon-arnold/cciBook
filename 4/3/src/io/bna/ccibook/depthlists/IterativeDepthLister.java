package io.bna.ccibook.depthlists;

import io.bna.ccibook.common.BinaryNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by brand on 11/16/2016.
 */
public class IterativeDepthLister<T> {
    ArrayList<LinkedList<T>> listAtDepths(BinaryNode<T> b) {
        ArrayList<LinkedList<T>> lists = new ArrayList<>();
        Queue<BinaryNode<T>> curDepth = null,
                             nextDepth = new ArrayDeque<>();
        nextDepth.add(b);
        while(!nextDepth.isEmpty()) {
            LinkedList<T> curList = new LinkedList<T>();
            curDepth = nextDepth;
            nextDepth = new ArrayDeque<>();
            while(!curDepth.isEmpty()) {
                BinaryNode<T> curNode = curDepth.remove();
                if(curNode.left != null) {
                    nextDepth.add(curNode.left);
                }
                if(curNode.right != null) {
                    nextDepth.add(curNode.right);
                }
                curList.add(curNode.data);
            }
            lists.add(curList);
        }
        return lists;
    }
}
