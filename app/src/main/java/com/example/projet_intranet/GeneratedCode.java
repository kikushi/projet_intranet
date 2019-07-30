package com.example.projet_intranet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GeneratedCode extends AppCompatActivity {

   private ImageView image;
   private Button btnOk;
    String code;
   private TextView textView;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generated_code);
        Intent intent = getIntent();
        image = (ImageView) findViewById(R.id.image);
        btnOk = (Button) findViewById(R.id.btnOk);
        textView = (TextView) findViewById(R.id.msg);

        //textView.setText(intent.getStringExtra("idColis"));

        //code a remplacer par id du colis
        //code = intent.getStringExtra("idColis");
       //code = "bonjour";

        extras = intent.getExtras();

        btnOk.setOnClickListener(decoBtnOK);

        // generation du code qr
        ColisHelper helper = new ColisHelper(extras);
        helper.createColis(new ColisIdCallback() {
            @Override
            public void onCallback(String value) {
                MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                try {
                    textView.setText("VOICI VOTRE ID DE COLIS : "+value);
                    BitMatrix bitMatrix = multiFormatWriter.encode(value, BarcodeFormat.QR_CODE, 200, 200);
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                    image.setImageBitmap(bitmap);
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    private View.OnClickListener decoBtnOK = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            decoBtnOkClicked();
        }
    };

    private void decoBtnOkClicked() {

        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
}


