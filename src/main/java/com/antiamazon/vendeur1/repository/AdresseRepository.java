package com.antiamazon.vendeur1.repository;

import com.antiamazon.vendeur1.entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdresseRepository extends JpaRepository<Adresse, Integer> {

}
