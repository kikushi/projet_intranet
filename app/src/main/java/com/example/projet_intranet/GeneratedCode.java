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
   private String code;
   private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generated_code);

        image = (ImageView) findViewById(R.id.image);
        btnOk = (Button) findViewById(R.id.btnOk);
        textView = (TextView) findViewById(R.id.msg);

        //code a remplacer par id du colis
        code = textView.getText().toString().trim();

        btnOk.setOnClickListener(decoBtnOK);

        // generation du code qr
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(code, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            image.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
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


