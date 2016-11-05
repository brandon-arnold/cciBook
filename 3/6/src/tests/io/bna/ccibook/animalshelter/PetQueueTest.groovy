package io.bna.ccibook.animalshelter

/**
 * Created by brand on 11/4/2016.
 */
class PetQueueTest extends GroovyTestCase {
    void testAll() {
        PetQueue q = new PetQueue();
        q.enqueue(1, PetType.DOG);
        q.enqueue(2, PetType.DOG);
        q.enqueue(3, PetType.DOG);
        q.enqueue(4, PetType.CAT);
        q.enqueue(5, PetType.CAT);
        q.enqueue(6, PetType.DOG);
        q.enqueue(7, PetType.DOG);
        q.enqueue(8, PetType.CAT);
        assertEquals(q.dequeue(), 1);
        assertEquals(q.dequeueType(PetType.CAT), 4);
        assertEquals(q.dequeueType(PetType.DOG), 2);
        assertEquals(q.dequeue(), 3);
        assertEquals(q.dequeueType(PetType.CAT), 5);
        assertEquals(q.dequeueType(PetType.CAT), 8);
        shouldFail(Exception) {
            q.dequeueType(PetType.CAT);
        }
        assertEquals(q.dequeue(), 6);
        assertEquals(q.dequeueType(PetType.DOG), 7);
        shouldFail(Exception) {
            q.dequeueType(PetType.DOG);
        }
        shouldFail(Exception) {
            q.dequeue();
        }
    }
}
