package com.example.hw_41;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private TextView welcomeText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        loginButton = findViewById(R.id.login_button);
        welcomeText = findViewById(R.id.welcome_text);

        TextWatcher textWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String emailInput = emailEditText.getText().toString().trim();
                String passwordInput = passwordEditText.getText().toString().trim();

                if (!emailInput.isEmpty() && !passwordInput.isEmpty()) {
                    loginButton.setEnabled(true);
                    loginButton.setBackgroundTintList(getResources().getColorStateList(R.color.orange));
                } else {
                    loginButton.setEnabled(false);
                    loginButton.setBackgroundTintList(getResources().getColorStateList(R.color.gray));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        emailEditText.addTextChangedListener(textWatcher);
        passwordEditText.addTextChangedListener(textWatcher);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (email.equals("admin") && password.equals("admin")) {
                    Snackbar.make(v, "Вы успешно зарегистрировались", Snackbar.LENGTH_LONG).show();
                    emailEditText.setVisibility(View.GONE);
                    passwordEditText.setVisibility(View.GONE);
                    loginButton.setVisibility(View.GONE);
                    welcomeText.setText("Добро пожаловать!");
                } else {
                    Snackbar.make(v, "Неправильный логин и пароль", Snackbar.LENGTH_LONG).show();
                }
            }
        });
    }
}
