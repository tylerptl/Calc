package com.example.tyler.calculatornew;

import java.util.Deque;
import java.util.LinkedList;

public abstract class RPNCalculator<T> {
    public T evaluate(String expression) {
        if(expression == null || expression.length() == 0) {
            throw new IllegalArgumentException("Invalid Reverse Polish Expression");
        }

        String[] tokens = expression.split(" ");
        Deque<T> stack = new LinkedList<>();
        for (String token : tokens) {
            parseToken(token).process(stack);
        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid Reverse Polish Notation Provided");
        }
        return stack.poll();
    }

    protected abstract Token<T> parseToken(String token);
}