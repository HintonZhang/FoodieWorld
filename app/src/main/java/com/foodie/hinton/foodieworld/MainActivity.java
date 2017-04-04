package com.foodie.hinton.foodieworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.foodie.model.User;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.io.StringReader;

public class MainActivity extends AppCompatActivity {
    EditText edit_username;
    EditText edit_password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_username = (EditText) findViewById(R.id.edit_username);
        edit_password = (EditText) findViewById(R.id.edit_password);
    }

    public void login(View view){
        AsyncHttpClient client = new AsyncHttpClient();
        System.out.println("-----------------------------------------------------------------");
        client.get(" http://192.168.48.1/GradPro/user/login?username="+edit_username.getText().toString()+"&password="+edit_password.getText().toString(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes) {
                String info = new String(bytes);
                User userJson = new Gson().fromJson(info, User.class);
                userJson = userJson.getUser();
                System.out.print("onSuccess");
                System.out.println("+++++"+userJson.getUsername()+"++++++");
                Intent intent = new Intent(MainActivity.this,UserActivity.class);

                intent.putExtra("user",userJson);
                startActivity(intent);
            }

            @Override
            public void onFailure(int i, cz.msebera.android.httpclient.Header[] headers, byte[] bytes, Throwable throwable) {
                System.out.print("onFailure");
            }
        });
    }
}
