package com.antiamazon.vendeur1.repository;

import com.antiamazon.vendeur1.entity.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaiementRepository extends JpaRepository<Paiement, Integer> {

}
