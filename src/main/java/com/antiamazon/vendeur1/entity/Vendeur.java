package com.antiamazon.vendeur1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Type;
import org.hibernate.type.BinaryType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vendeur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="id_adresse", nullable=false )
    private Adresse adresse;
    private String nomSociete;
    private String description;
    private byte[] photo;
    @OneToMany(targetEntity=Paiement.class, cascade = {CascadeType.PERSIST}, mappedBy="vendeur")
    private List<Paiement> paiements;
    @OneToMany(mappedBy = "vendeur")
    private List<Article> articles = new ArrayList<>();

    public Vendeur(){
        paiements = new ArrayList<>();
        articles = new ArrayList<>();
    }

    public Vendeur(Adresse unAdd, String unNomSoc, String unDesc, byte[] unePhoto){
        adresse = unAdd;
        nomSociete = unNomSoc;
        description = unDesc;
        photo = unePhoto;
        paiements = new ArrayList<>();
        articles = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdresse() {
        return adresse.getId();
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
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

    public String getNomSociete() {
        return nomSociete;
    }

    public void setNomSociete(String nomSociete) {
        this.nomSociete = nomSociete;
    }
}
