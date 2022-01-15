package outils;

import produit.Alcool;
import produit.Boisson;
import produit.Soda;

public abstract class Bartender {
	public static Boisson faireCocktail(Soda b1, Alcool b2) {
		Boisson cocktail = new Boisson((b1.getPrix()+b2.getPrix()), (b1.getVol()+b2.getVol()));
		cocktail.setNom("Cocktail");
		return cocktail;
	}
}
