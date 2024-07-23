package com.myproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserListViewActivity extends AppCompatActivity {

    ListView listView;
    UserListAdapter adapter;
    DatabaseHelper databaseHelper;
    Spinner spinner;
    GridView gridView;
    UserSpinnerAdapter spinnerAdapter;
    String url = "https://softechnepal.com/exam/service.php?task=getStudent";// Mobile and server different device
//    String url = "http://orchidcollege.com/mobile/connect.php";// live server different device
//    String url = "http://10.0.2.2/mobile/connect.php"; // EMULATOR AND SERVER SAME dEVICE

    TextView response;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.userlistview_layout);
        listView = findViewById(R.id.listview);
        gridView = findViewById(R.id.gridview);
        databaseHelper = new DatabaseHelper(this);
        adapter = new UserListAdapter(this, databaseHelper.getUsers());
        listView.setAdapter(adapter);
        gridView.setAdapter(adapter);
        response = findViewById(R.id.response);
        spinner = findViewById(R.id.spinner);
        spinnerAdapter = new UserSpinnerAdapter(this, databaseHelper.getUsers());
        spinner.setAdapter(spinnerAdapter);
//
//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        fetchData();


    }


    public void fetchData(){
        RequestQueue queue = Volley.newRequestQueue(this);


// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String serverresponse) {
                        response.setText(serverresponse);
                        // Display the first 500 characters of the response string.
                        Log.i("response","Response is: " + serverresponse);
                        parseJson(serverresponse);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                response.setText(error.toString());
                Log.i("response","error");

            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);
    }
    public void parseJson(String response){
        try {
            JSONObject object = new JSONObject(response);
            JSONArray result = object.getJSONArray("result");
            ArrayList<Userinfo> list = new ArrayList<>();
            for (int i = 0 ; i<result.length();i++){
                Userinfo info = new Userinfo();
                JSONObject obj = result.getJSONObject(i);
                info.id = obj.getString("id");
                info.username = obj.getString("name");
                info.email = obj.getString("name");
                list.add(info);


            }
            adapter = new UserListAdapter(this, list);
            listView.setAdapter(adapter);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }


}
