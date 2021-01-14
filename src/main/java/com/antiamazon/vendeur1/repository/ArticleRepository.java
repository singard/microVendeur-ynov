package com.antiamazon.vendeur1.repository;

import com.antiamazon.vendeur1.entity.Article;
import com.antiamazon.vendeur1.entity.Vendeur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article,Integer> {
    Article findById(int id);
    List<Article> findAllByVendeur(Vendeur vendeur);
}
