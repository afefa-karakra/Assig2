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

public class APIBored extends AppCompatActivity {

    private RequestQueue queue;
    private ListView ListBored;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apinews);

        queue = Volley.newRequestQueue(this);
        ListBored = findViewById(R.id.ListNews);
    }

    public void newsOnClick(View view) {
        String url = "https://www.boredapi.com/api/activity";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url,
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                ArrayList<String> activityList = new ArrayList<>();
                try {
                    String activity = response.getString("activity");
                    activityList.add(activity);
                } catch (JSONException exception) {
                    Log.d("volley_error", exception.toString());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(APIBored.this,
                        android.R.layout.simple_list_item_1, activityList);
                ListBored.setAdapter(adapter);
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