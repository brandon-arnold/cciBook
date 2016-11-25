package io.bna.ccibook.sortdeps

import io.bna.ccibook.common.BiGraphNode

/**
 * Created by brand on 11/25/2016.
 */
class SortDepsTest extends GroovyTestCase {
    void testAll() {
        TopologicalSortDeps<Integer> strat = new TopologicalSortDeps<>()

        // mapping each node from the end to the beginning
        // should result in a reverse ordering
        List<BiGraphNode<Integer>> l = new ArrayList<>()
        for(int i = 0; i < 30; i++) {
            l.add(new BiGraphNode<>(i))
        }
        for(int i = 29; i > 0; i--) {
            l[i].mapTo(l[i - 1])
        }
        List<Integer> result = strat.sort(l);
        for(int i = 0; i < 30; i++) {
            assertEquals(result[i], 29 - i)
        }

        // 0, 1, 3 -> 2 -> 4 should return 4, 2, and then the rest
        l = new ArrayList<>()
        for(int i = 0; i < 5; i++) {
            l.add(new BiGraphNode<>(i))
        }
        l[4].mapTo(l[0])
        l[4].mapTo(l[1])
        l[4].mapTo(l[2])
        l[4].mapTo(l[3])
        l[2].mapTo(l[0])
        l[2].mapTo(l[1])
        l[2].mapTo(l[3])
        result = strat.sort(l)
        assertEquals(result[0], 4)
        assertEquals(result[1], 2)
    }
}
