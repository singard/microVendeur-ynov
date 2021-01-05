# microVendeur
com.antiamazon.vendeur1

## Membres et leurs roles :

 | Nom - Prénom | Role |
 |-----------|----------|
 | NDOUR Mouhamadou |features_adresse|
 | GONZALEZ Mathieu  |features_article|
 | LOPES Mattéo|features_article|
 | BOUZEBOUDJA Reyad |features_vendeur|
 | DEBLAECKER Jeremy|features_vendeur|
 | PROUST Baptiste |features_paiement|
 
 -----------------


## Git branches

| Nom branche | Objectif |
 |-----------|----------|
 | features_vendeur | requête des vendeurs |
 | features_article | requête des articles |
 | features_adresse | requête des adresses |
 | features_paiement | requête des paiements |
 
##  Pour toutes les features

<li> Créer les classes Model / Repository / WebController </li>

## Features_vendeur

<li>ajouter / modifier nom de société</li>
<li>ajouter / modifier description</li>
<li>ajouter / modifier une photo</li>
<li>afficher un vendeur par son id</li>

## Features_article

<li>ajouter un article sur un vendeur</li>
<li>modifier un article</li>
<li>afficher les articles d'un vendeur selon une catégorie</li>
<li>modifier son stock</li>
<li>afficher un article par son id</li>
<li>afficher tous les articles d'un vendeur</li>

## Features_adresse

<li>ajouter une adresse à un vendeur</li>
<li>modifier une adresse</li>
<li>afficher les adresses d'un vendeur par son id</li>
<li>afficher une adresse par son id</li>

## Features_paiement

<li>afficher tous les (type de) paiement d'un vendeur par son id</li>
<li>ajouter un (type de) paiement à un vendeur</li>

## Nom des classes


 | Model | Repository | WebController |
 |-----------|----------|----------|
 | Vendeur | VendeurRepository | VendeurController  |
 | Posseder (TI* entre Vendeur et Article) | PossederRepository | / |
 | Article  | ArticleController | ArticleController | 
 | Avoir (TI* entre Vendeur et Adresse) |  AvoirRepository | / | 
 | Adresse | AdresseRepository | AdresseController |
 | Preferer (TI* entre Vendeur et Paiement) | PrefererRepository | / |
 | Paiement | PaiementRepository | PaiementController |

_TI* = Table Intermédiair_
