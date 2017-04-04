package com.foodie.hinton.foodieworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.foodie.model.User;

public class UserActivity extends AppCompatActivity {
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Intent intent = getIntent();
        user = (User) intent.getSerializableExtra("user");

    }
}
