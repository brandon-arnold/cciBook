package io.bna.ccibook.detectloop

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 10/5/2016.
 */
class LoopDetectionStrategyTest extends GroovyTestCase {
    LinkedList<Integer> noLoop, loop5, loop50;

    void setUp() {
        noLoop = new LinkedList<Integer>([0, 1, 2, 3, 4, 5, 6, 7, 8, 9] as Integer[]);
        loop5 = new LinkedList<Integer>([0, 1, 2, 3, 4, 5, 6, 7, 8, 9] as Integer[]);
        loop5.getTail().next = loop5.next.next.next.next.next;
        loop50 = new LinkedList<Integer>(0);
        LinkedList<Integer> cur = loop50;
        for(int i = 1; i < 100; i++) {
            cur.next = new LinkedList<>(i);
            cur = cur.next;
        }
        cur.next = loop50.getNth(50);
    }

    void testRunnerDetectionStrat() {
        RunnerDetectionStrat strat = new RunnerDetectionStrat();
        assertNull(strat.getLoopStart(noLoop));
        assertEquals(5, strat.getLoopStart(loop5).data);
        assertEquals(50, strat.getLoopStart(loop50).data);
    }
}
