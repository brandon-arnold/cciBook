package io.bna.ccibook.partitionll

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
class PartitionLlStrategyTest extends GroovyTestCase {
    Integer[] ints = [150, 151, 2, 53, 34, 55, 89, 200, 0, -5, 82] as Integer[];

    void testStrategy(PartitionLlStrategy<Integer> strat) {
        LinkedList<Integer> intList = new LinkedList<Integer>(ints);
        strat.partition(intList, 50);
        assertEquals(ints.length, intList.getLength());
        boolean lastWasLessThanK = true;
        for(int i = 0; i < intList.getLength(); i++) {
            boolean thisIsLessThanK = intList.data.compareTo(50) < 0;
            if(!thisIsLessThanK) lastWasLessThanK = false;
            assert(lastWasLessThanK == thisIsLessThanK);
            intList = intList.next;
        }
    }

    void testIterativeNewGreaterListStrategy() {
        testStrategy(new IterativeNewGreaterListStrategy<Integer>());
    }

    void testGreaterLessStacksPartitionStrategy() {
        testStrategy(new GreaterLessStacksPartitionStrategy<Integer>());
    }

    void testInsertLesserAtBeginningStrategy() {
        testStrategy(new InsertLesserAtBeginningStrategy<Integer>());
    }
}
