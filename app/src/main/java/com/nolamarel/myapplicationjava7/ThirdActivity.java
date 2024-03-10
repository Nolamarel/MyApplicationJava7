package com.nolamarel.myapplicationjava7;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import com.nolamarel.myapplicationjava7.databinding.ActivityThirdBinding;

import java.io.IOException;

public class ThirdActivity extends AppCompatActivity {
    private ActivityThirdBinding binding;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityThirdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAge();
            }
        });
        }

        private void checkAge(){
            age = Integer.parseInt(binding.editTextText.getText().toString());
            if(age < 18){
                Toast.makeText(this, "Несовершеннолетним проход запрещен", Toast.LENGTH_SHORT).show();
            } else{
                Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                intent.putExtra("age", age);
                startActivity(intent);
            }
        }
    }