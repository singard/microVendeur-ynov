package com.antiamazon.vendeur1.controller;

import com.antiamazon.vendeur1.entity.Article;
import com.antiamazon.vendeur1.entity.Vendeur;
import com.antiamazon.vendeur1.repository.ArticleRepository;
import com.antiamazon.vendeur1.repository.VendeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "https://herokuapp.com")
@RestController
public class ArticleController {

    @Autowired
    ArticleRepository articleRepository;
    VendeurRepository vendeurRepository;

    @GetMapping(value = "/article/vendeur/{id}", consumes = "application/json")
    public ResponseEntity<List<Article>> getAllArticleByVendeurId(@PathVariable int idVendeur){
        Optional<Vendeur> vendeur = vendeurRepository.findById(idVendeur);

        if(!vendeur.isPresent())
            return ResponseEntity.notFound().build();

        List<Article> articleList = articleRepository.findAllByVendeur(vendeur.get());
        return new ResponseEntity(articleList,HttpStatus.OK);
    }

    /*@PostMapping(value = "/article/create", consumes = "application/json")
    public ResponseEntity createArticle(@RequestBody Article article){
        Article savedArticle = articleRepository.save(article);
        return new ResponseEntity<Article>(article, HttpStatus.OK);
    }*/

    @PostMapping(value = "/article/create", consumes = "application/json")
    public ResponseEntity createArticle(@RequestBody byte[] photo,@RequestBody String intitule , @RequestBody float prix, @RequestBody int quantite){
        Article article = new Article(photo,intitule,prix,quantite);
        articleRepository.save(article);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/article/{id}" , consumes = "application/json")
    public ResponseEntity deleteArticle(@PathVariable int id){
        articleRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/article/ajoutStock/{id}" , consumes = "application/json")
    public ResponseEntity updateArticleStock(@PathVariable int stockAdd, @PathVariable int id) {

        Article article = articleRepository.findById(id);
        article.setQuantite_dispo(article.getQuantite_dispo() + stockAdd);
        if (article == null)
            return ResponseEntity.notFound().build();

        articleRepository.save(article);

        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/article/{id}" , consumes = "application/json")
    public ResponseEntity updateArticle(@RequestBody Article article, @PathVariable int id){

        Article articleOptional = articleRepository.findById(id);

        if (articleOptional == null)
            return ResponseEntity.notFound().build();

        article.setId(id);

        articleRepository.save(article);

        return ResponseEntity.ok().build();
    }
}
