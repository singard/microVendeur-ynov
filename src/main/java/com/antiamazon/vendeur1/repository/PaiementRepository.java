package com.antiamazon.vendeur1.repository;

import com.antiamazon.vendeur1.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Integer> {

    List<Paiement> findPaiementsByVendeurId(int id);

    Paiement findPaiementById(int id);

    void deleteById(int id);

}
