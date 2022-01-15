package outils;

import produit.Produit;

public class Catalogue {
	private static Produit[] tab;
	private static final Catalogue INSTANCE = new Catalogue();
	
	private Catalogue() {};
	
	public String toString() {
		String s = "";
		s += "Catalogue: \n";
		for(Produit p : tab) {
			s += p + "\n";
		}
		return s;
	}
	
	public Produit getProduit(int ind) {
		return tab[ind];
	}
	
	public static Catalogue getInstance(Produit[] t) {
		tab = t;
		return INSTANCE;
	}
}
