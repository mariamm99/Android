package com.example.proyectofinal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class shoppingList extends AppCompatActivity {

    private static final String LOG_TAG = shoppingList.class.getSimpleName();
    private LinearLayout linLay;
    private Button localizacion;
    private TextView textLoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

        Button btn = findViewById(R.id.button);

        linLay = findViewById(R.id.linlay);
        localizacion = (findViewById(R.id.location_button));
        textLoc = findViewById(R.id.supermercado);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarMnsajeToast("selecionado alimento");
                Intent intent = new Intent (v.getContext(), alimentos.class);
                startActivityForResult(intent, 0);
            }
        });

        localizacion.setOnClickListener(v -> openLocation(v));

        if (savedInstanceState!=null){
enviarMnsajeToast("restableciendo estado activity");

            ArrayList<String> alimento_arr = savedInstanceState.getStringArrayList("array");

            for ( String alimento : alimento_arr) {
                TextView textView= new TextView(this);
                textView.setText(alimento);
                linLay.addView(textView);
            }
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Bundle extras= data.getExtras();
        String nombre_alimento = extras.getString("alimento");
        Log.d(LOG_TAG, extras.toString());
        TextView tx= new TextView(this);
        tx.setText("- "+ nombre_alimento);
        linLay.addView(tx);


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        ArrayList<String> viewArrayList = new ArrayList<String>();

        for (int i = 0; i < linLay.getChildCount(); i++) {
            TextView v = (TextView) linLay.getChildAt(i);

            String alimento_guardado= (String) v.getText();
            viewArrayList.add(alimento_guardado);
        }
        outState.putStringArrayList("array", viewArrayList);
    }


    public void openLocation(View view) {
        String loc = textLoc.getText().toString();

        Uri addressUri = Uri.parse("geo:0,0?q=" + "supermercado "+loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!");
        }
    }

    public void enviarMnsajeToast(String mensaje) {

        Toast toast = Toast.makeText(this, mensaje,
                Toast.LENGTH_LONG);
        toast.show();
    }

}