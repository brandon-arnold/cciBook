package io.bna.ccibook.sortstack

/**
 * Created by brand on 11/4/2016.
 */
class SortStackTest extends GroovyTestCase {
    void testSort() {
        SortStack<Integer> sorter = new SortStack<>();
        Stack<Integer> s = new Stack<>();
        s.push(5);
        s.push(20);
        s.push(13);
        s.push(-2);
        s.push(-100);
        s.push(20);
        s.push(25);
        sorter.sort(s);
        assertEquals(-100, s.pop());
        assertEquals(-2, s.pop());
        assertEquals(5, s.pop());
        assertEquals(13, s.pop());
        assertEquals(20, s.pop());
        assertEquals(20, s.pop());
        assertEquals(25, s.pop());
    }
}
