package io.bna.ccibook.common;

import java.util.ArrayList;

/**
 * Created by brand on 3/2/2017.
 */
public interface SortStrategy<T extends Comparable> {
    void sort(ArrayList<T> s);
}
