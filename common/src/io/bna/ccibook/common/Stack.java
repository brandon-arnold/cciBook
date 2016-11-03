package io.bna.ccibook.common;

/**
 * Created by brand on 11/3/2016.
 */
public class Stack<T> {
    DoublyLinkedList<T> list;

    public int getLength() {
        if(list == null) { return 0; }
        return list.getLength();
    }

    public void push(T val) {
        if(list == null) {
            list = new DoublyLinkedList<T>(val);
        } else {
            list.addToTail(val);
        }
    }

    public T pop() {
        if(list == null) {
            throw new IndexOutOfBoundsException();
        } else if(list.getLength() == 1) {
            DoublyLinkedList<T> temp = list;
            list = null;
            return temp.data;
        } else {
            DoublyLinkedList<T> temp = list.getTail();
            temp.prev.next = null;
            return temp.data;
        }
    }

    public T peek() {
        if(list == null) {
            throw new IndexOutOfBoundsException();
        } else {
            return list.getTail().data;
        }
    }

    public T popAt(int i) {
        if (i >= list.getLength()) {
            throw new IndexOutOfBoundsException();
        } else {
            DoublyLinkedList<T> elem = list.getNth(i);
            if(elem.prev != null) {
                elem.prev.next = elem.next;
            } else {
                list = elem.next;
            }
            if(elem.next != null) {
                elem.next.prev = elem.prev;
            }
            return elem.data;
        }
    }

    public T peekAt(int i) {
        if (i >= list.getLength()) {
            throw new IndexOutOfBoundsException();
        } else {
            return list.getNth(i).data;
        }
    }
}
