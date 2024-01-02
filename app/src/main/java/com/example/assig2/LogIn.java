package com.example.assig2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {

    public static final String NAME = "Name";
    public static final String PASS = "Password";
    public static final String FLAG = "Flag";
    private boolean flag = false;
    private EditText NameTXT;
    private EditText PasswordTXT;
    private CheckBox rememberChx;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        setupViews();
        setupSharedPrefs();
        checkPrefs();
    }

    private void setupViews() {
        NameTXT = findViewById(R.id.nameText);
        PasswordTXT = findViewById(R.id.passwordText);
        rememberChx = findViewById(R.id.rememberChx);
    }
    private void checkPrefs() {
        flag = prefs.getBoolean(FLAG, false);

        if(flag){
            String name = prefs.getString(NAME, "");
            String password = prefs.getString(PASS, "");
            NameTXT.setText(name);
            PasswordTXT.setText(password);
            rememberChx.setChecked(true);
        }
    }
    private void setupSharedPrefs() {
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }

    public void loginButtonOnClick (View view){

            String name = NameTXT.getText().toString();
            String password = PasswordTXT.getText().toString();

            if (name.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Name and password can not be empty!!", Toast.LENGTH_SHORT).show();
                return;
            } else {

                Intent intent = new Intent(this, Choose.class);
                startActivity(intent);
            }

            if (rememberChx.isChecked()) {
                    editor.putString(NAME, name);
                    editor.putString(PASS, password);
                    editor.putBoolean(FLAG, true);
                    editor.apply();
            }
            }
        }

