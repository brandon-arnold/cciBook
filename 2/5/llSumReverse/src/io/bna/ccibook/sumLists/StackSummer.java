package io.bna.ccibook.sumLists;

import io.bna.ccibook.common.LinkedList;

import java.util.Stack;

/**
 * Created by brand on 9/30/2016.
 */
public class StackSummer implements SumLlStrategy {
    @Override
    public LinkedList<Integer> add(LinkedList<Integer> x, LinkedList<Integer> y) {
        if(x == null) return y;
        if(y == null) return x;
        Stack<Integer> xs = new Stack<>(),
                       ys = new Stack<>();
        LinkedList<Integer> curX = x, curY = y;
        while(curX != null) { xs.push(x.data);
                              curX = curX.next; }
        while(curY != null) { ys.push(y.data);
                              curY = curY.next; }
        int carry = 0, xi, yi, sum;
        Stack<Integer> outS = new Stack<>();
        while(!xs.isEmpty() || !ys.isEmpty()) {
            xi = xs.isEmpty() ? 0 : xs.pop();
            yi = ys.isEmpty() ? 0 : ys.pop();
            sum = xi + yi + carry;
            carry = sum / 10;
            sum %= 10;
            outS.push(sum);
        }
        if(carry != 0) outS.push(carry);
        LinkedList<Integer> out = new LinkedList<>(outS.pop()),
                            curOut = out;
        while(!outS.isEmpty()) {
            curOut.next = new LinkedList<>(outS.pop());
            curOut = curOut.next;
        }
        return out;
    }
}
