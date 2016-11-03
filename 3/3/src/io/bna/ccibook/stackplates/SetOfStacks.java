package io.bna.ccibook.stackplates;

import io.bna.ccibook.common.Stack;

/**
 * Created by brand on 11/3/2016.
 */
public class SetOfStacks<T> {
    private int maxElems = 5;
    private Stack<Stack<T>> stacks = new Stack<>();

    public SetOfStacks(int size){
        maxElems = size;
    }

    public void push(T val) {
        Stack<T> curStack;
        if(stacks.getLength() == 0 || stacks.peek().getLength() == maxElems) {
            curStack = new Stack<T>();
            curStack.push(val);
            stacks.push(curStack);
        } else {
            curStack = stacks.peek();
            curStack.push(val);
        }
    }

    public T pop() {
        if(stacks.getLength() == 0) {
            throw new IndexOutOfBoundsException();
        } else {
            Stack<T> curStack = stacks.peek();
            if(curStack.getLength() == 1) {
                stacks.pop();
            }
            return curStack.pop();
        }
    }

    public T popAt(int i) {
        if(i >= stacks.getLength()) {
            throw new IndexOutOfBoundsException();
        } else {
            Stack<T> curStack = stacks.peekAt(i);
            if(curStack.getLength() == 1) {
                stacks.popAt(i);
            }
            return curStack.pop();
        }
    }
}
