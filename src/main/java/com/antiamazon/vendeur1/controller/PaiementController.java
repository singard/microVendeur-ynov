package com.antiamazon.vendeur1.controller;

import com.antiamazon.vendeur1.entity.Paiement;
import com.antiamazon.vendeur1.entity.Vendeur;
import com.antiamazon.vendeur1.model.NewPaiementModel;
import com.antiamazon.vendeur1.repository.PaiementRepository;
import com.antiamazon.vendeur1.repository.VendeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://herokuapp.com")
@RestController
public class PaiementController {

    @Autowired
    PaiementRepository paiementRepository;
    @Autowired
    VendeurRepository vendeurRepository;

    // Methode pour ajouter ou modifier les paiements preferes
    // d'un vendeur
    @PostMapping(value="/paiements/{vendeurId}")
    public ResponseEntity createPaiements(@PathVariable int vendeurId, @RequestBody NewPaiementModel model) {
        Vendeur vendeur = vendeurRepository.findVendeurById(vendeurId);

        if(vendeur == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vendeur introuvable !");
        }else {

            Paiement paiementCB = new Paiement();
            Paiement paiementPayPal = new Paiement();
            Paiement paiementCheque = new Paiement();
            List<Paiement> paiements = new ArrayList<>();

            for(Paiement p : paiementRepository.findPaiementsByVendeurId(vendeurId)){
                paiementRepository.deleteById(p.getId());
            }

            if (model.getPaiementCB() != null && !model.getPaiementCB().equals("")) {
                paiementCB.setLibelle(model.getPaiementCB());
                paiementCB.setVendeur(vendeur);
                paiements.add(paiementCB);
            }
            if (model.getPaiementPaypal() != null && !model.getPaiementPaypal().equals("")) {
                paiementPayPal.setLibelle(model.getPaiementPaypal());
                paiementPayPal.setVendeur(vendeur);
                paiements.add(paiementPayPal);
            }
            if (model.getPaiementCheque() != null && !model.getPaiementCheque().equals("")) {
                paiementCheque.setLibelle(model.getPaiementCheque());
                paiementCheque.setVendeur(vendeur);
                paiements.add(paiementCheque);
            }

            paiementRepository.saveAll(paiements);
        }

        return ResponseEntity.ok(vendeur);

    }

    @GetMapping(value="paiements/vendeur/{vendeurId}")
    public ResponseEntity showAllPaiements(@PathVariable int vendeurId) {

        Vendeur vendeur = vendeurRepository.findVendeurById(vendeurId);

        if(vendeur == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vendeur introuvable !");
        }

        return ResponseEntity.ok(paiementRepository.findPaiementsByVendeurId(vendeurId));
    }

    @GetMapping(value="paiements/{id}")
    public ResponseEntity showPaiementPerId(@PathVariable int id) {

        return paiementRepository.findPaiementById(id) != null
                ? ResponseEntity.ok(paiementRepository.findPaiementById(id))
                : ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur sur le choix du paiement !");
    }

    @DeleteMapping(value="paiement/delete/{id}")
    public void deletePaiementPerId(@PathVariable int id) {
        paiementRepository.deleteById(id);
    }

}
