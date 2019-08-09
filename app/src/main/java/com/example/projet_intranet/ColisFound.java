package com.example.projet_intranet;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class ColisFound extends AppCompatActivity {
private TextView descColis;
private TextView prixColis;
private TextView poidsColis;
private TextView destinataireColis;
private TextView identifiantColis;
private TextView dateCreated;
private TextView prenomDestinataire;
private TextView adresseDestinataire;
private TextView numeroDestinataire;
private Button btnEdit;
private Button btnRetour;
Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colis_found);
        descColis = findViewById(R.id.descColis);
        prixColis = findViewById(R.id.prixColis);
        poidsColis = findViewById(R.id.poidsColis);
        destinataireColis = findViewById(R.id.destinataireColis);
        identifiantColis = findViewById(R.id.identifiantColis);
        dateCreated = findViewById(R.id.dateCreate);
        prenomDestinataire = findViewById(R.id.prenomDestinataire);
        adresseDestinataire = findViewById(R.id.adresseDestinataire);
        numeroDestinataire = findViewById(R.id.numeroDestinataire);

        btnEdit = findViewById(R.id.btnEditer);
        btnRetour = findViewById(R.id.btnRetour);


        Intent intent = getIntent();
        // Colis c =new Colis();
        // c = intent.getExtras().getParcelable("Colis");
        String id = intent.getStringExtra("id");
        identifiantColis.setText("ID COLIS: "+id);
        //extras.putString("idColis",id);

        // Colis colisFound = new Colis();
        ColisHelper helper = new ColisHelper();
        helper.trackColis(id, new Track() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void recupererColis(Colis colis) {

                String description = colis.getDescription();
                descColis.setText("Description: "+description);
                //extras.putString("description",description);

                Double poids = colis.getPoids();
                poidsColis.setText("Poids: "+Double.toString(poids));
                //extras.putDouble("poids",poids);

                Double prix =colis.getPrix();
                prixColis.setText("Prix: "+Double.toString(prix));
               // extras.putDouble("prix",prix);

                Date dateC = colis.getDateCreated();
                SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
                String dateString = sdf.format(dateC);
                dateCreated.setText("Cree: "+dateString);

                String nomDestinataire = colis.getNomDest();
                destinataireColis.setText("Nom: "+nomDestinataire);
               // extras.putString("nomDest",nomDestinataire);

                String prenomDest =colis.getPrenomDest();
                prenomDestinataire.setText("Prenom: "+prenomDest);
               // extras.putString("prenomDest",prenomDest);

                String adr = colis.getAdresseDest();
                adresseDestinataire.setText("Adresse: "+adr);
                //extras.putString("adresseDest",adr);

                String num = colis.getTelDest();
                numeroDestinataire.setText("Tel: "+num);
                //extras.putString("telDest",num);
                //Toast.makeText(getApplicationContext(),colis.getDescription(),Toast.LENGTH_SHORT);

            }

        });
        btnRetour.setOnClickListener(decoBtnRetour);
        btnEdit.setOnClickListener(decoBtnEdit);


    }

    private View.OnClickListener decoBtnRetour = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            decoBtnRetourClicked();
        }
    };

    private void decoBtnRetourClicked() {
        Intent intent = new Intent(this, Tracking.class);
        startActivity(intent);
    }

    private View.OnClickListener decoBtnEdit = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            decoBtnEditClicked();
        }
    };

    private void decoBtnEditClicked() {
        Intent intent = new Intent(this, Edition.class);
        //intent.putExtras(extras);
        startActivity(intent);
    }
}
