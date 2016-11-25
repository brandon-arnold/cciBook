package io.bna.ccibook.firstancestor;

import io.bna.ccibook.common.LinkedList;
import io.bna.ccibook.common.TreeNode;
import io.bna.ccibook.interll.TruncateIfIntersectStrat;

/**
 * Created by brand on 11/25/2016.
 */
public class ReverseListAncestorFinder<T> {
    TruncateIfIntersectStrat finder = new TruncateIfIntersectStrat();

    TreeNode<T> find(TreeNode<T> node1, TreeNode<T> node2) {
        LinkedList<TreeNode<T>> node1Parents = getParentList(node1),
                                node2Parents = getParentList(node2);
        LinkedList<TreeNode<T>> result = finder.hasIntersection(node1Parents, node2Parents);
        if(result == null) return null;
        return result.data;
    }

    LinkedList<TreeNode<T>> getParentList(TreeNode<T> node) {
        if(null == node) return null;
        LinkedList<TreeNode<T>> result = new LinkedList(node),
                                cur = result;
        while(node != null) {
            cur.next = new LinkedList<>(node.parent);
            cur = cur.next;
            node = node.parent;
        }
        return result;
    }
}
