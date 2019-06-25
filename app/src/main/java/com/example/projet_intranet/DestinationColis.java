package com.example.projet_intranet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DestinationColis extends AppCompatActivity {

    private Button btnTerminer;
    private EditText nomDest, prenomDest, adresseDest, telDest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination_colis);


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

        startActivity(new Intent(getApplicationContext(),AddImgColis.class));
    }

}
