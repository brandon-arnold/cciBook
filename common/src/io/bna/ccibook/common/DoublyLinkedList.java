package io.bna.ccibook.common;

/**
 * Created by brand on 11/3/2016.
 */
public class DoublyLinkedList<T> {

    public T data;
    public DoublyLinkedList<T> next = null;
    public DoublyLinkedList<T> prev = null;

    public DoublyLinkedList(T data) {
        this.data = data;
    }

    public DoublyLinkedList(T data, DoublyLinkedList<T> next) {
        this.data = data;
        this.next = next;
    }

    public DoublyLinkedList(T[] listData) {
        if(listData.length == 0)
            throw new IllegalArgumentException("Initializing list must have elements");
        this.data = listData[0];
        for(int i = listData.length; i > 1; i--)
            this.next = new DoublyLinkedList<T>(listData[i - 1], this.next);
    }

    public T getData() {
        return data;
    }

    public DoublyLinkedList<T> getTail() {
        if(next == null) return this;
        DoublyLinkedList<T> tail = next;
        while(tail.next != null)
            tail = tail.next;
        return tail;
    }

    public void addToTail(T data) {
        DoublyLinkedList<T> tail = getTail();
        tail.next = new DoublyLinkedList<T>(data);
        tail.next.prev = tail;
    }

    public int getLength() {
        int length = 1;
        DoublyLinkedList<T> cur = next;
        while(cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    public DoublyLinkedList<T> getNth(int n) {
        if(n == 0) {
            return this;
        }
        DoublyLinkedList<T> cur = next;
        while(n > 1) {
            if(cur == null) {
                return null;
            }
            cur = cur.next;
            n--;
        }
        return cur;
    }
}
