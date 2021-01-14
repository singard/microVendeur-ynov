package com.antiamazon.vendeur1.entity;

import org.hibernate.annotations.Type;
import org.hibernate.type.BinaryType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Vendeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_adresse", referencedColumnName = "id")
    private Adresse adresse;
    private String nom_societe;
    private String description;
    private byte[] photo;
    @OneToMany(mappedBy = "vendeur")
    private List<Paiement> paiements = new ArrayList<>();
    @OneToMany(mappedBy = "vendeur")
    private List<Article> articles = new ArrayList<>();

    public Vendeur(){

    }

    public Vendeur(Adresse unAdd, String unNomSoc, String unDesc, byte[] unePhoto){
        adresse = unAdd;
        nom_societe = unNomSoc;
        description = unDesc;
        photo = unePhoto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public String getNom_societe() {
        return nom_societe;
    }

    public void setNom_societe(String nom_societe) {
        this.nom_societe = nom_societe;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public List<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(List<Paiement> paiements) {
        this.paiements = paiements;
    }
}
