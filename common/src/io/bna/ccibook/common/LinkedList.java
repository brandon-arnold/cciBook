package io.bna.ccibook.common;

/**
 * Created by brand on 9/16/2016.
 */
public class LinkedList<T> {
    public T data;
    public boolean isDeleted = false;
    public LinkedList<T> next = null;

    public LinkedList(T data) {
        this.data = data;
    }

    public LinkedList(T data, LinkedList<T> next) {
        this.data = data;
        this.next = next;
    }

    public LinkedList(T[] listData) {
        if(listData.length == 0)
            throw new IllegalArgumentException("Initializing list must have elements");
        this.data = listData[0];
        for(int i = listData.length; i > 1; i--)
            this.next = new LinkedList<T>(listData[i - 1], this.next);
    }

    public T getData() {
        return data;
    }

    public LinkedList<T> getTail() {
        if(next == null) return this;
        LinkedList<T> tail = next;
        while(tail.next != null)
            tail = tail.next;
        return tail;
    }

    public void addToTail(T data) {
        LinkedList<T> tail = getTail();
        tail.next = new LinkedList<T>(data);
    }

    public int getLength() {
        int length = 1;
        LinkedList<T> cur = next;
        while(cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }
}
