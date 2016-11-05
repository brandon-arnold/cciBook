package io.bna.ccibook.animalshelter;

/**
 * Created by brand on 11/4/2016.
 */
public class PetStack {
    private PetNode dogs = null,
                    cats = null,
                    any = null;

    public void push(Integer id, PetType type) {
        PetNode n = new PetNode(id, type);
        if(any != null) {
            n.next = any;
            any.prev = n;
        }
        any = n;
        if(type == PetType.DOG) {
            n.nextSame = dogs;
            dogs = n;
        } else {
            n.nextSame = cats;
            cats = n;
        }
    }

    public Integer popType(PetType type) throws Exception {
        PetNode cur;
        if(type == PetType.DOG) {
            if(dogs == null) {
                throw new Exception("No pet of that type to dequeue.");
            }
            cur = dogs;
            dogs = cur.nextSame;
        } else {
            if(cats == null) {
                throw new Exception("No pet of that type to dequeue.");
            }
            cur = cats;
            cats = cur.nextSame;
        }
        if(cur.prev != null) {
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
        } else {
            any = cur.next;
            any.prev = null;
        }
        return cur.id;
    }

    public Integer pop() throws Exception {
        if(any == null) {
            throw new Exception("Nothing to dequeue.");
        }
        PetNode cur = any;
        if(cur.next != null) {
            any.next.prev = null;
        }
        any = cur.next;
        if(cur.type == PetType.DOG) {
            dogs = cur.nextSame;
        } else {
            cats = cur.nextSame;
        }
        return cur.id;
    }
}
