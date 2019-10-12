package com.tuffy.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLOutput;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView count;
    EditText userName;
    EditText password;
    private void init(){
        count = findViewById(R.id.counts);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.password);
        findViewById(R.id.login).setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public void onClick(View v) {
        userName.setText(password.getText());
        String passwd = "123456";
        if (!password.getText().toString().equals(passwd)){
            Toast.makeText(this,"密码错误", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this,"登陆成功", Toast.LENGTH_SHORT).show();
        }

    }
}
