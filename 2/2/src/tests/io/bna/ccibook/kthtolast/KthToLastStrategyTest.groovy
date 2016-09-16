package io.bna.ccibook.kthtolast

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/16/2016.
 */
class KthToLastStrategyTest extends GroovyTestCase {
    Integer[] ints = [99, 98, 97, 96, 95, 94, 93, 92, 91, 90, 89, 88] as Integer[]

    void testKthToLastStrategy(KthToLastStrategy<Integer> strat) {
        LinkedList intList = new LinkedList<Integer>(ints);
        int k = 1;
        while(k < ints.length) {
            Integer data = strat.kthToLast(intList, k);
            assertEquals(ints[ints.length - k], data);
            k++;
        }
    }

    void testRunnerKthToLastStrategy() {
        testKthToLastStrategy(new RunnerKthToLastStrategy())
    }

    void testKnownSizeKthToLastStrategy() {
        testKthToLastStrategy(new KnownSizeKthToLastStrategy<Integer>());
    }

    void testRecursiveKthToLastStrategy() {
        testKthToLastStrategy(new RecursiveKthToLastStrategy<Integer>());
    }
}
