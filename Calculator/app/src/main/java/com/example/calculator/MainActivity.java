package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputNumber;

    private Button btnNum0;
    private Button btnNum1;
    private Button btnNum2;
    private Button btnNum3;
    private Button btnNum4;
    private Button btnNum5;
    private Button btnNum6;
    private Button btnNum7;
    private Button btnNum8;
    private Button btnNum9;

    private Button btnEqual;
    private Button btnDelete;
    private Button btnDot;

    private Button btnPlus;
    private Button btnMinus;
    private Button btnMultiply;
    private Button btnDivide;
    private Button btnSquare;
    private Button btnSqrt;

    private double number1;
    private double number2;
    private double result;

    enum Sign {
        PLUS, MINUS, MULTIPLY, DIVIDE, SQUARE, SQRT
    }
    private Sign sign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber = findViewById(R.id.editText);
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
                if(inputNumber.getText().toString().startsWith("0")){
                    inputNumber.setText("");
                }
                else
                    inputNumber.append("0");
                break;
            }
            case R.id.num1: {
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("1");
                break;
            }
            case R.id.num2: {
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("2");
                break;
            }
            case R.id.num3: {
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("3");
                break;
            }
            case R.id.num4: {
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("4");
                break;
            }
            case R.id.num5: {
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("5");
                break;
            }
            case R.id.num6: {
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("6");
                break;
            }
            case R.id.num7: {
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("7");
                break;
            }
            case R.id.num8: {
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("8");
                break;
            }
            case R.id.num9: {
                if(inputNumber.getText().toString().startsWith("0") && !inputNumber.getText().toString().contains(".")){
                    inputNumber.setText("");
                }
                inputNumber.append("9");
                break;
            }
            case R.id.dot: {
                if(inputNumber.getText().toString()==""){
                    inputNumber.setText("0");
                }
                inputNumber.append(".");
                break;
            }
            case R.id.plus: {
                number1 = Double.parseDouble(inputNumber.getText().toString());
                inputNumber.setText("");
                sign = Sign.PLUS;
                break;
            }
            case R.id.minus: {
                number1 = Double.parseDouble(inputNumber.getText().toString());
                inputNumber.setText("");
                sign = Sign.MINUS;
                break;
            }
            case R.id.multiply: {
                number1 = Double.parseDouble(inputNumber.getText().toString());
                inputNumber.setText("");
                sign = Sign.MULTIPLY;
                break;
            }
            case R.id.divide: {
                number1 = Double.parseDouble(inputNumber.getText().toString());
                inputNumber.setText("");
                sign = Sign.DIVIDE;
                break;
            }
            case R.id.equal: {
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
                    result = number1 / number2;
                }
                inputNumber.setText(String.valueOf(result));
                break;
            }
            case R.id.delete: {
                inputNumber.setText("");
                break;
            }
            case R.id.square: {
                number1 = Integer.parseInt(inputNumber.getText().toString());
                result = number1*number1;
                inputNumber.setText(String.valueOf(result));
                break;
            }
            case R.id.sqrt: {
                number1 = Double.parseDouble(inputNumber.getText().toString());
                result = Math.sqrt(number1);
                inputNumber.setText(String.valueOf(result));
                break;
            }
        }
    }
}
