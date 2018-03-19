package com.example.tyler.calculatornew;

import java.util.Deque;


public abstract class BinaryOperator<T> implements Token<T> {

    @Override
    public void process(Deque<T> stack) {
        int numOfOperand = 2;
        if(stack == null) {
            throw new IllegalArgumentException("Stack is empty");
        }
        if(stack.size() < numOfOperand) {
            throw new IllegalArgumentException("There is not enough elements to calculate");
        }

        T secondNumber = stack.pop();
        T firstNumber = stack.pop();
        stack.push(calc(firstNumber, secondNumber));
    }

    protected abstract T calc(T a, T b);
}