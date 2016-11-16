package io.bna.ccibook.common

/**
 * Created by brand on 11/3/2016.
 */
class StackTest extends GroovyTestCase {
    void testOperations() {
        Stack testStack = new Stack<Integer>();
        testStack.push(5);
        testStack.push(7);
        testStack.push(8);
        testStack.push(2);
        assertEquals(testStack.pop(), 2);
        assertEquals(testStack.peek(), 8);
        assertEquals(testStack.peekAt(1), 7);
        assertEquals(testStack.pop(), 8);
        assertEquals(testStack.popAt(0), 5);
        assertEquals(testStack.pop(), 7);
        shouldFail(IndexOutOfBoundsException) {
            testStack.pop();
        }
    }
}
