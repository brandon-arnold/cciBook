package io.bna.ccibook.twostackqueue

/**
 * Created by brand on 11/4/2016.
 */
class TwoStackQueueTest extends GroovyTestCase {
    void testAll() {
        TwoStackQueue<Integer> q = new TwoStackQueue<Integer>();
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        assertEquals(3, q.dequeue());
        assertEquals(4, q.dequeue());
        assertEquals(5, q.dequeue());
        assertEquals(6, q.dequeue());
        q.enqueue(9);
        q.enqueue(10);
        assertEquals(7, q.dequeue());
        assertEquals(8, q.dequeue());
        assertEquals(9, q.dequeue());
        assertEquals(10, q.dequeue());
        shouldFail(Exception) {
            q.dequeue();
        }
    }
}
