package com.example.dz2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.dz2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private boolean isCats, isDog, isHorse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initClickers();


    }

    private void initClickers() {
        binding.dogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.animalImg.setImageResource(R.drawable.dog);
                isDog = true;
                isCats = false;
                isHorse = false;
            }
        });
        binding.catBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.animalImg.setImageResource(R.drawable.cats);
                isCats = true;
                isHorse = false;
                isDog = false;
            }
        });
        binding.horseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.animalImg.setImageResource(R.drawable.horse);
                isHorse = true;
                isCats = false;
                isDog = false;
            }
        });
        binding.thatCatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isCats) {
                    Toast.makeText(MainActivity.this, "Да это кошка", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(MainActivity.this, " Это не кошка", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.thatDogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isDog) {
                    Toast.makeText(MainActivity.this, "Да это собака", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(MainActivity.this, "Это не собака", Toast.LENGTH_SHORT).show();
                }
            }
        });
        binding.thatHorseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isHorse) {
                    Toast.makeText(MainActivity.this, "Да это лошадь", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Это не лошадь", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.sendBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            if(isDog && !isCats && !isHorse) {
                intent.putExtra("key", "Это Собака");
            }else if(!isDog && isCats && !isHorse) {
                    intent.putExtra("key", "Это кошка");
            } else if (!isDog && !isCats && isHorse){
                intent.putExtra("key", "Это Лошадь");
            }
            startActivity(intent);
        });
    }

}