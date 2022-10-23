package com.example.hitamstudent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText eName;
    private EditText ePassword;
    private Button eLogin;

    private final String Username = "Admin";
    private final String Password = "12345678";

    boolean isValid = false;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.btnLogin);


        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if (inputName.isEmpty() || inputPassword.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the details correctly", Toast.LENGTH_LONG).show();
                } else {

                    isValid = validate(inputName, inputPassword);

                    if (!isValid) {
                        Toast.makeText(MainActivity.this, "Incorrect credentials!", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_LONG).show();
                        //add code to new activity
                        Intent intent = new Intent(MainActivity.this, HomePage.class);
                        startActivity(intent);

                    }
                }


            }


        });

    }

private boolean validate(String name, String password){
    if(name.equalsIgnoreCase(Username) && password.equals(Password))
        return true;

    return false;
}
}