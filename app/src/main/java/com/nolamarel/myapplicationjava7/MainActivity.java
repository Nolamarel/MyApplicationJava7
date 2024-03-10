package com.nolamarel.myapplicationjava7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nolamarel.myapplicationjava7.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    public void onMyButtonClick(View view){
        String name = binding.userNameEt.getText().toString();
        String email = binding.userEmailEt.getText().toString();
        String password = binding.userPasswordEt.getText().toString();

        User user = new User(name, email, password);

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(User.class.getSimpleName(), user);
        startActivity(intent);
    }
}
