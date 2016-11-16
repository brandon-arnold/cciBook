package io.bna.ccibook.isbalanced

import io.bna.ccibook.common.BinaryNode

/**
 * Created by brand on 11/14/2016.
 */
class ValidatedBalancedStrategyTests extends GroovyTestCase {
    void testStrat(ValidatedBalancedStrategy<Integer> s) {
        BinaryNode<Integer> tree = new BinaryNode();
        tree.left = new BinaryNode();
        tree.left.left = new BinaryNode();
        assertFalse(s.isBalanced(tree));
        tree.left.right = new BinaryNode();
        assertFalse(s.isBalanced(tree));
        tree.right = new BinaryNode();
        assertTrue(s.isBalanced(tree));
    }

    void testRecursive() {
        RecursiveBalanceChecker<Integer> strat = new RecursiveBalanceChecker<>();
        testStrat(strat);
    }

    void testIterative() {
        IterativeBalanceChecker<Integer> strat = new IterativeBalanceChecker<>();
        testStrat(strat);
    }
}
