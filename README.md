### TP  de Spring MVC, Spring Data JPA et le moteur de template Thymeleaf


![entite](./captureDEcran/test10.png)

![test](./captureDEcran/test11.png)

Dans cette partie nous avons utiliser spring mvc , en creant la classe controller 
 et en definissant la page ``patients.htlm`` pour  afficher la liste des  patients dans le navigateur

![test](./captureDEcran/test21.png)

Nous affichons les element en offrant la possibilite de  naviguer dans les differentes pages 
via la pagination

![la pagination](./captureDEcran/test30.png)

 Rechercher les element par les noms 
 ![affichage](./captureDEcran/test41.png)
 ![affichage](./captureDEcran/test42.png)
 ![affichage](./captureDEcran/test43.png)

 Fonctionnalite de pour suprimer les elements de la liste
![suppression](./captureDEcran/supprimer.png)

VERION AMELIOREEE:

Dans cette patie nous  allons ameliore l'application en  inserant la dépeendance de  bootstrap
icon ce qui a permis dutiliser les icône de recherche et de suppression
![version ameliorée](./captureDEcran/amelioration.png)

PARTIE 2 

Dans cette partie nous avons définir un template de la  avec   qui va etre utiliser pour 
décorer par les différentes pages de notre application
![code](./captureDEcran/templatecode.png)
![resultat](./captureDEcran/teplateresultat.png)
  
Après la  définissions de la page template, nous avons  avons définis un formulaire qui permet de 
 d'insérer une nouvelle patients  et procéder à a validation du formulaire pour définir a taille maximale et minimale , le score minimal du patient
![formulaire](./captureDEcran/formulaire.png)
![validation](./captureDEcran/validation.png)


PARTIE 3: SPRING SECURITY

 Nous commençons tout d'abord par  l'ajout de  la dépendance spring sécurity a notre projet.nous redémarrons notre 
application et nous essayons d'acceder au a l'application , nous pouvons voir la configuration par défaut suivant:
![securiity 1](./captureDEcran/security1.png)

Le nom de passe génére par defaut permet d'acceder à l'application :

![securiity 2](./captureDEcran/security2.png)
![securiity 3](./captureDEcran/security3.png)
![securiity 4](./captureDEcran/security4.png)

Nous allons personnalisé l configuration de la sécurité de l'application :
 pour  cela nous definissons trois utilisateurs  dont un est un admin :

![securiity 6](./captureDEcran/security6.png) 
 Noous pouvons nous connecter avec l'utilisateur :
- user: ```user1```
- password: ```1234```
![securiity 5](./captureDEcran/security5.png)







 