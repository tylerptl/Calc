package com.example.tyler.calculatornew;



public class ExponentDouble extends BinaryOperator<Double>{
    @Override
    protected Double calc(Double a, Double b) {
        Double total = Math.pow(a,b);

        if (total > Double.MAX_VALUE) {
            throw new ArithmeticException("Integer value overflow");
        }
        if (total < Double.MIN_VALUE) {
            throw new ArithmeticException("Integer value underflow");
        }
        return total;
    }
}
