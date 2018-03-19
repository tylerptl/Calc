package com.example.tyler.calculatornew;

public class MultiplyInteger extends BinaryOperator<Integer>{



    @Override
    protected Integer calc(Integer a, Integer b) {
        double total = a*b;


        if (total > Integer.MAX_VALUE) {
            throw new ArithmeticException("Integer value overflow");
        }
        if (total < Integer.MIN_VALUE) {
            throw new ArithmeticException("Integer value underflow");
        }
        return (int) total;
    }
}
