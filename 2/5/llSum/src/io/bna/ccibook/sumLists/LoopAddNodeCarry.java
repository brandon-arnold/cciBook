package io.bna.ccibook.sumLists;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 9/30/2016.
 */
public class LoopAddNodeCarry implements SumLlStrategy {
    @Override
    public LinkedList<Integer> add(LinkedList<Integer> x, LinkedList<Integer> y) {
        LinkedList<Integer> out = new LinkedList<>(x.data + y.data),
                            curOut = out,
                            curX = x.next,
                            curY = y.next;
        int carry = out.data / 10;
        curOut.data %= 10;
        while(curX != null || curY != null) {
            int curXVal = curX != null ? curX.data : 0,
                curYVal = curY != null ? curY.data : 0;
            curOut.next = new LinkedList<>(curXVal + curYVal + carry);
            carry = curOut.next.data / 10;
            curOut = curOut.next;
            curOut.data %= 10;
            curX = curX != null ? curX.next : null;
            curY = curY != null ? curY.next : null;
        }
        if(carry > 0) {
            curOut.next = new LinkedList<>(carry);
        }
        return out;
    }
}
