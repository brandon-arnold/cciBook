package io.bna.ccibook.animalshelter

/**
 * Created by brand on 11/4/2016.
 */
class PetStackTest extends GroovyTestCase {
    void testBoth() {
        PetStack s = new PetStack();
        s.push(1, PetType.DOG);
        s.push(2, PetType.DOG);
        s.push(3, PetType.DOG);
        s.push(4, PetType.CAT);
        s.push(5, PetType.CAT);
        s.push(6, PetType.DOG);
        s.push(7, PetType.DOG);
        s.push(8, PetType.CAT);
        assertEquals(s.pop(), 8);
        assertEquals(s.popType(PetType.DOG), 7);
        assertEquals(s.popType(PetType.CAT), 5);
        assertEquals(s.pop(), 6);
        assertEquals(s.pop(), 4);
        shouldFail(Exception) {
            s.popType(PetType.CAT);
        }
        assertEquals(s.pop(), 3);
        assertEquals(s.pop(), 2);
        assertEquals(s.pop(), 1);
        shouldFail(Exception) {
            s.popType(PetType.DOG);
        }
        shouldFail(Exception) {
            s.pop();
        }
    }
}
