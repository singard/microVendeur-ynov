package com.antiamazon.vendeur1.controller;

import com.antiamazon.vendeur1.controller.entity.Paiement;
import com.antiamazon.vendeur1.controller.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://guarded-badlands-84396.herokuapp.com")
@RestController
public class PaiementController {

    @Autowired
    PaiementRepository paiementRepository;

    @PostMapping(value="/paiement")
    public Paiement createPaiement(@RequestBody Paiement paiement) { return paiementRepository.save(paiement); }

    @GetMapping(value="getAllPaiement")
    public List<Paiement> showAllPaiements() { return paiementRepository.findAll(); }

    @GetMapping(value="getPaiement/{id}")
    public Optional<Paiement> showPaiementPerId(@PathVariable Integer id) { return paiementRepository.findById(id); }

    @DeleteMapping(value="deletePaiement/{id}")
    public void deletePaiementPerId(@PathVariable Integer id) { paiementRepository.deleteById(id); }
}
