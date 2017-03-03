package io.bna.ccibook.common.sort

import io.bna.ccibook.common.SortStrategy

/**
 * Created by brand on 3/2/2017.
 */
class SortStrategyTest extends GroovyTestCase {
    ArrayList<Integer> t1, t2, t3;

    void setUp() {
        super.setUp();
        t1 = [0, 0, 1, 2, 3, 4, 5, 6, 7, 8, 8] as Integer[];
        t2 = [8, 8, 7, 6, 5, 4, 3, 2, 1, 0, 0] as Integer[];
        t3 = [8, 1, 6, 3, 8, 0, 5, 7, 2, 4, 0] as Integer[];
    }

    void tearDown() { }

    void verifyOrder(ArrayList<Integer> list) {
        for(int i = 1; i < list.size(); i++) {
            assertTrue(list[i].compareTo(list[i - 1]) >= 0);
        }
    }

    void testSortStrategy(SortStrategy s) {
        s.sort(t1);
        s.sort(t2);
        s.sort(t3);
        verifyOrder(t1);
        verifyOrder(t2);
        verifyOrder(t3);
    }

    void testHeapSorter() {
        HeapSorter<Integer> s = new HeapSorter<Integer>();
        testSortStrategy(s);
    }
}
