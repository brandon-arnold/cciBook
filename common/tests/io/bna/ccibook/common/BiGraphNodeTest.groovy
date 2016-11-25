package io.bna.ccibook.common

/**
 * Created by brand on 11/25/2016.
 */
class BiGraphNodeTest extends GroovyTestCase {
    void testAll() {
        List<BiGraphNode<Integer>> nodes = new ArrayList<>();
        for(int i = 0; i < 30; i++)
            nodes.add(new BiGraphNode<>(i));
        for(int i = 0; i < 29; i++) {
            nodes[i].mapTo(nodes[i + 1]);
        }
        for(int i = 1; i < 30; i++) {
            assertEquals(nodes[i - 1].out[0], nodes[i]);
            assertEquals(nodes[i].in[0], nodes[i - 1]);
        }
        for(int i = 0; i < 29; i++) {
            nodes[i].removeTo(nodes[i + 1]);
        }
        for(int i = 0; i < 30; i++) {
            assertEquals(nodes[i].out.size(), 0);
            assertEquals(nodes[i].in.size(), 0);
        }
        for(int i = 0; i < 29; i++) {
            nodes[i].mapBoth(nodes[i + 1]);
        }
        for(int i = 1; i < 30; i++) {
            assertTrue(nodes[i - 1].out.contains(nodes[i]));
            assertTrue(nodes[i - 1].in.contains(nodes[i]));
            assertTrue(nodes[i].out.contains(nodes[i - 1]));
            assertTrue(nodes[i].in.contains(nodes[i - 1]));
        }
        for(int i = 0; i < 29; i++) {
            nodes[i].removeBoth(nodes[i + 1]);
        }
        for(int i = 0; i < 30; i++) {
            assertEquals(nodes[i].out.size(), 0);
            assertEquals(nodes[i].in.size(), 0);
        }
    }
}
