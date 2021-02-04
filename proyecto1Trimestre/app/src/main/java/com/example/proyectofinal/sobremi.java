package com.example.proyectofinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class sobremi extends AppCompatActivity {

    private TextView texto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobremi);

        Button button_localizacion=findViewById(R.id.localizacion);
        Button button_webSite =findViewById(R.id.redSocial);
        Button button_texto = findViewById(R.id.enviar_text);
        Button button_lista = findViewById(R.id.abrir_lista_compra);
        Button operar = findViewById(R.id.abrir_operar);

        texto= findViewById(R.id.texto_proyecto);

        button_localizacion.setOnClickListener(v->openLocation(v));
        button_webSite.setOnClickListener(v -> openWebsite(v));
        button_texto.setOnClickListener(v -> shareText(v));

        button_lista.setOnClickListener(v -> launchShoppingList(v));
        operar.setOnClickListener(v -> launchOperar(v));
    }



    public void openWebsite(View view) {

        String url = "https://github.com/mariamm99";
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "no pudo abrir la página web!");
        }

    }

    public void openLocation(View view) {
        String loc = "La Caleta, Cádiz";

        // Parse the location and create the intent.
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "no pudo abrir la ubiación!");
        }


    }

    public void shareText(View view) {

        String txt = texto.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.mensaje_proyecto)
                .setText(txt)
                .startChooser();
    }

    public void launchShoppingList(View view) {
        Intent intent = new Intent(this, shoppingList.class);
        startActivity(intent);

    }

    public void launchOperar(View view) {
        Intent intent = new Intent(this, operar.class);
        startActivity(intent);

    }
}