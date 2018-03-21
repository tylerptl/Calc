package com.example.tyler.calculatornew;

public class RPNIntegerCalculator extends RPNCalculator<Double> {

    protected Token<Double> parseToken(String token){
        switch(token) {
            case "+" :
                return new AddInteger();
            case "-" :
                return new SubtractInteger();
            case "*" :
                return new MultiplyInteger();
            case "/" :
                return new DivideInteger();
            default :
                try {
                    return new Operand<>(Double.parseDouble(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid Reverse Polish Token Found: " + token, e);
                }
        }
    }
}