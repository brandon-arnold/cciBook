package io.bna.ccibook.common

/**
 * Created by brand on 3/2/2017.
 */
class MaxHeapTest extends GroovyTestCase {
    MaxHeap<Integer> heap = new MaxHeap();

    void setUp() {
        super.setUp()

    }

    void tearDown() {

    }

    void testAdd() {
        heap.add(4);
        heap.add(20);
        heap.add(-2);
        heap.add(10);
        heap.add(15);
        heap.add(400);
        assertEquals(400, heap.popMax());
        assertEquals(20, heap.popMax());
        assertEquals(15, heap.popMax());
        assertEquals(10, heap.popMax());
        assertEquals(4, heap.popMax());
        assertEquals(-2, heap.popMax());
    }

    void testHeapify() {
        ArrayList<Integer> list = [13, 2, 100, -5, -8, -10, 365, 22, 80] as Integer[];
        MaxHeap.heapify(list);
        MaxHeap heap = new MaxHeap();
        heap.setHeap(list);
        int curMax = heap.popMax();
        while(heap.getSize() > 0) {
            assertTrue(heap.getMax() < curMax);
            curMax = heap.popMax();
        }
    }
}
