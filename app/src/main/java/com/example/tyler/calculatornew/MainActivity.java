/**
 * @author Tyler Crill
 * 3/23/18
 */

package com.example.tyler.calculatornew;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Stack;
import java.util.StringJoiner;

public class MainActivity extends AppCompatActivity {
    private TextView _screen;
    private String display = "";
    private String currentOperator = "";
    private String result = "";
    private String tempStr= "";
    private Stack parenthStack = new Stack();

    String regex = "(?<=op)|(?=op)".replace("op", "[-+*/()^]");
    RPNIntegerCalculator calc = new RPNIntegerCalculator();
    ReversePolishNotation rpn = new ReversePolishNotation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _screen = findViewById(R.id.textView);
        _screen.setText(display);


    }

    /**
     * Method used when 0-9 are pressed - enters value into string
     * Currently is also used for operators
     * @param v
     */
    public void onClickNum(View v){
        if(display == "") {
            clear();
            updateScreen();
        }
        Button b = (Button) v;
        display+= b.getText();
        updateScreen();

    }
    public void onClickOperator(View v){
        if(display == "" || display == " ") {
            clear();
            updateScreen();
        }
        if(display.length() == 0){
            clear();
            updateScreen();
        }else {
            Button b = (Button) v;
            display += b.getText();
            updateScreen();
        }
    }

    public void onClickExponent(View v){
        if(display == "") {
            clear();
            updateScreen();
        }
        display += '^';
        updateScreen();
    }

    /**
     * Enters a parentheses into the string when pressed - accounts for multiple parentheses sets
     * @param v
     */
    public void onClickParentheses(View v){
        if(parenthStack.isEmpty()){
            display += "(";
            parenthStack.push("(");
            updateScreen();

        }else if(isOperator(display.charAt(display.length()-1))|| display.charAt(display.length()-1) == '(' ){
            display += "(";
            parenthStack.push("(");
            updateScreen();
        }else if(!isOperator(display.charAt(display.length()-1)) || parenthStack.peek().equals(')')){
            display += ")";
            parenthStack.pop();
            updateScreen();
        }else{
            display +=")";
            parenthStack.pop();
            updateScreen();
        }

    }

    /**
     * Currently allows the user to switch the sign of the following entry - does not currently work with x or /
     * @param v
     */
    public void onClickPosNeg(View v){
        if(display == "") {
            clear();
            updateScreen();
        }

        if(display.charAt(display.length()-1)=='+'){
            display = display.substring(0, display.length()-1) + '-';
            updateScreen();
        }else if(display.charAt(display.length()-1)=='-'){
            display = display.substring(0, display.length()-1) + '+';
        }else{
            display += '-';
        }
    }

    /**
     * Method finalizes the string and send it over to be parsed in ReversePolishNotation
     * @param v
     */
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
        display = result;



    }

    /**
     * Updates the screen with user entry as well as calculator output
     */
    private void updateScreen(){
        _screen.setText(display);
    }

    /**
     * Checks to see whether an entry is listed in the operator list
     * @param op
     * @return
     */
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

    /**
     * Clears the screen
     */
    public void clear(){
        display = "";
        currentOperator = "";
        result = "";
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