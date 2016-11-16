package io.bna.ccibook.insertst

import io.bna.ccibook.common.BinaryNode

/**
 * Created by brand on 11/16/2016.
 */
class IterativeSTBuilderTest extends GroovyTestCase {
    void testStrat(SortedInsertionStrategy s) {
        Integer[] list = [1, 2, 3, 4, 5, 6, 7, 8, 20, 30, 40] as Integer[];
        BinaryNode<Integer> result = s.makeTree(list);
        assertEquals(result.data, 6);
        assertEquals(result.left.data, 3);
        assertEquals(result.left.right.data, 4);
        assertNull(result.left.right.left);
    }

    void testIterative() {
        SortedInsertionStrategy s = new IterativeSTBuilder();
        testStrat(s);
    }
}
