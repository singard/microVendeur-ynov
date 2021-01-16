package com.antiamazon.vendeur1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Adresse {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;
    private String rue;
    private String ville;
    private int code_postal;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "adresse")
    private Vendeur vendeur;

    public Adresse(){

    }

    public Adresse(String uneRue, String uneVille, int unCP){
        rue = uneRue;
        ville = uneVille;
        code_postal = unCP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getCode_postal() {
        return code_postal;
    }

    public void setCode_postal(int code_postal) {
        this.code_postal = code_postal;
    }

    public int getVendeur() {
        return vendeur.getId();
    }

    public void setVendeur(Vendeur vendeur) {
        this.vendeur = vendeur;
    }
}
