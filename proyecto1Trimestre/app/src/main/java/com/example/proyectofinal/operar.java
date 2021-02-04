package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class operar extends AppCompatActivity {
private TextView resultado_txt;
private EditText n1;
    private EditText n2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operar);

        Button btn_sum = findViewById(R.id.btn_sumar);
        Button btn_mul = findViewById(R.id.btn_mult);
        resultado_txt = findViewById(R.id.resultado);
        n1=  findViewById(R.id.numero1);
        n2=  findViewById(R.id.numero2);


        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarMnsajeToast("sumar");
                sumar();
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarMnsajeToast("multiplicar");
                multiplicar();
            }
        });
    }

    protected Double toNumber(EditText numero){
        String operandText = numero.getText().toString();
        return Double.valueOf(operandText);
    }

    protected void sumar(){
        try {
            escribirResultado(getDouble(n1)+getDouble(n2));
        }catch (Exception e){
            resultado_txt.setText("datos erroneos");
        }

    }

    private Double getDouble(EditText n) {
        return toNumber(n);
    }

    protected void multiplicar(){
        try {
            escribirResultado(getDouble(n1)*getDouble(n2));
        }catch (Exception e){
            resultado_txt.setText("datos erroneos");
        }
    }

    protected void escribirResultado(double result){
        resultado_txt.setText(String.valueOf(result));
    }

    public void enviarMnsajeToast(String mensaje) {

        Toast toast = Toast.makeText(this, mensaje,
                Toast.LENGTH_LONG);
        toast.show();
    }
}