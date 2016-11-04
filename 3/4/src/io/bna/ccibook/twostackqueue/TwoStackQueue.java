package io.bna.ccibook.twostackqueue;

import java.util.Stack;

/**
 * Created by brand on 11/4/2016.
 */
public class TwoStackQueue<T> {
    private Stack<T> enQStack = new Stack<>(),
                     deQStack = new Stack<>();

    void enqueue(T val) {
        if(enQStack.isEmpty()) {
            while(!deQStack.isEmpty()) {
                enQStack.push(deQStack.pop());
            }
        }
        enQStack.push(val);
    }

    T dequeue() throws Exception {
        if(deQStack.isEmpty()) {
            if(enQStack.isEmpty()) {
                throw new Exception("Nothing to dequeue.");
            }
            do {
                deQStack.push(enQStack.pop());
            } while(!enQStack.isEmpty());
        }
        return deQStack.pop();
    }
}
