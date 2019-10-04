/*tuffy*/

package com.canon.calculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import com.canon.calculator.calculate;
public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    TextView text, resultText;
    private StringBuilder result = new StringBuilder();

    private void init(){
       text = findViewById(R.id.textview);
       resultText = findViewById(R.id.resultview);
       findViewById(R.id.button0).setOnClickListener(this);
       findViewById(R.id.button1).setOnClickListener(this);
       findViewById(R.id.button2).setOnClickListener(this);
       findViewById(R.id.button3).setOnClickListener(this);
       findViewById(R.id.button4).setOnClickListener(this);
       findViewById(R.id.button5).setOnClickListener(this);
       findViewById(R.id.button6).setOnClickListener(this);
       findViewById(R.id.button7).setOnClickListener(this);
       findViewById(R.id.button8).setOnClickListener(this);
       findViewById(R.id.button9).setOnClickListener(this);
       findViewById(R.id.buttonLeft).setOnClickListener(this);
       findViewById(R.id.buttonRight).setOnClickListener(this);
       findViewById(R.id.buttonDEL).setOnClickListener(this);
       findViewById(R.id.buttonMinus).setOnClickListener(this);
       findViewById(R.id.buttonMuti).setOnClickListener(this);
       findViewById(R.id.buttonEqual).setOnClickListener(this);
       findViewById(R.id.buttonDivide).setOnClickListener(this);
       findViewById(R.id.buttonPercent).setOnClickListener(this);
       findViewById(R.id.buttonDot).setOnClickListener(this);
       findViewById(R.id.buttonPlus).setOnClickListener(this);
       findViewById(R.id.buttonDEL).setOnLongClickListener(this);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public boolean onLongClick(View v){
        int size = result.length();
        if (v.getId()==R.id.buttonDEL){
            result.delete(0, size);
            text.setText(result);
        }
        return true;
    }
    @Override
    public void onClick(View v) {
        int size = result.length();
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
                if (size == 0){
                    result.append('.');
                    text.setText(result);
                    break;
                }
                int tmp = size - 1;
                calculate cal = new calculate();
                int flag = 0;
                while (tmp >= 0 &&!cal.isSymbol(result.charAt(tmp))){
                    if(result.charAt(tmp) == '.') {
                           flag = 1;
                           break;
                        }
                    tmp--;
                    }

                if (flag == 0){
                    result.append(".");
                    text.setText(result);
                }
                break;

            case R.id.buttonPercent:
                if ((result.charAt(size-1) >= '0') && (result.charAt(size-1) <= '9')){
                    result.append("%");
                    text.setText(result);
                }

                break;

            case R.id.buttonPlus:
                if ((size > 0) && (result.charAt(size-1)=='-')){
                    result.deleteCharAt(size-1);
                }
                else if((size>0) && (result.charAt(size-1)=='-'))break;
                result.append("+");
                text.setText(result);
                break;

            case R.id.buttonMinus:
                if ((size > 0) && (result.charAt(size-1)=='+')){
                    result.deleteCharAt(size-1);
                }
                else if((size>0) && (result.charAt(size-1)=='-'))break;
                result.append("-");
                text.setText(result);
                break;

            case R.id.buttonDEL:
                if (size > 0){
                    result.deleteCharAt(result.length()-1);
                    text.setText(result);
                }
                break;

            case R.id.buttonMuti:
                if ((size == 0) || (result.charAt(size-1) == '*') || ((size > 2) && (result.charAt(size - 2) == '*'))){
                    break;
                }
                else if ((size>2) && (result.charAt(size-2)=='/')){
                    result.delete(size-2, size);
                }
                else if ((result.charAt(size-1)=='/') || (result.charAt(size-1)=='+') || (result.charAt(size-1)=='-')){
                    result.deleteCharAt(size-1);
                }
                result.append("*");
                text.setText(result);
                break;

            case R.id.buttonLeft:
                result.append("(");
                text.setText(result);
                break;

            case R.id.buttonRight:
                result.append(")");
                text.setText(result);
                break;

            case R.id.buttonEqual:
                if (size == 0){
                    break;
                }
                calculate calE = new calculate();
                result=new StringBuilder(calE.getResult(String.valueOf(result)));
                resultText.setText(result);
                if (String.valueOf(result).equals("error")){
                    result.delete(0, result.length());
                }
                break;
            case R.id.buttonDivide:
                if((size == 0) || (result.charAt(size-1) == '/') || ((size > 2) && (result.charAt(size - 2) == '/'))){
                    break;
                }
                else if ((size > 2) && (result.charAt(size-2)=='*')){
                    result.delete(size-2, size);
                }
                else if ((result.charAt(size-1)=='*') || (result.charAt(size-1)=='+') || (result.charAt(size-1)=='-')){
                    result.deleteCharAt(size-1);
                }
                result.append("/");
                text.setText(result);
                break;

        }
    }

}
