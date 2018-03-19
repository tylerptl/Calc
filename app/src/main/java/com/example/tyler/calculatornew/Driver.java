package com.example.tyler.calculatornew;

//import java.util.StringJoiner;
//
//public class Driver {
//    public static void main(String[] args){
//        String input = "(5+3*8-42)/2";
//        String regex = "(?<=op)|(?=op)".replace("op", "[-+*/()]");
//
//        String[] arr = input.split(regex);
//
//
//        RPNIntegerCalculator calc = new RPNIntegerCalculator();
//        ReversePolishNotation rpn = new ReversePolishNotation();
//        String[] rpnArr = rpn.infixToRPN(arr);
//
//        StringJoiner joiner = new StringJoiner(" ");
//        for(String val : rpnArr){
//            joiner.add(val);
//        }
//
//        String rpnStr = joiner.toString();
//        System.out.println(rpnStr);
//        System.out.println(calc.evaluate(rpnStr));
//
//
//    }
//}
