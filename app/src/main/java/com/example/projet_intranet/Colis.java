package com.example.projet_intranet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;
import java.util.HashMap;

public class Colis implements Parcelable {

    private String  userID,description, adresse;
    private String nomDest, prenomDest,adresseDest, telDest;



    //private String colisID,imgUrl;
    //private DestinataireColis destinataireColis;
    private double poids, prix;
    private Date dateCreated;

    public Colis(){}

    public Colis(Bundle colis){
        this.userID = colis.getString("userId");
        // this.colisID = colis.getString("id");
        this.description = colis.getString("description");
        //this.adresse = colis.getString("adresse");
        //this.imgUrl = (String)colis.get("img");
        //this.destinataireColis = (DestinataireColis) colis.getSerializable("destinataire");
        this.poids = colis.getDouble("poids");
        this.prix = colis.getDouble("prix");
        this.nomDest = colis.getString("nomDest");
        this.prenomDest = colis.getString("prenomDest");
        this.adresseDest = colis.getString("adresseDest");
        this.telDest = colis.getString("telDest");
        //this.dateCreated = date_;


    }
    public Colis( String description, String adresse, String imgUrl, DestinataireColis destinataireColis, double poids, double prix){
        // this.colisID = colisID;
        this.description = description;
        this.adresse =adresse;
        //this.imgUrl = imgUrl;
        //this.destinataireColis = destinataireColis;
        this.prix = prix;
        this.poids = poids;
    }


    // GETTERS AND SETTERS

    protected Colis(Parcel in) {
        userID = in.readString();
        description = in.readString();
        adresse = in.readString();
        nomDest = in.readString();
        prenomDest = in.readString();
        adresseDest = in.readString();
        telDest = in.readString();
        poids = in.readDouble();
        prix = in.readDouble();
    }

    public static final Creator<Colis> CREATOR = new Creator<Colis>() {
        @Override
        public Colis createFromParcel(Parcel in) {
            return new Colis(in);
        }

        @Override
        public Colis[] newArray(int size) {
            return new Colis[size];
        }
    };

    @ServerTimestamp public Date getDateCreated() { return dateCreated; }
    /* public String getColisID() {
         return colisID;
     }*/
    public  void setUserID(String id){
        this.userID = id;
    }
    public String getUserID(){
        return userID;
    }
    public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }


    /* public void setColisID(String colisID) {
         this.colisID = colisID;
     }
         */
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    /*public String getImgUrl() {
       return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }*/


    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getNomDest() {
        return nomDest;
    }

    public void setNomDest(String nomDest) {
        this.nomDest = nomDest;
    }

    public String getPrenomDest() {
        return prenomDest;
    }

    public void setPrenomDest(String prenomDest) {
        this.prenomDest = prenomDest;
    }

    public String getAdresseDest() {
        return adresseDest;
    }

    public void setAdresseDest(String adresseDest) {
        this.adresseDest = adresseDest;
    }

    public String getTelDest() {
        return telDest;
    }

    public void setTelDest(String telDest) {
        this.telDest = telDest;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userID);
        dest.writeString(description);
        dest.writeString(adresse);
        dest.writeString(nomDest);
        dest.writeString(prenomDest);
        dest.writeString(adresseDest);
        dest.writeString(telDest);
        dest.writeDouble(poids);
        dest.writeDouble(prix);
    }
}
