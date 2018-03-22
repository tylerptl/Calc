package com.example.tyler.calculatornew;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;
import java.util.StringJoiner;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private TextView _screen;
    private String display = "";
    private String currentOperator = "";
    private String result = "";
    private String tempStr= "";
    private boolean isNeg =false;  // if the following number is not negative, this will allow it to become negative
    //private String eq = "";
    Stack parenthStack = new Stack();
   // private boolean nextIsRightPar = false;         // Checks need for ) instead of (
    String regex = "(?<=op)|(?=op)".replace("op", "[-+*/()]");
    RPNIntegerCalculator calc = new RPNIntegerCalculator();
    ReversePolishNotation rpn = new ReversePolishNotation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _screen = findViewById(R.id.textView);
        _screen.setText(display);


    }
    public void onClickNum(View v){
        if(display == "") {
            clear();
            updateScreen();
        }
        Button b = (Button) v;
        display+= b.getText();
        //eq += b.getText();
        updateScreen();
        //nextIsRightPar = true;
    }
    public void onClickOperator(View v){
        if(display == "") {
            clear();
            updateScreen();
        }
        Button b = (Button) v;
        display+= b.getText();
      //  eq += b.getText();
        updateScreen();
       // nextIsRightPar = false;
    }
    public void onClickParentheses(View v){
        if(parenthStack.isEmpty()){
            display += "(";
            //eq += "(";
            parenthStack.push("(");
            updateScreen();

        }else if(isOperator(display.charAt(display.length()-1))|| display.charAt(display.length()-1) == '(' ||display.charAt(display.length()-1) == 'L'){
            display += "(";
            //eq += "(";
            parenthStack.push("(");
            updateScreen();
//        }else if(!isOperator(display.charAt(display.length()-1)) && parenthStack.peek().equals('(')){
//            display += "R";
//            eq = ")";
//            parenthStack.pop();
//            updateScreen();
        }else{
            display +=")";
            //eq += ")";
            parenthStack.pop();
            updateScreen();
        }

    }
    public void onClickPosNeg(View v){
        if(display == "") {
            clear();
            updateScreen();
        }

        if(display.charAt(display.length()-1)=='+'){
            display = display.substring(0, display.length()-1) + '-';
            updateScreen();
            isNeg = true;
        }else if(display.charAt(display.length()-1)=='-'){
            display = display.substring(0, display.length()-1) + '+';
        }else{
            display += '-';
        }
    }

    public void onClickEquals(View v){
        if(display == "") return; // Empty screen check
        String[] arr = display.split(regex);
        String[] rpnArr = rpn.infixToRPN(arr);
        StringJoiner joiner = new StringJoiner(" ");

        for(String val : rpnArr){
            joiner.add(val);
        }
        String rpnStr = joiner.toString();
        result = calc.evaluate(rpnStr).toString();
        _screen.setText(display + "\n" + String.valueOf(result));



    }
    private void updateScreen(){
        _screen.setText(display);
    }

//    public void onClickNumber(View v){
//        if(result != ""){
//            clear();
//            updateScreen();
//        }
//
//        Button b = (Button) v;
//        display += b.getText();
//        updateScreen();
//    }
    private boolean isOperator(char op){ // Still need to add exponent and √
        switch(op){
            case '√':
            case 'x':
            case '+':
            case '-':
            case '÷': return true;
            default: return false;

        }
    }

//    public void onClickOperator(View v){
//        if(display == "") return;
//        Button b = (Button)v;
//        if(result != ""){
//            String _display = result;
//            clear();
//            display = _display;
//        }
//
//        if(currentOperator != ""){
//            Log.d("CalcX", ""+display.charAt(display.length()-1));
//            if(isOperator(display.charAt(display.length()-1))){
//                display = display.replace(display.charAt(display.length()-1), b.getText().charAt(0));
//                updateScreen();
//                return;
//            }else{
//                getResult();
//                display = result;
//                result = "";
//            }
//            currentOperator = b.getText().toString();
//        }
//        display += b.getText();
//        currentOperator = b.getText().toString();
//        updateScreen();
//    }


    public void clear(){
        display = "";
        currentOperator = "";
        result = "";
        //eq= "";
        while(!parenthStack.isEmpty()){
            parenthStack.pop();
        }
    }

    public void onClickClear(View v){
        clear();
        updateScreen();

    }




    public void signChange(View v){
        Button b = (Button)v;
        tempStr = b.getText().toString();
        if(tempStr.equals(0)){
            return;
        }else
            if(tempStr.charAt(0) == '-'){

        }

    }
}