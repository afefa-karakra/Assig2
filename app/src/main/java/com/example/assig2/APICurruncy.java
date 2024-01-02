package com.example.assig2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import java.util.Iterator;


public  class APICurruncy extends AppCompatActivity {

    private RequestQueue queue;
    private ListView ListCurruncy;

    public APICurruncy() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apicurruncy);

        queue = Volley.newRequestQueue(this);
        ListCurruncy = findViewById(R.id.ListNews);

    }

    public void curruncyOnClick(View view) {

        String url = "https://open.er-api.com/v6/latest";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                ArrayList<String> currencies = new ArrayList<>();
                try {
                    JSONObject rates = response.getJSONObject("rates");
                    Iterator<String> keys = rates.keys();
                    while (keys.hasNext()) {
                        String currencyCode = keys.next();
                        currencies.add(currencyCode + ": " + rates.getDouble(currencyCode));
                    }
                } catch (JSONException exception) {
                    Log.d("volley_error", exception.toString());
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(APICurruncy.this,
                        android.R.layout.simple_list_item_1, currencies);
                ListCurruncy.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("volley_error", error.toString());
            }
        });

        queue.add(request);

    }

    public void goBack (View view){
        Intent intent=new Intent(this , Choose.class);
        startActivity(intent);
    }
}