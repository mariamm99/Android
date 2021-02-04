package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class alimentos extends AppCompatActivity {
    private static final String LOG_TAG = alimentos.class.getSimpleName();
    private Button buttontexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alimentos);

        findViewById(R.id.button2).setOnClickListener(v -> launchPrimaryActivity(v));
        findViewById(R.id.button3).setOnClickListener(v -> launchPrimaryActivity(v));
        findViewById(R.id.button4).setOnClickListener(v -> launchPrimaryActivity(v));
        findViewById(R.id.button5).setOnClickListener(v -> launchPrimaryActivity(v));
        findViewById(R.id.button6).setOnClickListener(v -> launchPrimaryActivity(v));
        findViewById(R.id.button7).setOnClickListener(v -> launchPrimaryActivity(v));
        findViewById(R.id.button8).setOnClickListener(v -> launchPrimaryActivity(v));
        findViewById(R.id.button9).setOnClickListener(v -> launchPrimaryActivity(v));
        findViewById(R.id.button10).setOnClickListener(v -> launchPrimaryActivity(v));
        findViewById(R.id.button11).setOnClickListener(v -> launchPrimaryActivity(v));
        findViewById(R.id.button12).setOnClickListener(v -> launchPrimaryActivity(v));
        findViewById(R.id.button13).setOnClickListener(v -> launchPrimaryActivity(v));
        findViewById(R.id.button14).setOnClickListener(v -> launchPrimaryActivity(v));
        findViewById(R.id.button16).setOnClickListener(v -> launchPrimaryActivity(v));
        findViewById(R.id.button17).setOnClickListener(v -> launchPrimaryActivity(v));
    }

    public void launchPrimaryActivity(View view) {
        Intent intent2 = new Intent(this, MainActivity.class);

        buttontexto = findViewById(view.getId());
        String alimento = buttontexto.getText().toString();
        Log.d(LOG_TAG, alimento);

        intent2.putExtra("alimento", alimento);
        setResult(RESULT_OK, intent2);
        finish();

    }
}
