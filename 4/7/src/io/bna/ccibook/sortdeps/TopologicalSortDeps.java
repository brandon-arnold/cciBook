package io.bna.ccibook.sortdeps;

import io.bna.ccibook.common.BiGraphNode;

import java.util.*;

/**
 * Created by brand on 11/25/2016.
 */
public class TopologicalSortDeps<T> {
    List<T> sort(List<BiGraphNode<T>> all) throws Exception {
        List<T> out = new ArrayList<T>();
        Queue<BiGraphNode<T>> noDep = new ArrayDeque<>();
        for (BiGraphNode<T> cur : all) {
            if (cur.in.size() == 0) {
                noDep.add(cur);
            }
        }
        while(!noDep.isEmpty()) {
            BiGraphNode<T> n = noDep.remove();
            for(int i = n.out.size() - 1; i > -1; i--) {
                BiGraphNode<T> curOutNode = n.out.get(i);
                n.removeTo(curOutNode);
                if(curOutNode.in.size() == 0 && !noDep.contains(curOutNode)) {
                    noDep.add(curOutNode);
                }
            }
            out.add(n.data);
        }
        for (BiGraphNode<T> n : all) {
            if(n.in.size() > 0) {
                throw new Exception("Cycle detected in graph; sort failed.");
            }
        }
        return out;
    }
}
