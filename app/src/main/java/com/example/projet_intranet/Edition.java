package com.example.projet_intranet;

import android.content.Intent;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Edition extends AppCompatActivity {
    private TextView id;
Bundle extras;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edition);
        id = findViewById(R.id.ide);
        //Intent intent = getIntent();
        //extras = intent.getExtras();
        //id.setText(extras.getString("idColis"));

    }
}
