package com.example.projet_intranet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ColisFound extends AppCompatActivity {
private TextView descColis;
private TextView prixColis;
private TextView poidsColis;
private TextView destinataireColis;
private Button btnEdit;
private Button btnRetour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colis_found);
        descColis = findViewById(R.id.descColis);
        prixColis = findViewById(R.id.prixColis);
        poidsColis = findViewById(R.id.poidsColis);
        destinataireColis = findViewById(R.id.destinataireColis);

        btnEdit = findViewById(R.id.btnEditer);
        btnRetour = findViewById(R.id.btnRetour);
        Intent intent = getIntent();
       // Colis c =new Colis();
       // c = intent.getExtras().getParcelable("Colis");
        String id = intent.getStringExtra("id");
        descColis.setText(id);

       // Colis colisFound = new Colis();
        ColisHelper helper =new ColisHelper();
        helper.trackColis(id, new ColisIdCallback() {
            @Override
            public void onCallback(String value) {

            }

            // mon colis est nul

            @Override
            public void recupererColis(Colis colis) {
                    prixColis.setText((Double.toString(colis.getPrix())));
            }
        });

    }
}
