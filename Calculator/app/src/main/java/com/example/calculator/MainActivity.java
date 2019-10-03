package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView inputNumber;
    boolean numIsPressed = false;
    boolean operationIsPressed = false;
    boolean dividedBeZero = false;
    boolean initialState = true;

    private Button btnNum0, btnNum1, btnNum2, btnNum3, btnNum4, btnNum5, btnNum6, btnNum7, btnNum8, btnNum9;

    private Button btnEqual, btnDelete, btnC, btnDot;

    private Button btnPlus, btnMinus, btnMultiply, btnDivide, btnSquare, btnSqrt;

    private double number1, number2, result;

    enum Sign {
        PLUS, MINUS, MULTIPLY, DIVIDE, SQUARE, SQRT
    }
    private Sign sign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("lifecycle", "onCreate");

        inputNumber = findViewById(R.id.textView2);

        btnNum0 = findViewById(R.id.num0);
        btnNum1 = findViewById(R.id.num1);
        btnNum2 = findViewById(R.id.num2);
        btnNum3 = findViewById(R.id.num3);
        btnNum4 = findViewById(R.id.num4);
        btnNum5 = findViewById(R.id.num5);
        btnNum6 = findViewById(R.id.num6);
        btnNum7 = findViewById(R.id.num7);
        btnNum8 = findViewById(R.id.num8);
        btnNum9 = findViewById(R.id.num9);

        btnDelete = findViewById(R.id.delete);
        btnC = findViewById(R.id.c);
        btnEqual = findViewById(R.id.equal);
        btnDot = findViewById(R.id.dot);
        btnSquare = findViewById(R.id.square);
        btnSqrt= findViewById(R.id.sqrt);

        btnPlus = findViewById(R.id.plus);
        btnMinus = findViewById(R.id.minus);
        btnMultiply = findViewById(R.id.multiply);
        btnDivide = findViewById(R.id.divide);

        btnNum0.setOnClickListener(this);
        btnNum1.setOnClickListener(this);
        btnNum2.setOnClickListener(this);
        btnNum3.setOnClickListener(this);
        btnNum4.setOnClickListener(this);
        btnNum5.setOnClickListener(this);
        btnNum6.setOnClickListener(this);
        btnNum7.setOnClickListener(this);
        btnNum8.setOnClickListener(this);
        btnNum9.setOnClickListener(this);

        btnDelete.setOnClickListener(this);
        btnEqual.setOnClickListener(this);
        btnDot.setOnClickListener(this);
        btnC.setOnClickListener(this);
        btnSquare.setOnClickListener(this);
        btnSqrt.setOnClickListener(this);

        btnPlus.setOnClickListener(this);
        btnMinus.setOnClickListener(this);
        btnMultiply.setOnClickListener(this);
        btnDivide.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch (view.getId()) {
            case R.id.num0: {
                numIsPressed=true;
                operationIsPressed=false;
                initialState = false;

                if(dividedBeZero){
                    inputNumber.setText("");
                    dividedBeZero=false;
                }
                if(inputNumber.getText().toString().startsWith("0")){
                    inputNumber.setText("0");
                }
                else
                    inputNumber.append("0");
                break;
            }
            case R.id.num1: {
                numIsPressed=true;
                operationIsPressed=false;
                initialState = false;
                if(dividedBeZero){
                    inputNumber.setText("");
                    dividedBeZero=false;
                }
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("1");
                break;
            }
            case R.id.num2: {
                initialState = false;
                numIsPressed=true;
                operationIsPressed=false;

                if(dividedBeZero){
                    inputNumber.setText("");
                    dividedBeZero=false;
                }
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("2");
                break;
            }
            case R.id.num3: {
                numIsPressed=true;
                initialState = false;
                operationIsPressed=false;
                if(dividedBeZero){
                    inputNumber.setText("");
                    dividedBeZero=false;
                }
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("3");
                break;
            }
            case R.id.num4: {
                numIsPressed=true;
                initialState = false;
                operationIsPressed=false;
                if(dividedBeZero){
                    inputNumber.setText("");
                    dividedBeZero=false;
                }
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("4");
                break;
            }
            case R.id.num5: {
                numIsPressed=true;
                initialState = false;
                operationIsPressed=false;
                if(dividedBeZero){
                    inputNumber.setText("");
                    dividedBeZero=false;
                }
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("5");
                break;
            }
            case R.id.num6: {
                numIsPressed=true;
                initialState = false;
                operationIsPressed=false;
                if(dividedBeZero){
                    inputNumber.setText("");
                    dividedBeZero=false;
                }
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("6");
                break;
            }
            case R.id.num7: {
                numIsPressed=true;
                initialState = false;
                operationIsPressed=false;
                if(dividedBeZero){
                    inputNumber.setText("");
                }
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                    dividedBeZero=false;
                }
                inputNumber.append("7");
                break;
            }
            case R.id.num8: {
                numIsPressed=true;
                initialState = false;
                operationIsPressed=false;
                if(dividedBeZero){
                    inputNumber.setText("");
                    dividedBeZero=false;
                }
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("8");
                break;
            }
            case R.id.num9: {
                initialState = false;
                numIsPressed=true;
                operationIsPressed=false;
                if(dividedBeZero){
                    inputNumber.setText("");
                    dividedBeZero=false;
                }
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("9");
                break;
            }
            case R.id.dot: {
                if(inputNumber.getText().toString().contains(".")){
                   break;
                }
                else {
                    if (!numIsPressed) {
                        inputNumber.setText("0");
                        inputNumber.append(".");
                    } else
                        inputNumber.append(".");
                    initialState = false;
                    break;
                }
            }
            case R.id.c: {
                inputNumber.setText("");
                numIsPressed=false;
                operationIsPressed=false;
                dividedBeZero=false;
                initialState = true;
                break;
            }
            case R.id.delete: {
                numIsPressed=false;
                operationIsPressed=false;
                String s = inputNumber.getText().toString();
                if(dividedBeZero){
                    inputNumber.setText("");
                    dividedBeZero=false;
                    break;
                }
                else {
                    if (s.length() >= 1) {
                        s = s.substring(0, s.length() - 1);
                        inputNumber.setText(s);
                    }
                    if (s.length() < 1) {
                        inputNumber.setText("");
                        initialState = true;
                    }
                    break;
                }
            }
            case R.id.plus: {
                numIsPressed=false;
                if(initialState || operationIsPressed)
                    return;
                else{
                    operationIsPressed=true;
                    number1 = Double.parseDouble(inputNumber.getText().toString());
                    inputNumber.setText("");
                    sign = Sign.PLUS;
                    break;
                }
            }
            case R.id.minus: {
                numIsPressed = false;
                if(initialState || operationIsPressed)
                    return;
                else {
                    operationIsPressed = true;
                    number1 = Double.parseDouble(inputNumber.getText().toString());
                    inputNumber.setText("");
                    sign = Sign.MINUS;
                    break;
                }
            }
            case R.id.multiply: {
                if(initialState || operationIsPressed)
                    return;
                else{
                    operationIsPressed=true;
                    number1 = Double.parseDouble(inputNumber.getText().toString());
                    inputNumber.setText("");
                    sign = Sign.MULTIPLY;
                    break;
                }
            }
            case R.id.divide: {
                if(initialState || operationIsPressed)
                    return;
                else{
                    operationIsPressed=true;
                    number1 = Double.parseDouble(inputNumber.getText().toString());
                    inputNumber.setText("");
                    sign = Sign.DIVIDE;
                    break;
                }
            }
            case R.id.equal: {
                numIsPressed=false;
                if(initialState)
                    return;
                if(operationIsPressed && sign==Sign.PLUS){
                    result=number1+number1;
                    if (result - (int) result == 0) {
                        inputNumber.setText(String.valueOf((int) result));
                    } else
                        inputNumber.setText(String.valueOf(result));
                    break;
                }
                if(operationIsPressed && sign==Sign.MINUS){
                    result=number1-number1;
                    if (result - (int) result == 0) {
                        inputNumber.setText(String.valueOf((int) result));
                    } else
                        inputNumber.setText(String.valueOf(result));
                    break;
                }
                if(operationIsPressed && sign==Sign.MULTIPLY){
                    result=number1*number1;
                    if (result - (int) result == 0) {
                        inputNumber.setText(String.valueOf((int) result));
                    } else
                        inputNumber.setText(String.valueOf(result));
                    break;
                }
                if(operationIsPressed && sign==Sign.DIVIDE){
                    result=number1/number1;
                    if (result - (int) result == 0) {
                        inputNumber.setText(String.valueOf((int) result));
                    } else
                        inputNumber.setText(String.valueOf(result));
                    break;
                }
                else {
                    number2 = Double.parseDouble(inputNumber.getText().toString());
                    if (sign == Sign.PLUS) {
                        result = number1 + number2;
                    }
                    if (sign == Sign.MINUS) {
                        result = number1 - number2;
                    }
                    if (sign == Sign.MULTIPLY) {
                        result = number1 * number2;
                    }
                    if (sign == Sign.DIVIDE) {
                        if (number2 == 0) {
                            dividedBeZero = true;
                        }
                        result = number1 / number2;
                    }
                    if (result - (int) result == 0) {
                        inputNumber.setText(String.valueOf((int) result));
                    } else
                        inputNumber.setText(String.valueOf(result));
                    break;
                }
            }
            case R.id.square: {
                if(initialState)
                    return;
                if(operationIsPressed){
                    result=number1*number1;
                    if(result-(int)result==0) {
                        inputNumber.setText(String.valueOf((int)result));
                    }
                    else
                        inputNumber.setText(String.valueOf(result));
                    break;
                }
                else {
                    numIsPressed=false;
                    number1 = Double.parseDouble(inputNumber.getText().toString());
                    result = number1*number1;
                    if(result-(int)result==0) {
                        inputNumber.setText(String.valueOf((int)result));
                    }
                    else
                        inputNumber.setText(String.valueOf(result));
                    break;
                }

            }
            case R.id.sqrt: {
                if(initialState)
                    return;
                if(operationIsPressed){
                    if(number1<0) {
                        dividedBeZero = true;
                        inputNumber.setText("error");
                    }
                    else {
                        result = Math.sqrt(number1);
                        if (result - (int) result == 0) {
                            inputNumber.setText(String.valueOf((int) result));
                        } else
                            inputNumber.setText(String.valueOf(result));
                        break;
                    }
                }
                else{
                    numIsPressed = false;
                    number1 = Double.parseDouble(inputNumber.getText().toString());
                    if(number1<0) {
                        dividedBeZero = true;
                        inputNumber.setText("error");
                    }
                    else {
                        result = Math.sqrt(number1);
                        if (result - (int) result == 0) {
                            inputNumber.setText(String.valueOf((int) result));
                        } else
                            inputNumber.setText(String.valueOf(result));
                        break;
                    }
                }
            }
        }
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        inputNumber.setText(savedInstanceState.getString("inputNumber"));
        number1=savedInstanceState.getDouble("number1");
        number2=savedInstanceState.getDouble("number2");
        result=savedInstanceState.getDouble("result");
        numIsPressed=savedInstanceState.getBoolean("numIsPressed");
        operationIsPressed=savedInstanceState.getBoolean("operationIsPressed");
        initialState=savedInstanceState.getBoolean("initialState");
        dividedBeZero=savedInstanceState.getBoolean("dividedBeZero");
//        sign=savedInstanceState.getString("sign");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("inputNumber",inputNumber.getText().toString());
        outState.putDouble("number1",number1);
        outState.putDouble("number2",number2);
        outState.putDouble("result",result);
        outState.putBoolean("numIsPressed", numIsPressed);
        outState.putBoolean("operationIsPressed", operationIsPressed);
        outState.putBoolean("dividedBeZero", dividedBeZero);
        outState.putBoolean("initialState", initialState);
//        outState.putSerializable("sign", sign);
    }
}
