package qMart;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import outils.Bartender;
import outils.Boulangerie;
import outils.Catalogue;
import outils.RayonPleinException;
import produit.Alcool;
import produit.Baguette;
import produit.Beignet;
import produit.Boisson;
import produit.Glace;
import produit.Produit;
import produit.Soda;
import rayon.Rayon;

public class QMart {
	public static void main(String[] args) {
		//Cote magasin
		//Initializer le rayon/catalogue
		Glace.setMenu();
		Glace glace = new Glace(3, -1);
		
		Soda.setMarque();
		Soda soda = new Soda(2, 75, -1);
		Alcool alcool = new Alcool(10, 150, 50);
		
		Beignet beignet = new Beignet(2.5f, 30);
		Baguette baguette = new Baguette(0.50f, false);
		
		Boisson cocktail = Bartender.faireCocktail(soda, alcool);
		Beignet beignet2 = Boulangerie.faireBeignet(beignet); 	//clone
		Baguette baguette2 = Boulangerie.faireBaguette(1, true);
		
		Produit tab[] = {glace, soda, alcool, beignet, baguette, cocktail, beignet2, baguette2};
		Catalogue catalogue = Catalogue.getInstance(tab); //Singleton
		
		Rayon rayon = new Rayon(10);
		for(Produit p : tab) {
			try {
				rayon.ajouterProduit(p);
			} catch (RayonPleinException e) {
				e.printStackTrace();
			}
		}
		
		//Cote client
		System.out.println("Bienvenue chez QMart");
		System.out.println(catalogue);
		ArrayList<Produit> panier = new ArrayList<Produit>();
		int x;
		int c = 0;
		try (Scanner scanner = new Scanner(System.in)){
			do {
				System.out.println("Entrer votre choix :");
				x = scanner.nextInt();
				if ((x < 0) || (x >= rayon.getNbProduit())) {
					System.out.println("Veuillez ressayer");
					c = 1;
					continue;
				}
				else {
					Produit produit = catalogue.getProduit(x);
					if(produit instanceof Glace) {
						System.out.println("Veuillez choisir la saveur:");;
						int i = scanner.nextInt();
						if ((i >=0) && (i < Glace.getMenu().size()))
							glace.setIndex(i);
						else {
							System.out.println("Veuillez ressayer");
							System.out.println("Vous voulez continuer votre achat ? \n0: Non \t 1: Oui");
							c = scanner.nextInt();
							continue;
						}
					}
					else if(produit instanceof Alcool) {
						if (!alcool.verification(scanner)) { //Si il a bien plus 18 ans
							System.out.println("Vous n'avez pas l'âge requis pour acheter de l'alcool");
							System.out.println("Vous voulez continuer votre achat ? \n0: Non \t 1: Oui");
							c = scanner.nextInt();
							continue;
						}
					}
					else if(produit instanceof Soda) {
						System.out.println("Veuillez choisir la marque:");;
						int i = scanner.nextInt();
						if ((i >=0) && (i < Soda.getMarque().size()))
							soda.setIndex(i);
						else {
							System.out.println("Veuillez ressayer");
							System.out.println("Vous voulez continuer votre achat ? \n0: Non \t 1: Oui");
							c = scanner.nextInt();
							continue;
						}
					}
					panier.add(produit);
					System.out.println(produit + "\nest ajouté au panier.\n");
					//rayon.enleverProduit(produit); Marche pas pour l'instant
					System.out.println("Vous voulez continuer votre achat ? \n0: Non \t 1: Oui");
					c = scanner.nextInt();
				}
			}while((c == 1) || (rayon.getNbProduit() < 0));
		} catch (InputMismatchException e) {
					System.out.println("Le nombre est mal formé, veuillez ressayer!");
		}
//		if(c != 1) {
//			System.out.println(rayon);
//		}
		
		System.out.println("Votre panier:");
		System.out.println(panier);
		
		//Calculer le montant
		int s = 0;
		for(Produit p : panier) {
			s += p.getPrix();
		}
		System.out.println("Montant: " + s);
		System.out.println("Merci beaucoup, au revoir!!");
		
		/**
		 * Amelioration: Restock: clone un rayon
		 * 				 Utilise les methodes restantes (Ex: utilise Math.random pour la chance d'avoir la promotion
		 * 				 Mieux gerer les exceptions
		 */
	}

}
