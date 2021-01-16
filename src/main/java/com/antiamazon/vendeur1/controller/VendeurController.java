package com.antiamazon.vendeur1.controller;

import com.antiamazon.vendeur1.entity.Adresse;
import com.antiamazon.vendeur1.entity.Vendeur;
import com.antiamazon.vendeur1.model.UpdateVendeurModel;
import com.antiamazon.vendeur1.repository.AdresseRepository;
import com.antiamazon.vendeur1.repository.VendeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@CrossOrigin(origins = "https://herokuapp.com")
@RestController
public class VendeurController {

    @Autowired
    VendeurRepository vendeurRepository;
    @Autowired
    AdresseRepository adresseRepository;

    // Modifier un vendeur
    @PutMapping(value = "/update/{id}", consumes = {"application/json", "application/x-www-form-urlencoded"})
    public ResponseEntity update(@PathVariable int id, @RequestBody UpdateVendeurModel model) {

        Vendeur vendeur = vendeurRepository.findVendeurById(id);

        if(vendeur == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vendeur introuvable !");
        }

        Adresse adresse = adresseRepository.findAdresseById(vendeur.getAdresse());
        adresse.setRue(model.getRue());
        adresse.setVille(model.getVille());
        adresse.setCode_postal(model.getCp());

        vendeur.setAdresse(adresse);
        vendeur.setDescription(model.getDesc());
        vendeur.setPhoto(model.getPhoto64().getBytes());
        vendeur.setNomSociete(model.getSoc());

        vendeurRepository.save(vendeur);

        return new ResponseEntity<Vendeur>(vendeur, HttpStatus.OK);
    }

    //Afficher vendeur par id
    @GetMapping(value = "/show/{id}", produces = {"application/json"})
    public ResponseEntity show(@PathVariable int id) {

        Vendeur vendeur = vendeurRepository.findVendeurById(id);

        if(vendeur == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vendeur introuvable !");
        }

        return new ResponseEntity<Vendeur>(vendeur, HttpStatus.OK);
    }

}
