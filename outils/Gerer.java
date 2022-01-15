package outils;

import produit.Produit;

public interface Gerer {
	void remplirRayon(Produit p) throws RayonPleinException;
	void ajouterProduit(Produit p) throws RayonPleinException;
	void enleverProduit(Produit p);
}
