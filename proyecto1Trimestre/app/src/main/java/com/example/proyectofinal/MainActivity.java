package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btn_bienve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_bienve = findViewById(R.id.bienvenido);

        btn_bienve.setOnClickListener(v -> launchSecondActivity(v));
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, sobremi.class);
        startActivity(intent);

    }
}