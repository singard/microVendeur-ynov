package com.antiamazon.vendeur1.entity;

import javax.persistence.*;

@Entity
public class Paiement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="vendeur_id", nullable=false)
    private Vendeur vendeur;
    private String libelle;

    public Paiement(){

    }

    public Paiement(String unLibelle){
        libelle = unLibelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getVendeur() {
        return vendeur.getId();
    }

    public void setVendeur(Vendeur vendeur) {
        this.vendeur = vendeur;
    }
}
