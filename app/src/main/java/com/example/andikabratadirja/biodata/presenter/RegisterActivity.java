package com.example.andikabratadirja.biodata.presenter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.andikabratadirja.biodata.R;
import com.example.andikabratadirja.biodata.model.Preferences;

/*

 Tanggal Pengerjaan : 11-08-2019
 NIM : 10116153
 NAMA : Andika Bratadirja SJ
 KELAS : IF - 4

 */

public class RegisterActivity extends AppCompatActivity implements IRegisterActivity {

    private EditText viewUsername, viewEmail, viewPassword, viewConfirmPassword;
    Button btnRegister;
    TextView linkLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        viewUsername = findViewById(R.id.inputUsername);
        viewEmail = findViewById(R.id.inputEmail);
        viewPassword = findViewById(R.id.inputPassword);
        viewConfirmPassword = findViewById(R.id.inputConfirmPassword);

        btnRegister = findViewById(R.id.buttonRegister);
        linkLogin = findViewById(R.id.linkLogin);

        viewConfirmPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL){
                    checkInputan();
                    return true;
                }
                return false;
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInputan();
            }
        });

        linkLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), LoginActivity.class));
            }
        });

    }

    @Override
    public void checkInputan() {
        viewUsername.setError(null);
        viewEmail.setError(null);
        viewPassword.setError(null);
        viewConfirmPassword.setError(null);
        View fokus = null;
        boolean cancel = false;

        /* Mengambil text dari Form User, Password, Repassword dengan variable baru bertipe String*/
        String Username = viewUsername.getText().toString();
        String Email = viewEmail.getText().toString();
        String Password = viewPassword.getText().toString();
        String confirmPassword = viewConfirmPassword.getText().toString();

        if (TextUtils.isEmpty(Username)){
            viewUsername.setError("This field is required");
            fokus = viewUsername;
            cancel = true;
        }else if (cekUser(Username)){
            viewUsername.setError("This is already exist");
            fokus = viewUsername;
            cancel= true;
        }

        if (TextUtils.isEmpty(Password)){
            viewPassword.setError("This field is required");
            fokus = viewPassword;
            cancel = true;
        }else if (!cekPassword(Password,confirmPassword)){
            viewConfirmPassword.setError("This password is incorrect");
            fokus = viewConfirmPassword;
            cancel= true;
        }

        if (cancel){
            fokus.requestFocus();
        }else {
            Preferences.setRegisteredUser(getBaseContext(),Username);
            Preferences.setRegisteredPass(getBaseContext(),Password);
            finish();
        }
    }

    @Override
    public boolean cekPassword(String Password, String confirmPassword) {
        return Password.equals(confirmPassword);
    }

    @Override
    public boolean cekUser(String Username) {
        return Username.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
}
