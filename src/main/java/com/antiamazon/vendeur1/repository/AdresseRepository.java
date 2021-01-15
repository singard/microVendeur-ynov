package com.antiamazon.vendeur1.repository;

import com.antiamazon.vendeur1.entity.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdresseRepository extends CrudRepository<Adresse, Integer> {

    Adresse findAdresseById(int id);
    List<Adresse> findAdressesByVendeurId(int id);
    Adresse findAdresseByVendeurId(int id);
    void deleteAdresseById(int id);

}
