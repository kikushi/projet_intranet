package com.example.projet_intranet;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class ColisHelper {

    private static final String COLLECTION_NAME ="colis";


    public static CollectionReference getColisCollection(){
        return FirebaseFirestore.getInstance().collection(COLLECTION_NAME);
    }


    // creer un colis
    public static Task<Void> createColis(String colisID, String description, String adresse, String imgUrl, DestinataireColis destinataireColis, double poids, double prix) {
        Colis colisToCreate = new Colis(colisID,description,adresse,imgUrl,destinataireColis,poids,prix);
        return ColisHelper.getColisCollection().document(colisID).set(colisToCreate);
    }
}
