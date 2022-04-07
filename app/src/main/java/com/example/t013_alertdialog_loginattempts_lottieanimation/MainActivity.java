package com.example.t013_alertdialog_loginattempts_lottieanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText login , password ;
    Button btn_login;
    TextView txt_attempts;
    int totalattempts = 5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.login) ;
        password = findViewById(R.id.password);
        btn_login = findViewById(R.id.btn_login);
        txt_attempts = findViewById(R.id.txt_attempts);
        txt_attempts.setText(Integer.toString(totalattempts));

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String LOGIN = login.getText().toString();
                String PASSWORD = password.getText().toString();

                if (LOGIN.isEmpty()){
                    login.setError("Please Enter Username");
                    login.requestFocus();
                    return;
                }
                if (PASSWORD.isEmpty()){
                    password.setError("Please Enter Password");
                    password.requestFocus();
                    return;
                }

                if (LOGIN.equals("admin") && PASSWORD.equals("123")){
                    Intent intent = new Intent(MainActivity.this , LogoutActivity.class);
                    intent.putExtra("LOGINKEY", LOGIN);
                    startActivity(intent);
                }
                else {
                    totalattempts-- ;
                    txt_attempts.setText(Integer.toString(totalattempts));
                    if (totalattempts == 0){
                        btn_login.setVisibility(View.GONE);
                    }

                }


            }
        });
    }
}