package io.bna.ccibook.stackplates

/**
 * Created by brand on 11/3/2016.
 */
class SetOfStacksTest extends GroovyTestCase {
    void testAll() {
        SetOfStacks<Integer> stacks = new SetOfStacks(3);
        stacks.push(5);
        stacks.push(7);
        stacks.push(10);
        stacks.push(50);
        stacks.push(20);
        assertEquals(stacks.popAt(1), 20);
        assertEquals(stacks.popAt(0), 10);
        assertEquals(stacks.pop(), 50);
        shouldFail(IndexOutOfBoundsException) {
            stacks.popAt(1);
        }
        assertEquals(stacks.pop(), 7);
        assertEquals(stacks.pop(), 5);
        shouldFail(IndexOutOfBoundsException) {
            stacks.pop();
        }
    }
}
