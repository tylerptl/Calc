package com.example.tyler.calculatornew;

public class SubtractInteger extends BinaryOperator<Integer>{

    @Override
    protected Integer calc(Integer a, Integer b){
        double total = a-b;

        if (total > Integer.MAX_VALUE){
            throw new ArithmeticException("Integer overflow");
        }
        if (total < Integer.MIN_VALUE){
            throw new ArithmeticException("Integer underflow");
        }
        return (int) total;
    }

}
