package io.bna.ccibook.sumLists

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/30/2016.
 */
class SumLlStrategyTest extends GroovyTestCase {
    void testSumLlStrategy() {
        LinkedList<Integer> x = new LinkedList<Integer>([9, 9, 9] as Integer[]),
                            y = new LinkedList<Integer>([1] as Integer[]);
        SumLlStrategy strat = new StackSummer();
        LinkedList<Integer> result = strat.add(x, y);
        assertEquals(result.getLength(), 4);
        assertEquals(result.data, 1);
        assertEquals(result.next.data, 0);
        assertEquals(result.next.next.data, 0);
        assertEquals(result.next.next.next.data, 0);
    }
}
