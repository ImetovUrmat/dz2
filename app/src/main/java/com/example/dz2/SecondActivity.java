package com.example.dz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.dz2.databinding.ActivitySecondBinding;

public class SecondActivity extends AppCompatActivity {
ActivitySecondBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySecondBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getValue();

    }

    private void getValue(){
        String someValue = getIntent().getStringExtra("key");
        binding.resultTv.setText(someValue);
    }


}