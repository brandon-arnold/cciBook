package io.bna.ccibook.interll

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 10/5/2016.
 */
class IntersectionSearchStrategyTest extends GroovyTestCase {
    void testIntersectionSearchStrategy(IntersectionSearchStrategy strat) {
        LinkedList<Integer> ll1 = new LinkedList<>([1, 2, 3, 4, 5, 6] as Integer[]);
        LinkedList<Integer> ll2 = new LinkedList<>([7, 8, 9, 10, 11, 12] as Integer[]);
        assertNull(strat.hasIntersection(ll1, ll2));
        ll1.getTail().next = ll2.next.next.next;
        assertNotNull(strat.hasIntersection(ll1, ll2));
        assertEquals(ll2.next.next.next, strat.hasIntersection(ll1, ll2));
    }

    void testAllComparisonStrat() {
        AllComparisonStrat strat = new AllComparisonStrat();
        testIntersectionSearchStrategy(strat);
    }

    void testDictionaryStrat() {
        DictionaryStrat strat = new DictionaryStrat();
        testIntersectionSearchStrategy(strat);
    }

    void testTruncateIfIntersectStrat() {
        TruncateIfIntersectStrat strat = new TruncateIfIntersectStrat();
        testIntersectionSearchStrategy(strat);
    }
}
