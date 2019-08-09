package com.example.projet_intranet;

import android.annotation.SuppressLint;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Date;
import java.util.HashMap;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

//@RequiresApi(api = Build.VERSION_CODES.N)
public class ColisHelper {
    ColisIdCallback colisIdCallback;

   // private static final String COLLECTION_NAME ="Colis";
    FirebaseFirestore mFirestore = FirebaseFirestore.getInstance();
     FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
      String docId = "";
     private String colisID;
     private Colis leColis;


     @Nullable
    protected FirebaseUser getCurrentUser(){ return FirebaseAuth.getInstance().getCurrentUser(); }

    protected Boolean isCurrentUserLogged(){ return (this.getCurrentUser() != null); }
     String id = user.getUid();

     public ColisHelper(){}

     public ColisHelper(Bundle colis){
         colis.putString("userId",id);
         leColis = new Colis(colis);

    /*
         mFirestore.collection("Colis").add(leColis).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
             @SuppressLint("RestrictedApi")
             @Override
             public void onSuccess(DocumentReference documentReference) {
                 //myId[0] = documentReference.getId();
                setColisID(documentReference.getId());
                 Toast.makeText(getApplicationContext(),"Document sent!!!"+getColisID(), Toast.LENGTH_LONG).show();
                 //ColisHelper.this.colisID = documentReference.getId();

             }
         }).addOnFailureListener(new OnFailureListener() {
             @SuppressLint("RestrictedApi")
             @Override
             public void onFailure(@NonNull Exception e) {
                 Toast.makeText(getApplicationContext(),"Document aborted!!!",Toast.LENGTH_SHORT).show();

             }
         });
        */
     }




    public  String getDocId(){
        return docId;
    }

    public void setDocId(String docId) {
        this.docId = docId;
    }

    public String getColisID() {
        return colisID;
    }

    public void setColisID(String colisID) {
        this.colisID = colisID;
    }

    // creer un colis
    public  void createColis(final ColisIdCallback colisIdCallback) {
      /*  colis.putString("userId",id);
        Colis colisToCreate = new Colis(colis); */


        mFirestore.collection("Colis").add(leColis).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onSuccess(@NonNull DocumentReference documentReference) {
               //myId[0] = documentReference.getId();
               String idC = documentReference.getId();
               colisIdCallback.onCallback(idC);
                //docId = documentReference.getId();
                Toast.makeText(getApplicationContext(),"Document sent!!!"+idC, Toast.LENGTH_LONG).show();
                //this.identifiant =id;
                //colisIdCallback.onCallback(id);

            }
        }).addOnFailureListener(new OnFailureListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Document aborted!!!",Toast.LENGTH_SHORT).show();

            }
        });

        //Log.i("essai",docId);
       // this.docId = mFirestore.collection("Colis").getId();
       // return myId;

    }

    public void trackColis(String id,final Track colisIdCallback){
        DocumentReference docRef = mFirestore.collection("Colis").document(id);
        docRef.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                Colis colis = documentSnapshot.toObject(Colis.class);

                //String d = colis.getDescription();
                colisIdCallback.recupererColis(colis);
                Toast.makeText(getApplicationContext(),"Document exist!!!",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @SuppressLint("RestrictedApi")
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getApplicationContext(),"Document doesn't exist!!!",Toast.LENGTH_SHORT).show();
            }
        });
    }



}
