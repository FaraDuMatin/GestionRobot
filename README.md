Titre : Système Robotix

Auteurs: Farley Jeannis(20250304), Farah Mohamed(20246646), Wing Sun Cheng(20231986)

Version de Java requise: 19

Courte description : 
  Le système Robotix est un système de gestion de robots offrant une interface pour surveiller, diagnostiquer et planifier différentes tâches liés à ses robots.
  
Liste de fonctionnalité par rôle:

    Fonctionnalités pour utilisateurs:
  
    -Modifier son profil
    -Gérer sa flotte (robots et composantes) 
    -Gérer ses suiveurs 
    -Gérer ses activités
    -Gérer ses intérêts 
    -Suivre un utilisateur 
    -S'inscrire à une activité 
    -Se souscrire à un intérêt 
    -Voir l'état de ses robots 
    -Voir les métriques 
    -Voir ses notifications
    
    Fonctionnalités pour fournisseurs:
  
    -Modifier son profil 
    -Gérer ses composantes 
    -Enregistrer une composante 

Données initiales/informations de connexions(folder Data):

  Utilisateurs -> DataUtilisateurs.json -> connexion(mail & mdp associé à utilisateur)
  
  Fournisseurs -> DataFournisseurs.json -> connexion(mail & mdp associé à fournisseur)
  
  Activités    -> DataActivites.json
  
  Intérêts     -> DataInterets.json
  



Guide d'utilisation de notre application Robotix(Main class):

  1. Décider de se connecter ou s'inscrire en tant que Utilisateurs ou Fournisseur

      1.1. Suite à l'inscription, l'Utilisateur ou le Fournisseur est automatiquement connecté
  
      1.2. Pour se connecter, l'Utilisateur ou le Fournisseur doit rentrer l'email de son profil avec son mot de passe associé qui se trouve dans les fichiers json(DataUtilisateurs.json et DataFournisseurs.json)

3. Suite à la connexion l'Utilisateur ou le Fournisseur se voient présenté un menu correspondant avec plusieurs options
   
      2.1. Un Utilisateur a jusqu'à 11 options différents qu'il peut sélectionner pour modifier son profil, voir ses robots, etc.
   
      2.2. Un Fournisseur a jusqu'à 3 options différents qu'il peut sélectionner pour modifier son profil, gérer ses composantes et enregistrer une composante

5. Après avoir terminé sa session l'Utilisateur ou le Fournisseur peut retouner à la page d'accueil en se déconnectant
6. À partir de la page d'accueil, l'usager peut décider de à nouveau se connecter, créer un nouveau compte ou fermer l'application.
