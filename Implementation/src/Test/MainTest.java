package src.Test;

import org.junit.jupiter.api.Test;
import src.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static src.Main.*;
import static src.Main.rechercherFournisseur;

class MainTest {

	@Test
	void falseRechercheShouldEqual100() throws FileNotFoundException {
		assertEquals(100, rechercherFournisseur("nomPasDansLaList"));
	}
	@Test
	void goodRechercheReturnIndex() throws FileNotFoundException {
		assertEquals(0,rechercherFournisseur("Smith"));
	}
	@Test
	void fournisseurRechercheNotNull() throws FileNotFoundException {
		assertNotNull(rechercherFournisseur("Thompson"));
	}

	@Test
	void utilisateurFalseRechercheShouldEqual100() throws FileNotFoundException {
		assertEquals(100, rechercherUtilisateur("pseudoPasDansLaList"));
	}
	@Test
	void goodRechercheUtilisateurReturnIndex() throws FileNotFoundException {
		assertEquals(0,rechercherUtilisateur("emily.j21"));
	}
	@Test
	void utilisateurRechercheNotNull() throws FileNotFoundException {
		assertNotNull(rechercherUtilisateur("lily.nguyen1"));
	}

	@Test
	void voirProfilFournisseurReturnNom(){
		List<Composante> composantes = new ArrayList<>();
		Composante composante = new Composante(
				"Random Composante",
				"Random Type",
				10.99,
				"This is a random composante description."
		);
		composantes.add(composante);
		Fournisseur fournisseur = new Fournisseur(
				"George",
				"RandomPassword",
				"123 Random Street",
				"random.supplier@example.com",
				"987654321",
				composantes);
		assertEquals("George",voirProfilFournisseur(fournisseur));
	}

	@Test
	void voirProfilFournisseurNotNull(){
		List<Composante> composantes = new ArrayList<>();
		Composante composante = new Composante(
				"Random Composante3",
				"Random Type",
				10.99,
				"random composante description."
		);
		Composante composante2 = new Composante(
				"Composante2",
				"Random Type2",
				10.99,
				"composante2 description."
		);
		composantes.add(composante2);
		composantes.add(composante);
		Fournisseur fournisseur = new Fournisseur(
				"Sam",
				"RandomPassword",
				"123 Random Street",
				"random.supplier@example.com",
				"987654321",
				composantes);
		assertNotNull("Sam",voirProfilFournisseur(fournisseur));
	}

	@Test
	void voirProfilFournisseurNoComposantes(){
		List<Composante> composantes = new ArrayList<>();
		Fournisseur fournisseur = new Fournisseur(
				"Sarah",
				"RandomPassword",
				"123 Random Street",
				"random.supplier@example.com",
				"987654321",
				composantes);
		assertEquals("Sarah",voirProfilFournisseur(fournisseur));
	}

	@Test
	void getUtilisateurDoesNotThrow() throws FileNotFoundException {
		assertDoesNotThrow(() -> {
			getUtilisateurList();
		});
	}
	@Test
	void getUtilisateurNotNull() throws FileNotFoundException {
		assertNotNull(getUtilisateurList());
	}

	@Test
	void getActiviteDoesNotThrow() throws FileNotFoundException {
		assertDoesNotThrow(() -> {
			getActiviteList();
		});
	}
	@Test
	void getActiviteNotNull() throws FileNotFoundException {
		assertNotNull(getActiviteList());
	}
	@Test
	void voirEtatRobotEqualsToArgument() throws IOException {
		Utilisateur test = new Utilisateur();
		Robot robot1 = new Robot();
		Robot robot2 = new Robot();
		List<Robot> robots = new ArrayList<>();
		robots.add(robot1);
		robots.add(robot2);
		test.setRobots(robots);
		Scanner scanner = new Scanner(System.in);
		assertEquals(test, voirEtatRobot(scanner, test));
	}

	@Test
	void voirEtatRobotNotNull() throws IOException {
		Utilisateur test = new Utilisateur();
		Robot robot1 = new Robot();
		Robot robot2 = new Robot();
		List<Robot> robots = new ArrayList<>();
		robots.add(robot1);
		robots.add(robot2);
		test.setRobots(robots);
		Scanner scanner = new Scanner(System.in);
		assertNotNull(voirEtatRobot(scanner, test));
	}
	@Test
	void voirProfilUtilisateurReturnNom(){
		String nom = "Anderson";
		String prenom = "Mia";
		String pseudo = "mia.a23";
		String mdp = "SecretPass09";
		String telephone = "+1-555-432-1098";
		String mail = "mia.anderson@example.com";

		Utilisateur utilisateur = new Utilisateur(nom, prenom, pseudo, mdp, telephone, mail);
		assertEquals("mia.a23",voirProfilUtilisateur(utilisateur));
	}

	@Test
	void voirProfilUtilisateurNotNull(){
		String nom = "Anderson";
		String prenom = "Mia";
		String pseudo = "mia.a23";
		String mdp = "SecretPass09";
		String telephone = "+1-555-432-1098";
		String mail = "mia.anderson@example.com";

		Utilisateur utilisateur = new Utilisateur(nom, prenom, pseudo, mdp, telephone, mail);
		assertNotNull("mia.a23",voirProfilUtilisateur(utilisateur));
	}
	@Test
	void getInteretDoesNotThrow() throws FileNotFoundException {
		assertDoesNotThrow(() -> {
			getInteretList();
		});
	}
	@Test
	void getInteretNotNull() throws FileNotFoundException {
		assertNotNull(getInteretList());
	}
	@Test
	void getFournisseurDoesNotThrow() throws FileNotFoundException {
		assertDoesNotThrow(() -> {
			getFournisseurList();
		});
	}
	@Test
	void getFournisseurNotNull() throws FileNotFoundException {
		assertNotNull(getFournisseurList());
	}


}