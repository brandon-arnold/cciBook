package io.bna.ccibook.validatebst;

import io.bna.ccibook.common.BinaryNode;

/**
 * Created by brand on 11/16/2016.
 */
public class RecurseMinMaxValidateBST<T extends Comparable<T>> implements BstValidationStrategy<T> {
    @Override
    public boolean isBst(BinaryNode<T> b) {
        return checkMinMax(b.left, null, b.data) && checkMinMax(b.right, b.data, null);
    }

    private boolean checkMinMax(BinaryNode<T> b, T min, T max) {
        if(null != b) {
            if(null != min && b.data.compareTo(min) <= 0) {
                return false;
            }
            if(null != max && b.data.compareTo(max) > 0) {
                return false;
            }
            if(b.left != null && !checkMinMax(b.left, min, b.data)) {
                return false;
            }
            if(b.right != null && !checkMinMax(b.right, b.data, max)) {
                return false;
            }
        }
        return true;
    }
}
