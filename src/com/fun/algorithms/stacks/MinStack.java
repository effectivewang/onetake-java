package com.fun.algorithms.stacks;

import java.util.Stack;

/**
 * Leetcode: https://oj.leetcode.com/problems/min-stack/
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);

        if (minStack.size() == 0) {
            minStack.push(x);
        } else {
            Integer curMin = minStack.peek();
            if (x <= curMin) {
                minStack.push(x);
            }
        }
    }

    public void pop() {
        if (stack.size() > 0) {
            int x = stack.pop();
            if (x == getMin()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (stack.size() == 0) return 0;
        return stack.peek();
    }

    public int getMin() {
        if (minStack.size() == 0) return 0;
        return minStack.peek();
    }
}
