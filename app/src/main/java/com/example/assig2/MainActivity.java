package com.example.assig2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void LoginOnClick (View view){
        Intent intent=new Intent(this , LogIn.class);
        startActivity(intent);
    }

    public void RegisterOnClick (View view){
        Intent intent=new Intent(this , Register.class);
        startActivity(intent);
    }
}