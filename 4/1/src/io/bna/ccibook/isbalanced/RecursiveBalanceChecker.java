package io.bna.ccibook.isbalanced;

import io.bna.ccibook.common.BinaryNode;

/**
 * Created by brand on 11/14/2016.
 */
public class RecursiveBalanceChecker<T> implements ValidatedBalancedStrategy<T> {

    class BalanceCheckResult {
        Integer depth;
        boolean isBalanced;
        public BalanceCheckResult(Integer depth, boolean isBalanced) {
            this.depth = depth;
            this.isBalanced = isBalanced;
        }
    }

    @Override
    public boolean isBalanced(BinaryNode<T> root) {
        return checkBalance(root).isBalanced;
    }

    private BalanceCheckResult checkBalance(BinaryNode<T> root) {
        if(null == root) {
            return new BalanceCheckResult(0, true);
        }
        BalanceCheckResult left = checkBalance(root.left);
        BalanceCheckResult right = checkBalance(root.right);
        boolean isBalanced = !left.isBalanced || !right.isBalanced || Math.abs(left.depth - right.depth) > 1;
        Integer depth = Math.max(left.depth, right.depth);
        return new BalanceCheckResult(depth, isBalanced);
    }
}
