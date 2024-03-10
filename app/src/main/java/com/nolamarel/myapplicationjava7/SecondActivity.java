package com.nolamarel.myapplicationjava7;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.nolamarel.myapplicationjava7.databinding.ActivityMainBinding;
import com.nolamarel.myapplicationjava7.databinding.ActivitySecondBinding;

import java.io.IOException;

public class SecondActivity extends AppCompatActivity {

    private ActivitySecondBinding binding;
    private String name, email, password;
    private Bitmap bitmap;
    private Uri selectedImageUri;
    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK && result.getData() != null) {
                        selectedImageUri = result.getData().getData();

                        try {
                            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
                            binding.imageView.setImageBitmap(bitmap);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }}});

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle arguments = getIntent().getExtras();

        User user;
        if(arguments != null){
            user = arguments.getParcelable(User.class.getSimpleName());
            name = user.getName();
            email = user.getEmail();
            password = user.getPassword();
            binding.infoUser.setText("Имя пользователя: " + name + "\nПочта: "+ email + "\nПароль: " + password);
        }

        binding.button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
                activityResultLauncher.launch(intent);
            }
        });

        binding.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectImage();
            }
        });

    }

    private void selectImage(){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(intent.ACTION_GET_CONTENT);
        activityResultLauncher.launch(intent);
    }
}