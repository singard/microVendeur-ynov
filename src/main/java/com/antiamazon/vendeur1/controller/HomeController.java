package com.antiamazon.vendeur1.controller;

import com.antiamazon.vendeur1.entity.Vendeur;
import com.antiamazon.vendeur1.entity.Adresse;
import com.antiamazon.vendeur1.entity.Paiement;
import com.antiamazon.vendeur1.model.FillVendeurModel;
import com.antiamazon.vendeur1.repository.VendeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Api( description="API pour les opérations CRUD Vendeur")
@CrossOrigin(origins = "https://guarded-badlands-84396.herokuapp.com")
@RestController
public class HomeController {


    @Autowired
    VendeurRepository vendeurRepository;

    @GetMapping(value = "/home", produces = "application/json")
    public Map<String, String> get() {
        return Collections.singletonMap("message", "Bonne année");
    }
    
    /*@PostMapping(value = "/fill", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String getVendeur(@RequestBody NewVendeur newVendeur){
    	return newVendeur.toString();
    }*/

    @PostMapping(value = "/fill", consumes = "application/json")
    public ResponseEntity register(@RequestBody FillVendeurModel model) {

        if (model.getSoc().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le nom de la société ne peut pas être vide");
        }
        if (model.getRue().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le nom de la rue ne peut pas être vide");
        }
        if (model.getVille().isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le nom de la ville ne peut pas être vide");
        }
        if (model.getCp() != (int) model.getCp()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Le nom de la ville ne peut pas être vide");
        }
        // Creation de l'adresse
        Adresse adresse = new Adresse();
        adresse.setRue(model.getRue());
        adresse.setVille(model.getVille());
        adresse.setCode_postal(model.getCp());

        // Creation des paiements
        Paiement paiementCB = new Paiement();
        Paiement paiementPayPal = new Paiement();
        Paiement paiementCheque = new Paiement();
        List<Paiement> paiements = new ArrayList<Paiement>();
        if (model.getPaiementCB() != null && !model.getPaiementCB().equals("")) {
            paiementCB.setLibelle(model.getPaiementCB());
            paiements.add(paiementCB);
        }
        if (model.getPaiementPaypal() != null && !model.getPaiementPaypal().equals("")) {
            paiementPayPal.setLibelle(model.getPaiementPaypal());
            paiements.add(paiementPayPal);
        }
        if (model.getPaiementCheque() != null && !model.getPaiementCheque().equals("")) {
            paiementCheque.setLibelle(model.getPaiementCheque());
            paiements.add(paiementCheque);
        }

        // Creation du vendeur / Mapping
        Vendeur vendeur = new Vendeur(adresse, model.getSoc(), model.getDesc(), model.getPhoto64().getBytes());
        vendeur.setPaiements(paiements);

        vendeurRepository.save(vendeur);
        return new ResponseEntity<Vendeur>(vendeur, HttpStatus.OK);
    }

}