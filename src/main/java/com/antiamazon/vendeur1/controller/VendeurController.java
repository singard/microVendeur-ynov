package com.antiamazon.vendeur1.controller;

import com.antiamazon.vendeur1.entity.Adresse;
import com.antiamazon.vendeur1.entity.Vendeur;
import com.antiamazon.vendeur1.model.UpdateVendeurModel;
import com.antiamazon.vendeur1.repository.VendeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class VendeurController {


    @Autowired
    VendeurRepository vendeurRepository;

    //Modifier un vendeur
    @PutMapping(value = "/update/{id}",consumes = "application/json")
    public ResponseEntity update(@PathVariable int id, @RequestBody UpdateVendeurModel model) {

        Vendeur vendeur = vendeurRepository.findVendeurById(id);

        if(vendeur == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vendeur introuvable !");
        }

        if(model.getDescription() != null && !model.getDescription().equals("")){
            vendeur.setAdresse(model.getAdresse());
        }

        vendeur.setDescription(model.getDescription());
        vendeur.setPhoto(model.getPhoto());
        if(model.getNom_societe() != null && !model.getNom_societe().equals("")){
            vendeur.setNom_societe(model.getNom_societe());
        }
        vendeur.setNom_societe(model.getNom_societe());

        vendeurRepository.save(vendeur);

        return new ResponseEntity<Vendeur>(vendeur, HttpStatus.OK);
    }

    //Afficher vendeur par id
    public ResponseEntity show(@PathVariable int id) {

        Vendeur vendeur = vendeurRepository.findVendeurById(id);

        if(vendeur == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vendeur introuvable !");
        }

        return new ResponseEntity<Vendeur>(vendeur, HttpStatus.OK);
    }

}
