package io.bna.ccibook.common.sort;

import io.bna.ccibook.common.MaxHeap;
import io.bna.ccibook.common.SortStrategy;

import java.util.ArrayList;

import static java.util.Collections.swap;

/**
 * Created by brand on 3/2/2017.
 */
public class HeapSorter<T extends Comparable> implements SortStrategy<T> {
    @Override
    public void sort(ArrayList<T> s) {
        MaxHeap.heapify(s);
        for(int i = s.size() - 1; i > 0; i--) {
            swap(s, 0, i);
            MaxHeap.bubbleDownRoot(s, i);
        }
    }
}
