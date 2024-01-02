package com.example.assig2;

        import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.preference.PreferenceManager;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.Toast;

public class Register extends AppCompatActivity {

    public static final String NAME = "NAME";

    public static final String EMAIL = "EMAIL";
    public static final String PASS = "PASS";

    public static final String FLAG = "Flag";

    private EditText NameTXT;

    private EditText EmailTXT;
    private EditText PasswordTXT;


    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setupViews();
        setupSharedPrefs();
    }

    public void registerOnClick (View view){

        String name = NameTXT.getText().toString();
        String password = PasswordTXT.getText().toString();
        String Email = EmailTXT.getText().toString();

        if (name.isEmpty() || password.isEmpty() || Email.isEmpty()) {
            Toast.makeText(this, "Name, password and Email can not be empty!!", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            Intent intent=new Intent(this , LogIn.class);
            startActivity(intent);
        }
        editor.putString(NAME, name);
        editor.putString(PASS, password);
        editor.putString(EMAIL, Email);
        editor.putBoolean(FLAG, true);
        editor.apply();

        Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show();
    }
    private void setupViews (){
        NameTXT = findViewById(R.id.nameText);
        EmailTXT = findViewById(R.id.emailReg);
        PasswordTXT = findViewById(R.id.passwordText);
    }

    private void setupSharedPrefs (){
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor = prefs.edit();
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}