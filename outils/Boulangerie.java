package outils;

import produit.Baguette;
import produit.Beignet;

public abstract class Boulangerie {
	public static Baguette faireBaguette(float prix, boolean bio) {
		return new Baguette(prix, bio);
	}
	public static Beignet faireBeignet(Beignet beignet) {
		return new Beignet(beignet.getPrix(), beignet.getDiametre());
	}
}
