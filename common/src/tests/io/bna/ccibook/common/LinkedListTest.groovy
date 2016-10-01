package io.bna.ccibook.common

/**
 * Created by brand on 9/16/2016.
 */
class LinkedListTest extends GroovyTestCase {
    LinkedList threeNodes;

    void setUp() {
        LinkedList third = new LinkedList<Integer>(3);
        LinkedList second = new LinkedList<Integer>(50, third);
        this.threeNodes = new LinkedList<Integer>(34, second);
    }

    void test3Nodes() {
        LinkedList cur = threeNodes;
        int sum = 0;
        int count = 0;
        while(cur != null) {
            count++;
            sum += cur.getData();
            cur = cur.next;
        }
        assertEquals(87, sum);
        assertEquals(3, count);
    }

    void testGetTail() {
        assertEquals(3, threeNodes.getTail().getData());
    }

    void testAddToTail() {
        threeNodes.addToTail(2387);
        assertEquals(2387, threeNodes.getTail().getData());
    }

    void testListConstructor() {
        boolean threw = false;
        try {
            LinkedList shouldThrow = new LinkedList<Integer>([] as Integer[]);
        } catch(IllegalArgumentException e) {
            threw = true;
        }
        assertTrue(threw);
        //note that Groovy does not use the new String[] {...} syntax
        String[] strings = ["One", "Two", "Three", "Four", "Five"] as String[];
        LinkedList stringsList = new LinkedList<String>(strings);
        assertEquals(stringsList.getLength(), strings.length);
        for (int i = 0; i < strings.length; i++) {
            assertNotNull(stringsList);
            assertEquals(strings[i], stringsList.getData());
            stringsList = stringsList.next;
        }

        Character[] chars = "ONETWOTHREEFOUR".toCharArray();
        LinkedList<Character> charLl = new LinkedList<>(chars);
        assertEquals(chars.length, charLl.getLength());
    }
}
