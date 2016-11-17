package io.bna.ccibook.validatebst

import io.bna.ccibook.common.BinaryNode

/**
 * Created by brand on 11/16/2016.
 */
class BstValidationStrategyTest extends GroovyTestCase {
    void testStrategy(BstValidationStrategy s) {
        BinaryNode<Integer> root = new BinaryNode<>(50);
        root.left = new BinaryNode<>(25);
        root.right = new BinaryNode<>(75);
        root.left.left = new BinaryNode<>(12);
        root.left.right = new BinaryNode<>(37);
        root.right.left = new BinaryNode<>(63);
        root.right.right = new BinaryNode<>(87);
        assertTrue(s.isBst(root));
        root.left.right.right = new BinaryNode(51);
        assertFalse(s.isBst(root));
    }

    void testInOrderValidateBst() {
        InOrderValidateBST<Integer> s = new InOrderValidateBST();
        testStrategy(s);
    }

    void testRecurseMinMaxValidateBst() {
        RecurseMinMaxValidateBST<Integer> s = new RecurseMinMaxValidateBST<>();
        testStrategy(s);
    }
}
