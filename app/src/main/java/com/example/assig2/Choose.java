package com.example.assig2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Choose extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);
    }

    public void currencyOnClick (View view){
        Intent intent=new Intent(this , APICurruncy.class);
        startActivity(intent);
    }

    public void NewsOnClick (View view ){
        Intent intent=new Intent(this , APIBored.class);
        startActivity(intent);
    }

    public void goBack (View view){
        Intent intent=new Intent(this , MainActivity.class);
        startActivity(intent);
    }
}