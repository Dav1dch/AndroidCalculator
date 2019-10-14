package com.tuffy.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView count;
    EditText userName;
    EditText password;
    private Integer times = 3;
    private void init(){
        count = findViewById(R.id.counts);
        count.setText(" " + times.toString());
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.exit).setOnClickListener(this);
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
            case R.id.login:
                String passwd = "123456";
                if (!password.getText().toString().equals(passwd)){
                    Toast.makeText(this,"密码错误", Toast.LENGTH_SHORT).show();
                    times--;
                    count.setText(" "+times.toString());
                    if (times == 0){
                        findViewById(R.id.login).setClickable(false);
                        Toast.makeText(this,"无法登录", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    times = 3;
                    Toast.makeText(this,"登陆成功", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.exit:
                System.exit(0);
                break;
        }

    }
}
