package com.example.tyler.calculatornew;

public class RPNIntegerCalculator extends RPNCalculator<Double> {

    protected Token<Double> parseToken(String token){
        switch(token) {
            case "+" :
                return new AddDouble();
            case "-" :
                return new SubtractDouble();
            case "*" :
                return new MultiplyDouble();
            case "/" :
                return new DivideDouble();
            case "^":
                return new ExponentDouble();
            default :
                try {
                    return new Operand<>(Double.parseDouble(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid Reverse Polish Token Found: " + token, e);
                }
        }
    }
}