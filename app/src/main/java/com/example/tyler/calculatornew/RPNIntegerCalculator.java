package com.example.tyler.calculatornew;

import java.util.ArrayList;
import java.util.List;

public class RPNIntegerCalculator extends RPNCalculator<Integer> {

    protected Token<Integer> parseToken(String token){
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
                    return new Operand<>(Integer.decode(token));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid Reverse Polish Token Found: " + token, e);
                }
        }
    }
}