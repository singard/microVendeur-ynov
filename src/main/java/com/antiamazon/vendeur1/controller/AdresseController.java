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

import java.util.List;

@CrossOrigin
@RestController
public class AdresseController {

    @Autowired
    AdresseRepository adresseRepository;
    @Autowired
    VendeurRepository vendeurRepository;

    @GetMapping(value = "/adresse/all/{vendeurId}")
    public ResponseEntity getAllAdresses(@PathVariable int vendeurId){
        Vendeur vendeur = vendeurRepository.findVendeurById(vendeurId);
        if(vendeur == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Vendeur introuvable !");
        }
        List<Adresse> adresses = adresseRepository.findAdressesByVendeurId(vendeurId);
        return new ResponseEntity<List<Adresse>>(adresses, HttpStatus.OK);
    }

    @GetMapping(value = "/adresse/show/{adresseId}")
    public ResponseEntity show(@PathVariable int adresseId){
        Adresse adresse = adresseRepository.findAdresseById(adresseId);

        if(adresse == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Adresse introuvable !");
        }

        return new ResponseEntity<Adresse>(adresse, HttpStatus.OK);
    }

    @DeleteMapping(value = "/adresse/delete/{adresseId}")
    public ResponseEntity<Integer> delete(@PathVariable int adresseId){
        Adresse adresse = adresseRepository.findAdresseById(adresseId);

        if(adresse == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        adresseRepository.deleteAdresseById(adresseId);

        return new ResponseEntity<>(adresseId, HttpStatus.OK);
    }

    @PostMapping(value = "/adresse/new/{vendeurId}")
    public ResponseEntity<Adresse> newAdresse(@PathVariable int vendeurId, @RequestBody NewAdresseModel model){
        Vendeur vendeur = vendeurRepository.findVendeurById(vendeurId);

        if(vendeur == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Adresse adresse = new Adresse();
        adresse.setRue(model.getRue());
        adresse.setVille(model.getVille());
        adresse.setCode_postal(model.getCode_postal());
        adresseRepository.save(adresse);

        return new ResponseEntity<>(adresse, HttpStatus.OK);
    }

    @PutMapping(value = "/adresse/update/{adresseId}")
    public ResponseEntity<Adresse> updateAdresse(@PathVariable int adresseId, @RequestBody NewAdresseModel model){
        Adresse adresse = adresseRepository.findAdresseById(adresseId);

        if(adresse == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if(!model.getRue().isEmpty()){
            adresse.setRue(model.getRue());
        }
        if(!model.getVille().isEmpty()){
            adresse.setVille(model.getVille());
        }
        if(!String.valueOf(model.getCode_postal()).isEmpty()){
            adresse.setCode_postal(model.getCode_postal());
        }
        adresseRepository.save(adresse);

        return new ResponseEntity<>(adresse, HttpStatus.OK);
    }


}
