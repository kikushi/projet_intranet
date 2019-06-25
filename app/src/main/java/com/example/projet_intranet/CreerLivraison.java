package com.example.projet_intranet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreerLivraison extends AppCompatActivity {

    private Button btnSuivant;
    private EditText description;
    private EditText poids, prix;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_livraison);
        btnSuivant = findViewById(R.id.btnNext);
        description = findViewById(R.id.description);
        poids = findViewById(R.id.poids);
        prix = findViewById(R.id.prix);


        description.addTextChangedListener(verifChamp);
        poids.addTextChangedListener(verifChamp);
        prix.addTextChangedListener(verifChamp);

        btnSuivant.setOnClickListener(decoBtnSuivant);
    }


    // verification des editText
    private TextWatcher verifChamp =new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
                String descriptionInput = description.getText().toString().trim();
                String poidsInput = poids.getText().toString().trim();
                String prixInput = prix.getText().toString().trim();

                btnSuivant.setEnabled(!descriptionInput.isEmpty() && !poidsInput.isEmpty() && !prixInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    // declenchement du click sur le btnSuivant
    private View.OnClickListener decoBtnSuivant = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            decoBtnSuivantClicked();
        }
    };

    private void decoBtnSuivantClicked() {

        startActivity(new Intent(getApplicationContext(),DestinationColis.class));
    }
}
