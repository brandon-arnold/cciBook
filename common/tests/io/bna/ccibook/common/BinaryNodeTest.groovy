package io.bna.ccibook.common

/**
 * Created by brand on 11/14/2016.
 */
class BinaryNodeTest extends GroovyTestCase {
    void testIntTree() {
        BinaryNode<Integer> root = new BinaryNode<Integer>(1);
        root.addLeft(3);
        root.addRight(2);
        assertEquals(2, root.right.data);
        root.left.addLeft(7);
        root.left.left.addLeft(8);
        root.right.addLeft(root.left.left);
        assertNull(root.left.left);
        assertEquals(7,  root.right.left.data);
        shouldFail(Exception) {
            root.right.addLeft(9);
        }
    }
}
