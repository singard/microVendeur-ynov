package com.antiamazon.vendeur1.entity;

import javax.persistence.*;

@Entity
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private byte[] photo;
    private String intitule;
    private float prix;
    private int quantite_dispo;
    @ManyToOne
    private Vendeur vendeur;

    public Article(){}

    public Article(byte[] photo,String intitule,float prix,int quantite_dispo){
        this.photo = photo;
        this.intitule = intitule;
        this.prix = prix;
        this.quantite_dispo = quantite_dispo;
    }

    public int getId() {
        return id;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public String getIntitule() {
        return intitule;
    }

    public float getPrix() {
        return prix;
    }

    public int getQuantite_dispo() {
        return quantite_dispo;
    }

    public Vendeur getVendeur() {
        return vendeur;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setQuantite_dispo(int quantite_dispo) {
        this.quantite_dispo = quantite_dispo;
    }

    public void setVendeur(Vendeur vendeur) {
        this.vendeur = vendeur;
    }
}
