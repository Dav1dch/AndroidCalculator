package com.canon.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button buttonAC;
    Button buttonDel;
    Button buttonPercent;
    Button buttonDivide;
    Button button7;
    Button button8;
    Button button9;
    Button buttonMuti;
    Button button4;
    Button button5;
    Button button6;
    Button buttonMinus;
    Button button1;
    Button button2;
    Button button3;
    Button buttonPlus;
    Button buttonDot;
    Button button0;
    Button buttonEqual;
    TextView text;
    private StringBuilder result = new StringBuilder();

    private void init(){
        text = findViewById(R.id.textview);
        button0 = (Button) findViewById(R.id.button0);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);
        buttonAC = (Button) findViewById(R.id.buttonAC);
        buttonDel = (Button) findViewById(R.id.buttonDEL);
        buttonMinus = (Button) findViewById(R.id.buttonMinus);
        buttonMuti = (Button) findViewById(R.id.buttonMuti);
        buttonEqual = (Button) findViewById(R.id.buttonEqual);
        buttonDivide = (Button) findViewById(R.id.buttonDivide);
        buttonPercent = (Button) findViewById(R.id.buttonPercent);
        buttonDot = (Button) findViewById(R.id.buttonDot);
        buttonPlus = (Button) findViewById(R.id.buttonPlus);


        buttonPlus.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonDel.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMuti.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button0:
                result.append("0");
                text.setText(result);
                break;

            case R.id.button1:
                result.append("1");
                text.setText(result);
                break;

            case R.id.button2:
                result.append("2");
                text.setText(result);
                break;

            case R.id.button3:
                result.append("3");
                text.setText(result);
                break;

            case R.id.button4:
                result.append("4");
                text.setText(result);
                break;

            case R.id.button5:
                result.append("5");
                text.setText(result);
                break;

            case R.id.button6:
                result.append("6");
                text.setText(result);
                break;

            case R.id.button7:
                result.append("7");
                text.setText(result);
                break;

            case R.id.button8:
                result.append("8");
                text.setText(result);
                break;

            case R.id.button9:
                result.append("9");
                text.setText(result);
                break;

            case R.id.buttonDot:
                result.append(".");
                text.setText(result);
                break;

            case R.id.buttonPercent:
                result.append("%");
                text.setText(result);
                break;

            case R.id.buttonPlus:
                result.append("+");
                text.setText(result);
                break;

            case R.id.buttonMinus:
                result.append("-");
                text.setText(result);
                break;

            case R.id.buttonDEL:
                result.deleteCharAt(result.length()-1);
                text.setText(result);
                break;

            case R.id.buttonMuti:
                result.append("*");
                text.setText(result);
                break;

            case R.id.buttonAC:
                result.delete(0, result.length());
                text.setText(result);
                break;


            case R.id.buttonEqual:
                result.append("=");
                text.setText(result);
                break;
            case R.id.buttonDivide:
                result.append("/");
                text.setText(result);
                break;

        }
    }
}
