package com.example.projet_intranet;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class Colis {

    private String colisID, description, adresse,imgUrl;
    private DestinataireColis destinataireColis;
    private double poids, prix;
    private Date dateCreated;

    public Colis(){}

    public Colis(String colisID, String description, String adresse, String imgUrl, DestinataireColis destinataireColis, double poids, double prix){
        this.colisID = colisID;
        this.description = description;
        this.adresse =adresse;
        this.imgUrl = imgUrl;
        this.destinataireColis = destinataireColis;
        this.prix = prix;
        this.poids = poids;
    }


    // GETTERS AND SETTERS

    @ServerTimestamp public Date getDateCreated() { return dateCreated; }
    public String getColisID() {
        return colisID;
    }

    public void setDateCreated(Date dateCreated) { this.dateCreated = dateCreated; }


    public void setColisID(String colisID) {
        this.colisID = colisID;
    }

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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public DestinataireColis getdestinataireColis() {
        return destinataireColis;
    }

    public void setdestinataireColis(DestinataireColis destinataireColis) {
        this.destinataireColis = destinataireColis;
    }

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


}
