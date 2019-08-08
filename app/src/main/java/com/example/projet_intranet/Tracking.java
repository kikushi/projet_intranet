package com.example.projet_intranet;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class Tracking extends AppCompatActivity {
    private EditText idColis;
  private   Button btnSearch,btnScan;
  private String id;
  Bundle extras;
  Colis leColis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracking);
        Intent intent = new Intent(this,ColisFound.class);
        idColis = (EditText)findViewById(R.id.idColis);
        btnSearch = (Button)findViewById(R.id.btn_Search);
        btnScan = (Button)findViewById(R.id.scan_btn);
        final Activity activity = this;
        idColis.addTextChangedListener(verifChamp);
        btnSearch.setOnClickListener(decoBtnSearch);


        btnScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentIntegrator integrator = new IntentIntegrator(activity);

                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Scan");
                integrator.setCameraId(0);
                integrator.setBeepEnabled(false);
                integrator.setBarcodeImageEnabled(false);
                integrator.initiateScan();


            }
        });
    }

    // verification des editText
    private TextWatcher verifChamp =new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String id = idColis.getText().toString().trim();


            btnSearch.setEnabled(!id.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    // declenchement du btnSearch
    private View.OnClickListener decoBtnSearch = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            decoBtnSearchClicked();
        }
    };

    private void decoBtnSearchClicked() {

        startActivity(new Intent(getApplicationContext(),ColisFound.class));
    }


    // declenchement du btnScan

    /*
    private View.OnClickListener decoBtnScan = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            decoBtnScanClicked();
        }
    };

    private void decoBtnScanClicked() {

        final Activity activity = this;
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();

        //startActivity(new Intent(getApplicationContext(),DestinationColis.class));
    }*/

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            //result.getContent doit contenir l'id du colis apres la lecture du code qr
            if(result.getContents()== null){
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else {
               // id = result.getContents();
                /*
                ColisHelper helper = new ColisHelper();
                helper.trackColis(result.getContents(), new ColisIdCallback() {
                    @Override
                    public void onCallback(String value) {
                        //rien faire;
                    }

                    @Override
                    public void recupererColis(Colis colis) {
                       //extras.putString("Description");
                        leColis = colis;
                    }
                });

                Intent intent = new Intent(this,ColisFound.class);
                intent.putExtra("Colis",leColis);
                startActivity(intent);*/
                //extras = data.getExtras();
                //id =extras.getString("SCAN_RESULT");
                String i = result.getContents();
                Intent intent = new Intent(this,ColisFound.class);
                intent.putExtra("id",i);
                startActivity(intent);

                //Toast.makeText(this, i,Toast.LENGTH_LONG).show();
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
