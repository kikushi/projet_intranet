package com.example.projet_intranet;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private String mUsername;
    private static final int RC_SIGN_IN = 1;
    public static final String ANONYMOUS = "anonymous";
    private TextView mtextview;
    private Button btn_deco;
    private Button btn_creerColis;
    private Button btnTracking;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_deco = findViewById(R.id.button_dec);
        btn_creerColis = findViewById(R.id.button_creerColis);
        btnTracking = (Button) findViewById(R.id.btnTracking);

        btn_creerColis.setOnClickListener(decoBtnColis);
        btnTracking.setOnClickListener(decoBtnTracking);

        btn_deco.setOnClickListener(decoBtnListener);
        mFirebaseAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){
                    //Toast.makeText(MainActivity.this, "You're now signed in. Welcome to FriendlyChat.", Toast.LENGTH_SHORT).show();
                    onSignedInInitialize(user.getDisplayName());
                } else{
                    onSignedOutCleanup();

                    //user is signed out
                    // Choose authentication providers
                    List<AuthUI.IdpConfig> providers = Arrays.asList(
                            new AuthUI.IdpConfig.EmailBuilder().build(),
                            new AuthUI.IdpConfig.GoogleBuilder().build());

                    // Create and launch sign-in intent
                    startActivityForResult(
                            AuthUI.getInstance()
                                    .createSignInIntentBuilder()
                                    .setAvailableProviders(providers)
                                    .build(),
                            RC_SIGN_IN);
                }
            }
        };
    }
    private View.OnClickListener decoBtnListener = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            decoBtnClicked();
        }

    };
    private void decoBtnClicked(){
        AuthUI.getInstance().signOut(this);

    }

    private View.OnClickListener decoBtnColis = new View.OnClickListener() {
        @Override
        public void onClick(View v){
            decoBtnColisClicked();
        }

    };

    private void decoBtnColisClicked(){
        startActivity(new Intent(getApplicationContext(),CreerLivraison.class));
    }

    private View.OnClickListener decoBtnTracking = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            decoBtnTrackingClicked();
        }
    };

    private void decoBtnTrackingClicked() {

        startActivity(new Intent(getApplicationContext(),Tracking.class));
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == RC_SIGN_IN){
            if(resultCode == RESULT_OK){
                Toast.makeText(this,"Signed In",Toast.LENGTH_SHORT).show();
            } else if(resultCode ==RESULT_CANCELED){
                Toast.makeText(this,"Signed In Canceled",Toast.LENGTH_SHORT).show();
                finish();


            }

        }

    }

    @Override
    protected void onPause(){
        super.onPause();
        mFirebaseAuth.removeAuthStateListener(mAuthStateListener);
    }
    @Override
    protected void onResume(){
        super.onResume();
        mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }
    private void onSignedInInitialize(String username){
        mUsername = username;


    }
    private void onSignedOutCleanup(){
        mUsername = ANONYMOUS;


    }
}
