package io.bna.ccibook.common;

import java.util.ArrayList;

import static java.util.Collections.swap;

/**
 * Created by brand on 3/2/2017.
 */
public class MaxHeap<T extends Comparable> {
    private ArrayList<T> heap = new ArrayList<T>();
    private int heapSize = 0;

    public MaxHeap() {}

    public MaxHeap(T rootData) {
        add(rootData);
    }

    public MaxHeap(ArrayList<T> array) {
        for(T item : array) add(item);
    }

    public ArrayList<T> getHeap() {
        return heap;
    }

    public void setHeap(ArrayList<T> value) {
        heap = value;
        heapSize = value.size();
    }

    public int getSize() {
        return heapSize;
    }

    public static <T extends Comparable<? super T>> void heapify(ArrayList<T> array) {
        int size = 1;
        for(int i = 1; i < array.size(); i++) {
            bubbleUp(array, i);
        }
    }

    private static <T extends Comparable<? super T>> void bubbleUp(ArrayList<T> array, int i) {
        int pIndex = (i - 1) / 2;
        while(array.get(pIndex).compareTo(array.get(i)) < 0) {
            swap(array, pIndex, i);
            i = pIndex;
            pIndex = (i - 1) / 2;
        }
    }

    public static <T extends Comparable<? super T>> void bubbleDownRoot(ArrayList<T> heap, int size) {
        int i = 0, lChild = 1, rChild = 2;
        while(lChild < size) {
            T lVal = heap.get(lChild);
            if(lVal.compareTo(heap.get(i)) > 0) {
                if(rChild < size) {
                    T rVal = heap.get(rChild);
                    if(rVal.compareTo(lVal) > 0) {
                        swap(heap, i, rChild);
                        i = rChild;
                    } else {
                        swap(heap, i, lChild);
                        i = lChild;
                    }
                } else {
                    swap(heap, i, lChild);
                    i = lChild;
                    break;
                }
            } else if(rChild < size) {
                T rVal = heap.get(rChild);
                if(rVal.compareTo(heap.get(i)) > 0) {
                    swap(heap, i, rChild);
                    i = rChild;
                } else { break; }
            } else {
                break;
            }
            lChild = (i * 2) + 1;
            rChild = (i * 2) + 2;
        }
    }

    public T getMax() throws Exception {
        if(heapSize == 0) {
            throw new Exception("The heap is empty");
        }
        return heap.get(0);
    }

    public T popMax() throws Exception {
        T max = getMax();
        T last = heap.remove(heapSize - 1);
        if(--heapSize == 0) { return last; }
        heap.set(0, last);
        bubbleDownRoot(heap, heapSize);
        return max;
    }

    public void add(T data) {
        heap.add(data);
        heapSize++;
        if(heapSize > 1) {
            int curIndex = heapSize - 1;
            int pIndex = (curIndex - 1) / 2;
            while(curIndex > 0 && heap.get(pIndex).compareTo(data) < 0) {
                swap(heap, pIndex, curIndex);
                curIndex = pIndex;
                pIndex = (curIndex - 1) / 2;
            }
        }
    }
}
