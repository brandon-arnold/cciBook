package io.bna.ccibook.removedups

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
class DupRemovalStrategyTest extends GroovyTestCase {
    Integer[] ints = [1, 1, 2, 3, 4, 4, 4, 4, 5, 6, 7, 8, 8, 8, 8, 8, 8, 8, 8, 9] as Integer[];

    void runIntDupRemoval(DupRemovalStrategy<Integer> strat) {
        LinkedList intList = new LinkedList<Integer>(ints);
        strat.removeDups(intList);
        assertEquals(9, intList.getLength());
        int curI = 1;
        while(intList != null) {
            assertEquals(curI, intList.getData());
            curI++;
            intList = intList.next;
        }
        assertEquals(curI, 10);
    }

    void testDupHashStrategy() {
        runIntDupRemoval(new DupHashStrategy<Integer>());
    }

    void testInPlaceStrategy() {
        runIntDupRemoval(new InPlaceDupRemovalStrategy<Integer>());
    }
}
