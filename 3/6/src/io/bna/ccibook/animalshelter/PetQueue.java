package io.bna.ccibook.animalshelter;

/**
 * Created by brand on 11/4/2016.
 */
public class PetQueue {
    private PetNode dogs = null,
                    cats = null,
                    catsTail = null,
                    dogsTail = null,
                    any = null,
                    anyTail = null;

    public void enqueue(Integer id, PetType type) {
        PetNode n = new PetNode(id, type);
        if(any != null) {
            n.next = any;
            any.prev = n;
        } else {
            anyTail = n;
        }
        any = n;
        if(type == PetType.DOG) {
            n.nextSame = dogs;
            dogs = n;
            if(dogsTail == null) {
                dogsTail = n;
            } else {
                dogs.nextSame.prevSame = dogs;
            }
        } else {
            n.nextSame = cats;
            cats = n;
            if(catsTail == null) {
                catsTail = cats;
            } else {
                cats.nextSame.prevSame = cats;
            }
        }
    }

    public Integer dequeueType(PetType type) throws Exception {
        PetNode cur;
        if(type == PetType.DOG) {
            if(dogs == null) {
                throw new Exception("No pet of that type to dequeue.");
            }
            cur = dogsTail;
            if(dogs != cur) {
                dogsTail = cur.prevSame;
                cur.prevSame.nextSame = null;
            } else {
                dogs = null;
                dogsTail = null;
            }
        } else {
            if(cats == null) {
                throw new Exception("No pet of that type to dequeue.");
            }
            cur = catsTail;
            if(cats != cur) {
                catsTail = cur.nextSame;
                cur.prevSame.nextSame = null;
            } else {
                cats = null;
                catsTail = null;
            }
        }
        if(cur.next != null) {
            if(cur.prev != null) {
                cur.prev.next = cur.next;
            }
            cur.next.prev = cur.prev;
        } else {
            anyTail = cur.prev;
            if(cur.prev != null) {
                cur.prev.next = null;
            } else {
                any = null;
            }
        }
        return cur.id;
    }

    public Integer dequeue() throws Exception {
        if(any == null) {
            throw new Exception("Nothing to dequeue.");
        }
        PetNode cur = anyTail;
        if(cur.prev != null) {
            cur.prev.next = null;
            anyTail = cur.prev;
        } else {
            any = null;
            anyTail = null;
        }
        if(cur.type == PetType.DOG) {
            dogsTail = cur.prevSame;
            if(cur.prevSame != null) {
                cur.prevSame.nextSame = null;
            } else {
                dogs = null;
            }
        } else {
            catsTail = cur.prevSame;
            if(cur.prevSame != null) {
                cur.prevSame.nextSame = null;
            } else {
                cats = null;
            }
        }
        return cur.id;
    }
}
