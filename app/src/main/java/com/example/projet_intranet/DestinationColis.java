package com.example.projet_intranet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class DestinationColis extends AppCompatActivity {

    private Button btnTerminer;
    private EditText nomDest, prenomDest, adresseDest, telDest;
    private String nomDest_, prenomDest_, adresseDest_,telDest_;
    //private HashMap<String,Object> infoColis;
   private String idColis;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_colis);

        Intent intent = getIntent();
        extras = intent.getExtras();
        btnTerminer =findViewById(R.id.btnTerminer);
        nomDest = findViewById(R.id.nomDest);
        prenomDest = findViewById(R.id.prenomDest);
        adresseDest = findViewById(R.id.adresseDest);
        telDest = findViewById(R.id.telDest);

        nomDest.addTextChangedListener(verification);
        prenomDest.addTextChangedListener(verification);
        adresseDest.addTextChangedListener(verification);
        telDest.addTextChangedListener(verification);

        btnTerminer.setOnClickListener(decoBtnTerminer);

    }


    // verification des editText
    private TextWatcher verification =new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String nomDestInput = nomDest.getText().toString().trim();
            String prenomDestInput = prenomDest.getText().toString().trim();
            String adresseDestInput = adresseDest.getText().toString().trim();
            String telDestInput = telDest.getText().toString().trim();

            btnTerminer.setEnabled(!nomDestInput.isEmpty() && !prenomDestInput.isEmpty() && !adresseDestInput.isEmpty() && !telDestInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    // declenchement du click sur le btnTerminer
    private View.OnClickListener decoBtnTerminer = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            decoBtnTerminerClicked();
        }
    };

    private void decoBtnTerminerClicked() {


        nomDest_ = nomDest.getText().toString().trim();
        prenomDest_ = prenomDest.getText().toString().trim();
        adresseDest_ = adresseDest.getText().toString().trim();
        telDest_ = telDest.getText().toString().trim();

        //DestinataireColis destinataireColis = new DestinataireColis(nomDest_,prenomDest_,adresseDest_,telDest_);

        //extras.putSerializable("destinataire", (Serializable) destinataireColis);
        extras.putString("nomDest",nomDest_);
        extras.putString("prenomDest",prenomDest_);
        extras.putString("adresseDest",adresseDest_);
        extras.putString("telDest",telDest_);

       // ColisHelper helper = new ColisHelper(extras);

            //ColisHelper.createColis(extras);
        //ColisHelper monColis = new ColisHelper();
       //monColis.createColis(extras);
        //Toast.makeText(getApplicationContext(),monColis.getDocId(), Toast.LENGTH_LONG).show();
       //idColis = monColis.getDocId();
        //idColis = "hello test"+helper.getColisID();

        /*helper.createColis(new ColisIdCallback() {
            @Override
            public void onCallback(String value) {
                essai(value);
            }
        });*/
        Intent intent = new Intent(this, GeneratedCode.class);
        intent.putExtras(extras);
        startActivity(intent);
    }


   /* public void essai(String value) {
        this.idColis = "salut";
    }*/
}
