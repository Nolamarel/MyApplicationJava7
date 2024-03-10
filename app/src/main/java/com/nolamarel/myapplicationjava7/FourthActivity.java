package com.nolamarel.myapplicationjava7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.nolamarel.myapplicationjava7.databinding.ActivityFourthBinding;

public class FourthActivity extends AppCompatActivity {
    private ActivityFourthBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFourthBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle userAge = getIntent().getExtras();
        if(userAge != null) {
            int age = userAge.getInt("age", 0);
            binding.textView3.setText("Ваш возраст: " + age);
        } else {
            binding.textView3.setText("Данные о возрасте не были переданы.");
        }
        binding.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FourthActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
            }
        });
    }
}