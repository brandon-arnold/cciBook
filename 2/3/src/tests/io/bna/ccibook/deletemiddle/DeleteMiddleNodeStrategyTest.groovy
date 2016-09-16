package io.bna.ccibook.deletemiddle

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
class DeleteMiddleNodeStrategyTest extends GroovyTestCase {
    Integer[] ints = [1, 2, 3, 4, 5, 6, 7, 8, 9] as Integer[];

    void testDeleteMiddleNodeStrategy(DeleteMiddleNodeStrategy<Integer> strat) {
        LinkedList<Integer> intList = new LinkedList<Integer>(ints);
        LinkedList<Integer> tail = intList.getTail();
        strat.delete(tail);
        assertTrue(tail.isDeleted);
        strat.delete(intList.next.next.next);
        assertEquals(8, intList.getLength())
    }

    void testBubbleDeleteNodeStrategy() {
        testDeleteMiddleNodeStrategy(new BubbleDeleteNodeStrategy<Integer>());
    }
}
