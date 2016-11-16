package io.bna.ccibook.common

/**
 * Created by brand on 11/14/2016.
 */
class BinaryNodeTest extends GroovyTestCase {
    void testIntTree() {
        BinaryNode<Integer> root = new BinaryNode<Integer>(1);
        root.left = new BinaryNode<Integer>(3);
        root.right = new BinaryNode<Integer>(2);
        assertEquals(2, root.right.data);
    }
}
