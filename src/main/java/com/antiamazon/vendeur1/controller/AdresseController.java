package com.antiamazon.vendeur1.controller;

import com.antiamazon.vendeur1.entity.Adresse;
import com.antiamazon.vendeur1.entity.Vendeur;
import com.antiamazon.vendeur1.model.NewAdresseModel;
import com.antiamazon.vendeur1.repository.AdresseRepository;
import com.antiamazon.vendeur1.repository.VendeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://herokuapp.com")
@RestController
public class AdresseController {

    @Autowired
    AdresseRepository adresseRepository;
    @Autowired
    VendeurRepository vendeurRepository;

    // Récupere l'adresse d'un vendeur par l'id du vendeur
    @GetMapping(value = "/adresse/vendeur/show/{vendeurId}")
    public ResponseEntity getAdresseVendeur(@PathVariable int vendeurId){
        Vendeur vendeur = vendeurRepository.findVendeurById(vendeurId);
        if(vendeur == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vendeur introuvable !");
        }
        Adresse adresse = adresseRepository.findAdresseByVendeurId(vendeurId);

        return ResponseEntity.ok(adresse);
    }

    // Récupere l'adresse par son id
    @GetMapping(value = "/adresse/show/{adresseId}")
    public ResponseEntity show(@PathVariable int adresseId){
        Adresse adresse = adresseRepository.findAdresseById(adresseId);

        if(adresse == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Adresse introuvable !");
        }

        return new ResponseEntity<Adresse>(adresse, HttpStatus.OK);
    }

    // Supprime une adresse par son id
    // Risque de pas marcher car si l'utilisateur existe
    // L'adresse ne pourra pas etre supprime, d'abord supprimer l'utilisateur ensuite l'adresse
    @DeleteMapping(value = "/adresse/delete/{adresseId}")
    public ResponseEntity<Integer> delete(@PathVariable int adresseId){
        Adresse adresse = adresseRepository.findAdresseById(adresseId);

        if(adresse == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        adresseRepository.deleteAdresseById(adresseId);

        return new ResponseEntity<>(adresseId, HttpStatus.OK);
    }

    /*
    // Un utilisateur ne peut avoir une seule adresse
    // Méthode inutile mais à utiliser si utilisateur veut avoir plusieurs adresses
    @PostMapping(value = "/adresse/new/{vendeurId}")
    public ResponseEntity<Adresse> newAdresse(@PathVariable int vendeurId, @RequestBody NewAdresseModel model){
        Vendeur vendeur = vendeurRepository.findVendeurById(vendeurId);

        if(vendeur == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Adresse adresse = new Adresse();
        adresse.setRue(model.getRue());
        adresse.setVille(model.getVille());
        adresse.setCode_postal(model.getCp());
        adresseRepository.save(adresse);

        return new ResponseEntity<>(adresse, HttpStatus.OK);
    }*/

    // Modifier une adresse par son id
    @PutMapping(value = "/adresse/update/{adresseId}")
    public ResponseEntity updateAdresse(@PathVariable int adresseId, @RequestBody NewAdresseModel model){

        Adresse adresse = adresseRepository.findAdresseById(adresseId);

        if(adresse == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Adresse introuvable !");
        }

        if(!model.getRue().isEmpty() || model.getRue() != null){
            adresse.setRue(model.getRue());
        }
        if(!model.getVille().isEmpty() || model.getVille() != null){
            adresse.setVille(model.getVille());
        }
        if(!String.valueOf(model.getCp()).isEmpty()){
            adresse.setCode_postal(model.getCp());
        }

        adresseRepository.save(adresse);

        return new ResponseEntity<>(adresse, HttpStatus.OK);
    }

    // Modifier une adresse par l'id du vendeur
    @PutMapping(value = "/adresse/vendeur/update/{vendeurId}")
    public ResponseEntity updateAdresseVendeur(@PathVariable int vendeurId, @RequestBody NewAdresseModel model){

        Adresse adresse = adresseRepository.findAdresseByVendeurId(vendeurId);

        if(adresse == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Adresse introuvable !");
        }

        if(!model.getRue().isEmpty() || model.getRue() != null){
            adresse.setRue(model.getRue());
        }
        if(!model.getVille().isEmpty() || model.getVille() != null){
            adresse.setVille(model.getVille());
        }
        if(!String.valueOf(model.getCp()).isEmpty()){
            adresse.setCode_postal(model.getCp());
        }

        adresseRepository.save(adresse);

        return new ResponseEntity<>(adresse, HttpStatus.OK);
    }

}
