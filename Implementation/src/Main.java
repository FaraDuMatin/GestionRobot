package src;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
/**
 * Cette classe représente l'application principale du système Robotix.
 * Le système permet aux utilisateurs et aux fournisseurs de se connecter, de s'inscrire,
 * et d'effectuer diverses actions en fonction du type d'interface.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        boolean run = true;



        String typeInterface = "";
        Utilisateur utilisateurDansLeSystème = new Utilisateur();
        Fournisseur fournisseurDansLeSystème = new Fournisseur();

        try{
            while(run){
                Scanner scanner = new Scanner(System.in);
                if(typeInterface.equals("")) {
                    System.out.println("***Bienvenue au Système Robotix***");
                    System.out.println("1. Se connecter\n " +
                            "2. S'inscrire\n"+
                            "3. Fermer le système" );
                    int typeEntree = scanner.nextInt();
                    if (typeEntree == 1) {
                        System.out.println("Se connecter comme:\n " +
                                "1.Utilisateur\n" +
                                "2.Fournisseur");
                        boolean connecte = false;
                        while (!connecte) {
                            int choix = scanner.nextInt();
                            scanner.nextLine();
                            if (choix == 1) {
                                utilisateurDansLeSystème = connecterUtilisater(scanner,utilisateurDansLeSystème);
                                typeInterface = "Utilisateur";
                                if(utilisateurDansLeSystème.getPseudo() != null){
                                    connecte = true;
                                }else{
                                    System.out.println("\nSe connecter comme:\n " +
                                            "1.Utilisateur\n" +
                                            "2.Fournisseur");
                                }
                            } else if (choix == 2) {
                                fournisseurDansLeSystème = connecterFournisseur(scanner,fournisseurDansLeSystème);
                                typeInterface ="Fournisseur";
                                if(fournisseurDansLeSystème.getTéléphone() != null){
                                    connecte = true;
                                }else{
                                    System.out.println("\nSe connecter comme:\n " +
                                            "1.Utilisateur\n" +
                                            "2.Fournisseur");
                                }
                            }
                        }
                    } else if (typeEntree == 2) {
                        //Inscription début
                        System.out.println("S'incrire comme:\n " +
                                "1.Utilisateur\n" +
                                "2.Fournisseur");
                        boolean inscrit = false;
                        while (!inscrit) {
                            int choix = scanner.nextInt();
                            if (choix == 1) {
                                utilisateurDansLeSystème = inscrireUtilisateur(scanner, utilisateurDansLeSystème);
                                inscrit = true;
                                typeInterface = "Utilisateur";
                            } else if (choix == 2) {
                                fournisseurDansLeSystème = inscrireFournisseur(scanner, fournisseurDansLeSystème);
                                inscrit = true;
                                typeInterface = "Fournisseur";
                            }
                        }
                    }else if (typeEntree == 3) {
                        run = false;
                    }
                }
                if (typeInterface.equals("Utilisateur")) {
                    afficherInterfaceUtilisateur();
                    int choixAction = scanner.nextInt();
                    scanner.nextLine();
                    if (choixAction == 1){
                        modifierProfileUtilisateur(scanner, utilisateurDansLeSystème);
                    }
                    if (choixAction == 2){
                        gererFlotte(scanner, utilisateurDansLeSystème);
                    }
                    if (choixAction == 3){
                        gererSuiveur(scanner, utilisateurDansLeSystème);
                    }
                    if (choixAction == 4){
                        gererSuiveur(scanner, utilisateurDansLeSystème);
                    }
                    if (choixAction == 5){
                        gererInteret(utilisateurDansLeSystème);
                    }
                    if (choixAction == 6){
                        suivreUtilisateur(scanner, utilisateurDansLeSystème);
                    }
                    if (choixAction == 7){
                        InscrireActivite(scanner, utilisateurDansLeSystème);
                    }
                    if (choixAction == 8){
                        souscrireInteret(scanner, utilisateurDansLeSystème);
                    }
                    if (choixAction == 9){
                        voirEtatRobot(scanner, utilisateurDansLeSystème);
                    }
                    if (choixAction == 10){
                        voirMetriques(scanner);
                    }
                    if (choixAction == 11){
                        voirNotification(scanner);
                    }
                    if (choixAction == 12){
                        typeInterface = "";
                    }
                } else if(typeInterface.equals("Fournisseur")){
                      afficherInterfaceFournisseur();
                    int choixAction = scanner.nextInt();
                    if (choixAction == 1) {
                        modifierProfileFournisseur(scanner, fournisseurDansLeSystème);
                    }else if(choixAction == 2){
                        gererComposantes(scanner, fournisseurDansLeSystème);
                    }else if(choixAction == 3) {
                        enregistrerComposantes(scanner,  fournisseurDansLeSystème);
                    } else if(choixAction == 4) {
                        typeInterface = "";
                    }
                }
            }
        }
        catch(InputMismatchException | NumberFormatException e){
            System.out.println("Erreur. Veuillez redémarrer l'application et faire un choix valide");
        }
    }

    /**
     * Affiche l'interface du fournisseur avec les différentes options disponibles.
     * Cette méthode affiche un menu permettant au fournisseur de sélectionner les actions à effectuer.
     */
    public static void afficherInterfaceFournisseur(){
        System.out.println("--Connexion fournisseur--");
        System.out.println("1.\tModifier son profil\n" +
                "2.\tGérer ses composantes\n" +
                "3.\tEnregistrer une composante\n"+
                "4.\tDéconnexion\n");
    }
    /**
     * Affiche l'interface de l'utilisateur avec les différentes options disponibles.
     * Cette méthode affiche un menu permettant à l'utilisateur de sélectionner les actions à effectuer.
     */

    public static void afficherInterfaceUtilisateur(){
        System.out.println("--Connexion utilisateur--");
        System.out.println("1.\tModifier son profil\n" +
                "2.\tGérer sa flotte (robots et composantes)\n" +
                "3.\tGérer ses suiveurs\n" +
                "4.\tGérer ses activités\n" +
                "5.\tGérer ses intérêts\n" +
                "6.\tSuivre un utilisateur\n" +
                "7.\tS'inscrire à une activité\n" +
                "8.\tSe souscrire à un intérêt\n" +
                "9.\tVoir l'état de ses robots\n" +
                "10.\tVoir les métriques\n" +
                "11.\tVoir ses notifications\n"+
                "12.\tDéconnexion\n" );
    }
    /**
     * Récupère la liste des utilisateurs à partir d'un fichier JSON.
     *
     * @return Une liste d'objets Utilisateur contenant les informations des utilisateurs du système.
     * @throws FileNotFoundException Si le fichier JSON des utilisateurs n'est pas trouvé.
     */
    public static List<Utilisateur> getUtilisateurList() throws FileNotFoundException {
        Gson gson = new Gson();
        Type utilisateurJson = new TypeToken<List<Utilisateur>>() {}.getType();
        List<Utilisateur> utilisateursList;
        try (FileReader reader = new FileReader("Implementation/src/Data/DataUtilisateurs.json")) {
            utilisateursList = gson.fromJson(reader, utilisateurJson);
        } catch (IOException e) {
            utilisateursList = new ArrayList<>();
        }
        return utilisateursList;
    }
    /**
     * Récupère la liste des activités à partir d'un fichier JSON.
     *
     * @return Une liste d'objets Activite contenant les informations des activités du système.
     * @throws FileNotFoundException Si le fichier JSON des activités n'est pas trouvé.
     */
    public static List<Activite> getActiviteList () throws FileNotFoundException {
        Gson gson = new Gson();
        Type activiteJson = new TypeToken<ArrayList<Activite>>() {}.getType();
        ArrayList<Activite> activiteList;
        try (FileReader reader = new FileReader("Implementation/src/Data/DataActivites.json")) {
            activiteList = gson.fromJson(reader, activiteJson);
            /*for (int i = 0; i < activiteList.size(); i++) {
                System.out.println(activiteList.get(i).nom);
            }*/

        } catch (IOException e) {
            activiteList = new ArrayList<>();
        }
        return activiteList;
    }
    /**
     * Recherche un utilisateur dans la liste des utilisateurs par son pseudo.
     *
     * @param pseudoUtilisateur Le pseudo de l'utilisateur à rechercher.
     * @return L'index de l'utilisateur dans la liste s'il est trouvé, sinon retourne 100.
     * @throws FileNotFoundException Si le fichier JSON des utilisateurs n'est pas trouvé.
     */
    public static int rechercherUtilisateur(String pseudoUtilisateur) throws FileNotFoundException {
        List<Utilisateur> utilisateurList = getUtilisateurList();
        for(int index=0; index < utilisateurList.size(); index++){
            if(utilisateurList.get(index).getPseudo().equals(pseudoUtilisateur)){
                return index;
            }
        }
        return 100;
    }
    /**
     * Affiche le profil d'un utilisateur dans le système.
     *
     * @param utilisateurDansLeSystème L'objet Utilisateur dont le profil doit être affiché.
     * @return Le pseudo de l'utilisateur dont le profil est affiché.
     */
    public static String voirProfilUtilisateur(Utilisateur utilisateurDansLeSystème) {
        String pseudo = utilisateurDansLeSystème.getPseudo();
        System.out.println("1. Nom: " + utilisateurDansLeSystème.getNom());
        System.out.println("2. Prénom: " + utilisateurDansLeSystème.getPrenom());
        System.out.println("3. Pseudo: " + utilisateurDansLeSystème.getPseudo());
        System.out.println("4. Téléphone: " + utilisateurDansLeSystème.getTelephone());
        System.out.println("5. Mail: " + utilisateurDansLeSystème.getMail());
        System.out.println("6. Compagnie: " + utilisateurDansLeSystème.getNomCompagnie());
        System.out.println("Que voulez-vous modifiez? ");
        return pseudo;
    }
    /**
     * Affiche le profil d'un fournisseur dans le système.
     *
     * @param fournisseurDansLeSysteme L'objet Fournisseur dont le profil doit être affiché.
     * @return Le nom du fournisseur dont le profil est affiché.
     */
    public static String voirProfilFournisseur(Fournisseur fournisseurDansLeSysteme) {
        System.out.println("1. Nom: " + fournisseurDansLeSysteme.getNom());
        System.out.println("2. Téléphone: " + fournisseurDansLeSysteme.getTéléphone());
        System.out.println("3. Mail: " + fournisseurDansLeSysteme.getMail());
        System.out.println("4. Addresse: " + fournisseurDansLeSysteme.getAdresse());
        System.out.println("Que voulez-vous modifiez? ");
        return fournisseurDansLeSysteme.getNom();

    }
    /**
     * Recherche un fournisseur dans la liste des fournisseurs par son nom.
     *
     * @param nomFournisseur Le nom du fournisseur à rechercher.
     * @return L'index du fournisseur dans la liste s'il est trouvé, sinon retourne 100.
     * @throws FileNotFoundException Si le fichier JSON des fournisseurs n'est pas trouvé.
     */
    public static int rechercherFournisseur(String nomFournisseur) throws FileNotFoundException {
        List<Fournisseur> fournisseurList = getFournisseurList();
        for(int index=0; index < fournisseurList.size(); index++){
            if(fournisseurList.get(index).getNom().equals(nomFournisseur)){
                return index;
            }
        }
        return 100;
    }
    /**
     * Récupère la liste des intérêts à partir d'un fichier JSON.
     *
     * @return Une liste d'objets Interet contenant les informations des intérêts du système.
     * @throws FileNotFoundException Si le fichier JSON des intérêts n'est pas trouvé.
     */
    public static ArrayList<Interet> getInteretList () throws FileNotFoundException {
        Gson gson = new Gson();
        Type interetJson = new TypeToken<ArrayList<Interet>>() {}.getType();
        ArrayList<Interet> interetsList;
        try (FileReader reader = new FileReader("Implementation/src/Data/DataInterets.json")) {
            interetsList = gson.fromJson(reader, interetJson);
            for (int i = 0; i < interetsList.size(); i++) {
                System.out.println(interetsList.get(i).getName());
            }
        } catch (IOException e) {
            interetsList = new ArrayList<>();
        }
        return interetsList;
    }
    /**
     * Récupère la liste des fournisseurs à partir d'un fichier JSON.
     *
     * @return Une liste d'objets Fournisseur contenant les informations des fournisseurs du système.
     * @throws FileNotFoundException Si le fichier JSON des fournisseurs n'est pas trouvé.
     */
    public static List<Fournisseur> getFournisseurList () throws FileNotFoundException {
        Gson gson = new Gson();
        Type fournisseurJson = new TypeToken<ArrayList<Fournisseur>>() {}.getType();
        List<Fournisseur> fournisseursList;
        try (FileReader reader = new FileReader("Implementation/src/Data/DataFournisseurs.json")) {
            fournisseursList = gson.fromJson(reader, fournisseurJson);
        } catch (IOException e) {
            fournisseursList = new ArrayList<>();
        }
        return fournisseursList;
    }
    /**
     * Inscrire un nouvel utilisateur dans le système.
     *
     * @param scanner               Scanner utilisé pour la saisie des informations.
     * @param utilisateurDansLeSytème L'objet Utilisateur pour lequel l'inscription est effectuée.
     * @return L'objet Utilisateur nouvellement inscrit.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de l'écriture dans le fichier JSON.
     */
    public static Utilisateur inscrireUtilisateur(Scanner scanner, Utilisateur utilisateurDansLeSytème) throws IOException {
        System.out.println("Veuillez fournir votre nom");
        String nom = scanner.next();
        System.out.println("Veuillez fournir votre prénom");
        String prenom = scanner.next();
        System.out.println("Veuillez fournir votre pseudo");
        String pseudo = scanner.next();
        System.out.println("Veuillez fournir votre mot de passe");
        String mdp = scanner.next();
        System.out.println("Veuillez fournir votre adresse courriel");
        String mail = scanner.next();
        System.out.println("Veuillez fournir votre numéro de téléphone");
        String telephone = scanner.next();
        System.out.println("Choisissez des intérêts. Écrire chaque intérêt en les séparant par une virgule. (Ex: sport,jeux,lecture,etc..)");
        String interets = scanner.next();
        String[] interetList = interets.split(",");

        List<Interet> interestsList = new ArrayList<>();
        for (String element : interetList) {
            Interet interest = new Interet(element);
            interestsList.add(interest);

        }
        Utilisateur newUtilisateur = new Utilisateur(nom, prenom, pseudo, mdp, mail, telephone, interestsList);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Utilisateur> utilisateurList = getUtilisateurList();
        utilisateurList.add(newUtilisateur);

        FileWriter writer = new FileWriter("Implementation/src/Data/DataUtilisateurs.json");
        gson.toJson(utilisateurList, writer);
        writer.close();

        utilisateurDansLeSytème = newUtilisateur;
        System.out.println("Bienvenue " + utilisateurDansLeSytème.getPseudo());
        return utilisateurDansLeSytème;
    }
    /**
     * Inscrire un nouveau fournisseur dans le système.
     *
     * @param scanner                   Scanner utilisé pour la saisie des informations.
     * @param fournisseurDansLeSystème L'objet Fournisseur pour lequel l'inscription est effectuée.
     * @return L'objet Fournisseur nouvellement inscrit.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de l'écriture dans le fichier JSON.
     */
    public static Fournisseur inscrireFournisseur(Scanner scanner, Fournisseur fournisseurDansLeSystème) throws IOException {
        System.out.println("Veuillez fournir votre nom ");
        String nom = scanner.next();
        System.out.println("Veuillez fournir votre mot de passe");
        String mdp = scanner.next();
        System.out.println("Veuillez fournir votre adresse");
        String adresse = scanner.next();
        System.out.println("Veuillez fournir votre adresse courriel");
        String mail = scanner.next();
        System.out.println("Veuillez fournir votre téléphone");
        String phone = scanner.next();
        System.out.println("**information de la composante que vous offrez**");
        System.out.println("Veuillez donnez un nom à votre composante");
        String composanteName = scanner.next();
        System.out.println("Veuillez donnez un type");
        String type = scanner.next();
        System.out.println("Donnez un prix");
        double prix = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Donnez une courte description");
        String description = scanner.next();
        Composante composante = new Composante(composanteName,type,prix,description);
        List<Composante> listComposante = new ArrayList<>();
        listComposante.add(composante);


        Fournisseur newFournisseur = new Fournisseur(nom, mdp, adresse, mail, phone, listComposante);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Fournisseur> fournisseurList = getFournisseurList();
        fournisseurList.add(newFournisseur);

        FileWriter writer = new FileWriter("Implementation/src/Data/DataFournisseurs.json");
        gson.toJson(fournisseurList, writer);
        writer.close();


        fournisseurDansLeSystème = newFournisseur;
        System.out.println("Bienvenue " + fournisseurDansLeSystème.getNom());
        return fournisseurDansLeSystème;
    }
    /**
     * Connecte un utilisateur dans le système en vérifiant les informations d'identification.
     *
     * @param scanner               Scanner utilisé pour la saisie des informations.
     * @param utilisateurDansLeSystème L'objet Utilisateur actuellement connecté.
     * @return L'objet Utilisateur connecté ou l'objet Utilisateur actuel si la connexion échoue.
     * @throws FileNotFoundException Si le fichier JSON des utilisateurs n'est pas trouvé.
     */
    public static Utilisateur connecterUtilisater(Scanner scanner, Utilisateur utilisateurDansLeSystème) throws FileNotFoundException {
        try{
            System.out.println("Veuillez écrire votre adresse courriel");

            String adresse = scanner.next();
            List<Utilisateur> utilisateurList = getUtilisateurList();
            Utilisateur utilisateurConnecte = new Utilisateur();
            for (Utilisateur utilisateur: utilisateurList) {
                if (utilisateur.getMail().equals(adresse)){
                    utilisateurConnecte = utilisateur;

                }
            }
            System.out.println("Veuillez écrire votre mdp");
            String mdp = scanner.next();
            if (utilisateurConnecte.getMdp().equals(mdp)){
                utilisateurDansLeSystème = utilisateurConnecte;
                System.out.println("Bienvenue " + utilisateurDansLeSystème.getPseudo());
            }else {
                throw new InputMismatchException();
            }
            return utilisateurDansLeSystème;
        }catch(NullPointerException | InputMismatchException e){
            System.out.println("Le mot de passe ou l'addresse courriel que vous avez fournie ne sont pas valides");
            return utilisateurDansLeSystème;
        }
    }
    /**
     * Connecte un fournisseur dans le système en vérifiant les informations d'identification.
     *
     * @param scanner               Scanner utilisé pour la saisie des informations.
     * @param fournisseurDansLeSystème L'objet Fournisseur actuellement connecté.
     * @return L'objet Fournisseur connecté ou l'objet Fournisseur actuel si la connexion échoue.
     * @throws FileNotFoundException Si le fichier JSON des fournisseurs n'est pas trouvé.
     */
    public static Fournisseur connecterFournisseur(Scanner scanner, Fournisseur fournisseurDansLeSystème) throws FileNotFoundException {
        try{
            System.out.println("Veuillez écrire votre adresse courriel");

            String adresseMail = scanner.next();
            List<Fournisseur> fournisseurList = getFournisseurList();
            Fournisseur fournisseurConnecte = new Fournisseur();
            for (Fournisseur fournisseur: fournisseurList) {
                if (fournisseur.getMail().equals(adresseMail)){
                    fournisseurConnecte = fournisseur;
                }
            }
            System.out.println("Veuillez écrire votre mdp");
            String mdp = scanner.next();
            if (fournisseurConnecte.getMdp().equals(mdp)){
                fournisseurDansLeSystème = fournisseurConnecte;
                System.out.println("Bienvenue " + fournisseurConnecte.getNom());
            }else {
                throw new InputMismatchException();
            }
            return fournisseurDansLeSystème;
        }catch(NullPointerException | InputMismatchException e){
            System.out.println("Le mot de passe ou l'addresse courriel que vous avez fournie ne sont pas valides");
            return fournisseurDansLeSystème;
        }
    }
    /**
     * Modifie le profil d'un utilisateur dans le système en fonction du choix de l'utilisateur.
     *
     * @param scanner               Scanner utilisé pour la saisie des informations.
     * @param utilisateurDansLeSystème L'objet Utilisateur dont le profil doit être modifié.
     * @return L'objet Utilisateur dont le profil a été modifié.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de l'écriture dans le fichier JSON.
     */
    public static Utilisateur modifierProfileUtilisateur(Scanner scanner, Utilisateur utilisateurDansLeSystème) throws IOException {
        voirProfilUtilisateur(utilisateurDansLeSystème);
        int choixModification = scanner.nextInt();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        scanner.nextLine();
        if (choixModification == 1) {
            System.out.println("Veuillez choisir un nouveau nom");
            String newName = scanner.nextLine();
            List<Utilisateur> utilisateurList = getUtilisateurList();
            utilisateurList.get(rechercherUtilisateur(utilisateurDansLeSystème.getPseudo())).setNom(newName);
            FileWriter writer = new FileWriter("Implementation/src/Data/DataUtilisateurs.json");
            gson.toJson(utilisateurList, writer);
            writer.close();
            utilisateurDansLeSystème.setNom(newName);
            System.out.println("Nom changé pour " + newName);
        } else if (choixModification == 2) {
            System.out.println("Veuillez choisir un nouveau prénom");
            String newFirstName = scanner.nextLine();
            utilisateurDansLeSystème.setPrénom(newFirstName);
            System.out.println("Prénom changé pour " + newFirstName);
            List<Utilisateur> utilisateurList = getUtilisateurList();
            utilisateurList.get(rechercherUtilisateur(utilisateurDansLeSystème.getPseudo())).setPrénom(newFirstName);
            FileWriter writer = new FileWriter("Implementation/src/Data/DataUtilisateurs.json");
            gson.toJson(utilisateurList, writer);
            writer.close();
        } else if (choixModification == 3) {
            System.out.println("Veuillez choisir un nouveau pseudo");
            String newPseudo = scanner.nextLine();
            List<Utilisateur> utilisateurList = getUtilisateurList();
            utilisateurList.get(rechercherUtilisateur(utilisateurDansLeSystème.getPseudo())).setPseudo(newPseudo);
            FileWriter writer = new FileWriter("Implementation/src/Data/DataUtilisateurs.json");
            gson.toJson(utilisateurList, writer);
            writer.close();
            utilisateurDansLeSystème.setPseudo(newPseudo);
            System.out.println("Pseudo changé pour " + newPseudo);
        } else if (choixModification == 4) {
            System.out.println("Veuillez choisir un nouveau numéro de téléphone");
            String newPhoneNumber = scanner.nextLine();
            utilisateurDansLeSystème.setTéléphone(newPhoneNumber);
            System.out.println("Numéro de téléphone changé pour " + newPhoneNumber);
            List<Utilisateur> utilisateurList = getUtilisateurList();
            utilisateurList.get(rechercherUtilisateur(utilisateurDansLeSystème.getPseudo())).setTéléphone(newPhoneNumber);
            FileWriter writer = new FileWriter("Implementation/src/Data/DataUtilisateurs.json");
            gson.toJson(utilisateurList, writer);
            writer.close();
        } else if (choixModification == 5) {
            System.out.println("Veuillez choisir une nouvelle adresse e-mail");
            String newEmail = scanner.nextLine();
            utilisateurDansLeSystème.setMail(newEmail);
            System.out.println("Adresse e-mail changée pour " + newEmail);
            List<Utilisateur> utilisateurList = getUtilisateurList();
            utilisateurList.get(rechercherUtilisateur(utilisateurDansLeSystème.getPseudo())).setMail(newEmail);
            FileWriter writer = new FileWriter("Implementation/src/Data/DataUtilisateurs.json");
            gson.toJson(utilisateurList, writer);
            writer.close();
        } else if (choixModification == 6) {
            System.out.println("Veuillez choisir une nouvelle compagnie");
            String newCompany = scanner.nextLine();
            utilisateurDansLeSystème.setNomCompagnie(newCompany);
            System.out.println("Compagnie changée pour " + newCompany);
            List<Utilisateur> utilisateurList = getUtilisateurList();
            utilisateurList.get(rechercherUtilisateur(utilisateurDansLeSystème.getPseudo())).setNomCompagnie(newCompany);
            FileWriter writer = new FileWriter("Implementation/src/Data/DataUtilisateurs.json");
            gson.toJson(utilisateurList, writer);
            writer.close();
        }
        return utilisateurDansLeSystème;
    }
    /**
     * Modifie le profil d'un fournisseur dans le système en fonction du choix du fournisseur.
     *
     * @param scanner                   Scanner utilisé pour la saisie des informations.
     * @param fournisseurDansLeSystème L'objet Fournisseur dont le profil doit être modifié.
     * @return L'objet Fournisseur dont le profil a été modifié.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de l'écriture dans le fichier JSON.
     */
    public static Fournisseur modifierProfileFournisseur(Scanner scanner, Fournisseur fournisseurDansLeSystème) throws IOException {
        voirProfilFournisseur(fournisseurDansLeSystème);
        int choixModification = scanner.nextInt();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        scanner.nextLine();
        if (choixModification == 1) {
            System.out.println("Veuillez choisir un nouveau nom");
            String newName = scanner.nextLine();
            List<Fournisseur> fournisseurList = getFournisseurList();
            fournisseurList.get(rechercherFournisseur(fournisseurDansLeSystème.getNom())).setNom(newName);
            FileWriter writer = new FileWriter("Implementation/src/Data/DataFournisseurs.json");
            gson.toJson(fournisseurList, writer);
            writer.close();
            fournisseurDansLeSystème.setNom(newName);
            System.out.println("Nom changé pour " + newName);
        } else if (choixModification == 2) {
            System.out.println("Veuillez choisir un nouveau numéro de téléphone");
            String newPhone = scanner.nextLine();
            fournisseurDansLeSystème.setTéléphone(newPhone);
            System.out.println("Numéro de téléphone changé pour " + newPhone);
            List<Fournisseur> fournisseurList = getFournisseurList();
            fournisseurList.get(rechercherFournisseur(fournisseurDansLeSystème.getNom())).setTéléphone(newPhone);
            FileWriter writer = new FileWriter("Implementation/src/Data/DataFournisseurs.json");
            gson.toJson(fournisseurList, writer);
            writer.close();
        } else if (choixModification == 3) {
            System.out.println("Veuillez choisir une nouvelle addresse courriel");
            String newMail = scanner.nextLine();
            fournisseurDansLeSystème.setMail(newMail);
            System.out.println("Addresse courriel changé pour " + newMail);
            List<Fournisseur> fournisseurList = getFournisseurList();
            fournisseurList.get(rechercherFournisseur(fournisseurDansLeSystème.getNom())).setMail(newMail);
            FileWriter writer = new FileWriter("Implementation/src/Data/DataFournisseurs.json");
            gson.toJson(fournisseurList, writer);
            writer.close();
        } else if (choixModification == 4) {
            System.out.println("Veuillez choisir une nouvelle addresse");
            String newAddresse = scanner.nextLine();
            fournisseurDansLeSystème.setAdresse(newAddresse);
            System.out.println("Addresse changé pour " + newAddresse);
            List<Fournisseur> fournisseurList = getFournisseurList();
            fournisseurList.get(rechercherFournisseur(fournisseurDansLeSystème.getNom())).setAdresse(newAddresse);
            FileWriter writer = new FileWriter("Implementation/src/Data/DataFournisseurs.json");
            gson.toJson(fournisseurList, writer);
            writer.close();
        }

        return fournisseurDansLeSystème;
    }
    /**
     * Gère les composantes d'un fournisseur, y compris la modification et la suppression.
     *
     * @param scanner               Scanner utilisé pour la saisie des informations.
     * @param fournisseurDansLeSystème L'objet Fournisseur dont les composantes doivent être gérées.
     * @return L'objet Fournisseur après avoir géré ses composantes.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de l'écriture dans le fichier JSON.
     * @throws InputMismatchException Si le nom de la composante à modifier n'est pas trouvé dans l'inventaire.
     */
    public static Fournisseur gererComposantes(Scanner scanner, Fournisseur fournisseurDansLeSystème) throws IOException {
        List<Fournisseur> fournisseurList = getFournisseurList();
        List<Composante> composanteList = fournisseurList.get(rechercherFournisseur(fournisseurDansLeSystème.getNom())).getComposantes();
        Composante choixComposante;
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        int indexC=0;
        boolean trouve=false;

        System.out.println("Inventaire: ");
        for(Composante composante: composanteList){
            System.out.println(composante.getNom());
        }
        Scanner scanner2 =  new Scanner(System.in);
        System.out.print("\nNom du composante à modifier: ");
        String nomComposant = scanner2.nextLine();
        for(int index=0; index < composanteList.size(); index++){

            if(composanteList.get(index).getNom().equals(nomComposant)){
                choixComposante = composanteList.get(index);
                indexC = index;
                trouve = true;
            };
        }
        if(!trouve){throw new InputMismatchException();}
        System.out.println("1. Modifier le prix ");
        System.out.println("2. Modifier la description ");
        System.out.println("3. Supprimer la composante ");
        int choixModification = scanner.nextInt();
        scanner.nextLine();
        if (choixModification == 1) {
            System.out.println("Veuillez choisir un nouveau prix");
            String newPrice = scanner.next();
            fournisseurList.get(rechercherFournisseur(fournisseurDansLeSystème.getNom())).getComposantes().
                    get(indexC).setPrix(Double.parseDouble(newPrice));
            FileWriter writer = new FileWriter("Implementation/src/Data/DataFournisseurs.json");
            gson.toJson(fournisseurList, writer);
            writer.close();
            System.out.println("Prix changé pour " + newPrice );
        }
        else if (choixModification == 2) {
            Scanner scanner1 = new Scanner(System.in);
            System.out.println("Veuillez choisir une nouvelle description");
            String newDescription = scanner1.nextLine();
            System.out.println("Description changé pour: " +"\n"+ newDescription );
            fournisseurList.get(rechercherFournisseur(fournisseurDansLeSystème.getNom())).getComposantes().
                    get(indexC).setDescription(newDescription);
            FileWriter writer = new FileWriter("Implementation/src/Data/DataFournisseurs.json");
            gson.toJson(fournisseurList, writer);
            writer.close();
        }else if (choixModification == 3) {
            System.out.println("La composante a été supprimée avec succès");
            fournisseurList.get(rechercherFournisseur(fournisseurDansLeSystème.getNom())).getComposantes().remove(indexC);
            FileWriter writer = new FileWriter("Implementation/src/Data/DataFournisseurs.json");
            gson.toJson(fournisseurList, writer);
            writer.close();
        }
        return fournisseurDansLeSystème;
    }
    /**
     * Enregistre une nouvelle composante pour un fournisseur dans le système.
     *
     * @param scanner               Scanner utilisé pour la saisie des informations.
     * @param fournisseurDansLeSystème L'objet Fournisseur pour lequel la composante doit être enregistrée.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de l'écriture dans le fichier JSON.
     */
    public static void enregistrerComposantes(Scanner scanner, Fournisseur  fournisseurDansLeSystème) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Scanner scanner3 = new Scanner(System.in);
        System.out.println("Veuillez choisir un nom:");
        String nomComposante = scanner3.nextLine();

        System.out.println("Veuillez choisir un prix:");
        double prixComposante = scanner.nextDouble();

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Veuillez choisir une description:");
        String descrComposante = scanner2.nextLine();

        System.out.println("Veuillez choisir un type:");
        String typeComposante = scanner.next();

        Composante nouveauComposante = new Composante(nomComposante, typeComposante, prixComposante, descrComposante);
        List<Fournisseur> fournisseurList = getFournisseurList();
        List<Composante> composanteList = fournisseurList.get(rechercherFournisseur(fournisseurDansLeSystème.
                                            getNom())).getComposantes();
        composanteList.add(nouveauComposante);
        FileWriter writer = new FileWriter("Implementation/src/Data/DataFournisseurs.json");
        gson.toJson(fournisseurList, writer);
        writer.close();
        System.out.println("*Composante enregistrée*");
    }
    /**
     * Gère les intérêts d'un utilisateur, y compris la suppression d'un intérêt existant.
     *
     * @param utilisateur L'objet Utilisateur dont les intérêts doivent être gérés.
     * @throws FileNotFoundException Si le fichier JSON des utilisateurs n'est pas trouvé.
     */

    public static void gererInteret(Utilisateur utilisateur) throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileReader reader = new FileReader("Implementation/src/Data/DataUtilisateurs.json");
        Utilisateur utilisateurList[] = gson.fromJson(reader, Utilisateur[].class);
        for (int i = 0; i < utilisateurList.length; i++) {
            if (utilisateur.getPseudo().equals(utilisateurList[i].getPseudo())) {
                for (int y = 0; y < utilisateur.getInterets().size(); y++) {
                    System.out.println(y + " " + ":" + " " + utilisateur.getInterets().get(y));
                }
            }
        }
        System.out.println("Veuillez saisir le nom de l'intérêt que vous souhaitez supprimer");
        Scanner scanner = new Scanner(System.in);
        String interestToRemove = scanner.next();
        for (int z = 0; z < utilisateur.getInterets().size(); z++) {
            if (utilisateur.getInterets().get(z).getName().equals(interestToRemove)) {
                utilisateur.getInterets().remove(z);
            }
        }


    }
    /**
     * Gère les suiveurs d'un utilisateur, y compris la suppression d'un suiveur existant.
     *
     * @param scanner               Scanner utilisé pour la saisie des informations.
     * @param utilisateurDansLeSystème L'objet Utilisateur dont les suiveurs doivent être gérés.
     * @return L'objet Utilisateur après avoir géré ses suiveurs.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de l'écriture dans le fichier JSON.
     */
    public static Utilisateur gererSuiveur(Scanner scanner, Utilisateur utilisateurDansLeSystème) throws IOException {
        List<Utilisateur> utilisateurList = getUtilisateurList();
        List<Utilisateur> suiveur = utilisateurList.get(rechercherUtilisateur(utilisateurDansLeSystème.getPseudo())).getAbonnée();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("Suiveur ");
        for (Utilisateur abonne : suiveur) {
            System.out.println(abonne.getNom());
            System.out.println("Voulez-vous le supprimer");
            System.out.println("1.Oui");
            System.out.println("2.Non");
            int choixAction = scanner.nextInt();
            scanner.nextLine();
            if (choixAction == 1) {
                suiveur.remove(abonne);
                utilisateurDansLeSystème.setAbonnée(suiveur);
                utilisateurList.get(rechercherUtilisateur(utilisateurDansLeSystème.getPseudo())).setAbonnée(suiveur);
                FileWriter writer = new FileWriter("Implementation/src/Data/DataUtilisateur.json");
                gson.toJson(utilisateurList, writer);
            } else {
                return utilisateurDansLeSystème;
            }
        }
        return utilisateurDansLeSystème;
    }
    /**
     * Souscrit à un nouvel intérêt pour un utilisateur dans le système.
     *
     * @param scanner               Scanner utilisé pour la saisie des informations.
     * @param utilisateurDansLeSystème L'objet Utilisateur pour lequel l'intérêt doit être souscrit.
     * @throws IOException Si une erreur d'entrée/sortie se produit lors de l'écriture dans le fichier JSON.
     */
    public static void souscrireInteret(Scanner scanner, Utilisateur utilisateurDansLeSystème) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Utilisateur> utilisateurList = getUtilisateurList();
        System.out.println("Veuillez donnez un nouvel interêts");
        String nouveauInteret = scanner.nextLine();
        Interet newInterest = new Interet(nouveauInteret);
        List<Interet> newInterestList = utilisateurDansLeSystème.getInterets();
        newInterestList.add(newInterest);
        utilisateurDansLeSystème.setInterets(newInterestList);
        for (Utilisateur utilisateur: utilisateurList){
            if (utilisateur.getNom().equals(utilisateurDansLeSystème.getNom())){
                utilisateur = utilisateurDansLeSystème;
                break;
            }
        }
        FileWriter writer = new FileWriter("Implementation/src/Data/DataUtilisateur.json");
        gson.toJson(utilisateurList, writer);
    }
    /**
     * Permet à un utilisateur de suivre un autre utilisateur en ajoutant ce dernier à sa liste d'abonnements.
     *
     * @param scanner Le scanner pour lire les entrées fournies par l'utilisateur.
     * @param utilisateurDansLeSystème L'utilisateur qui souhaite suivre un autre utilisateur.
     * @return L'utilisateur avec l'abonnement mis à jour.
     * @throws IOException En cas d'erreur lors de l'écriture des données dans le fichier.
     */
    public static Utilisateur suivreUtilisateur(Scanner scanner, Utilisateur utilisateurDansLeSystème) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Utilisateur> utilisateurList = getUtilisateurList();
        System.out.println("Veuillez donnez un nom");
        String nouveauAbonnement = scanner.nextLine();
        Utilisateur newAbonnement = new Utilisateur(nouveauAbonnement);
        List<Utilisateur> abonnementList = utilisateurDansLeSystème.getAbonnement();
        abonnementList.add(newAbonnement);
        utilisateurDansLeSystème.setAbonnement(abonnementList);
        for (Utilisateur utilisateur: utilisateurList){
            if (utilisateur.getNom().equals(utilisateurDansLeSystème.getNom())){
                utilisateur = utilisateurDansLeSystème;
                break;
            }
        }
        FileWriter writer = new FileWriter("Implementation/src/Data/DataUtilisateur.json");
        gson.toJson(utilisateurList, writer);
        return utilisateurDansLeSystème;
    }
    /**
     * Permet à un utilisateur de s'inscrire à une activité parmi une liste d'activités disponibles.
     *
     * @param scanner Le scanner pour lire les entrées fournies par l'utilisateur.
     * @param utilisateurDansLeSystème L'utilisateur qui souhaite s'inscrire à une activité.
     * @return L'utilisateur avec l'inscription mise à jour.
     * @throws IOException En cas d'erreur lors de l'écriture des données dans le fichier.
     */
    public static Utilisateur InscrireActivite(Scanner scanner, Utilisateur utilisateurDansLeSystème) throws IOException{
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Utilisateur> utilisateurList = getUtilisateurList();
        List<Activite> activiteList = getActiviteList();
        System.out.println("List des activitée");
        for (Activite activite: activiteList){
            System.out.println(gson.toJson(activite));
        }
        System.out.println("Choissisez une activité en écrivant son nom");
        String activiteChoisis = scanner.nextLine();
        for (Activite activite: activiteList){
            if (activite.getNom().equals(activiteChoisis)){
                List<Activite> activiteListUtilisateur = utilisateurDansLeSystème.getActivites();
                activiteListUtilisateur.add(activite);
                utilisateurDansLeSystème.setActivites(activiteListUtilisateur);
                break;
            }
        }

        for (Utilisateur utilisateur: utilisateurList){
            if (utilisateur.getNom().equals(utilisateurDansLeSystème.getNom())){
                utilisateur = utilisateurDansLeSystème;
                break;
            }
        }
        FileWriter writer = new FileWriter("Implementation/src/Data/DataUtilisateur.json");
        gson.toJson(utilisateurList, writer);
        return utilisateurDansLeSystème;
    }
    /**
     * Affiche l'état des robots d'un utilisateur.
     *
     * @param scanner Le scanner pour lire les entrées fournies par l'utilisateur.
     * @param utilisateurDansLeSystème L'utilisateur dont les robots doivent être affichés.
     * @return L'utilisateur.
     * @throws IOException En cas d'erreur lors de la lecture des données dans le fichier.
     */
    public static Utilisateur voirEtatRobot(Scanner scanner, Utilisateur utilisateurDansLeSystème) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Robot> robotList = utilisateurDansLeSystème.getRobots();
        System.out.println("État de vos robots");
        for (Robot robots: robotList){
            System.out.println(gson.toJson(robots));
        }
        return utilisateurDansLeSystème;
    }
    /**
     * Permet à un utilisateur de gérer les activités auxquelles il est inscrit, en lui permettant de supprimer des activités de sa liste d'inscriptions.
     *
     * @param scanner Le scanner pour lire les entrées fournies par l'utilisateur.
     * @param utilisateurDansLeSystème L'utilisateur dont les activités doivent être gérées.
     * @return L'utilisateur avec la liste d'activités mise à jour.
     * @throws IOException En cas d'erreur lors de l'écriture des données dans le fichier.
     */
    public static Utilisateur gererActivite(Scanner scanner, Utilisateur utilisateurDansLeSystème) throws IOException {
        List<Utilisateur> utilisateurList = getUtilisateurList();
        List<Activite> activitesInscrit = utilisateurList.get(rechercherUtilisateur(utilisateurDansLeSystème.getPseudo())).getActivites();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("Suiveur ");
        for (Activite activite : activitesInscrit) {
            System.out.println(gson.toJson(activite));
            System.out.println("Voulez-vous la supprimer");
            System.out.println("1.Oui");
            System.out.println("2.Non");
            int choixAction = scanner.nextInt();
            scanner.nextLine();
            if (choixAction == 1) {
                activitesInscrit.remove(activite);

            } else {
                return utilisateurDansLeSystème;
            }
            utilisateurDansLeSystème.setActivites(activitesInscrit);
            utilisateurList.get(rechercherUtilisateur(utilisateurDansLeSystème.getPseudo())).setActivites(activitesInscrit);
            FileWriter writer = new FileWriter("Implementation/src/Data/DataUtilisateur.json");
            gson.toJson(utilisateurList, writer);
        }
        return utilisateurDansLeSystème;
    }
    /**
     * Affiche les notifications d'un utilisateur.
     *
     * @param scanner Le scanner pour lire les entrées fournies par l'utilisateur.
     */
    public static void voirNotification(Scanner scanner){
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Implementation/src/Data/DataNotifications.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Affiche les métriques.
     *
     * @param scanner Le scanner pour lire les entrées fournies par l'utilisateur.
     * @throws FileNotFoundException Si le fichier de métriques n'est pas trouvé.
     */
    public static void voirMetriques(Scanner scanner) throws FileNotFoundException {
        List<Metrique> metriqueList = new ArrayList<Metrique>();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Type listType = new TypeToken<List<Metrique>>() {}.getType();
        try (FileReader reader = new FileReader("Implementation/src/Data/DataMetriques.txt")) {
            metriqueList = gson.fromJson(reader, listType);
            for (Metrique metrique: metriqueList){
                System.out.println(gson.toJson(metrique));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Permet à un utilisateur de gérer sa flotte de robots, en affichant l'état des robots.
     *
     * @param scanner Le scanner pour lire les entrées fournies par l'utilisateur.
     * @param utilisateurDansLeSystème L'utilisateur dont les robots doivent être gérés.
     * @return L'utilisateur.
     * @throws IOException En cas d'erreur lors de la lecture des données dans le fichier.
     */
    public static Utilisateur gererFlotte(Scanner scanner, Utilisateur utilisateurDansLeSystème) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Robot> robotList = utilisateurDansLeSystème.getRobots();
        System.out.println("Votre flotte");
        for (Robot robot: robotList){
            System.out.println(gson.toJson(robot));
            System.out.println(gson.toJson(robot.getComposanteList()));
        }
        return utilisateurDansLeSystème;
    }
}
