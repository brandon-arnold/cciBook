package io.bna.ccibook.depthlists

import io.bna.ccibook.common.BinaryNode

/**
 * Created by brand on 11/16/2016.
 */
class IterativeDepthListerTest extends GroovyTestCase {
    void testLister() {
        IterativeDepthLister<Integer> lister = new IterativeDepthLister();
        BinaryNode<Integer> root = new BinaryNode<>(0);
        root.left = new BinaryNode<>(1);
        root.right = new BinaryNode<>(1);
        root.left.left = new BinaryNode<>(2);
        root.right.left = new BinaryNode<>(2);
        root.right.right = new BinaryNode<>(2);
        root.left.left.left = new BinaryNode<>(3);
        root.left.left.right = new BinaryNode<>(3);
        root.right.right.left = new BinaryNode<>(3);
        root.right.right.left = new BinaryNode<>(3);
        ArrayList<LinkedList<Integer>> result = lister.listAtDepths(root);
        assertEquals(result.size(), 4);
        for(int i = 0; i < result.size(); i++) {
            for(Integer j in result[i]) {
                assertEquals(j, i);
            }
        }
    }
}
