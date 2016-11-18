package io.bna.ccibook.successor

import io.bna.ccibook.common.BinaryNode

/**
 * Created by brand on 11/17/2016.
 */
class FindSuccessorStrategyTest extends GroovyTestCase {
    void testGeneralInt(FindSuccessorStrategy<Integer> s) {
        BinaryNode<Integer> root = new BinaryNode<>(50);
        root.addLeft(25);
        root.left.addLeft(12);
        root.left.addRight(37);
        root.addRight(75);
        root.right.addLeft(62);
        root.right.addRight(87);
        assertEquals(25, s.getSuccessor(root.left.left));
        assertEquals(37, s.getSuccessor(root.left));
        assertEquals(50, s.getSuccessor(root.left.right));
        assertEquals(62, s.getSuccessor(root));
        assertEquals(75, s.getSuccessor(root.right.left));
        assertEquals(87, s.getSuccessor(root.right));
        shouldFail(Exception) {
            s.getSuccessor(root.right.right);
        }
    }

    void testIterativeInOrderFinder() {
        IterativeInOrderFinder<Integer> s = new IterativeInOrderFinder<>();
        testGeneralInt(s);
    }
}
