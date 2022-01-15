package rayon;

import outils.Gerer;
import outils.RayonPleinException;
import produit.Produit;

public class Rayon implements Gerer {
	protected Produit[] rayon;
	protected int nbPro;
	protected int capacite;
	
	public Rayon(int cap) {
		rayon = new Produit[cap];
		nbPro = 0;
		capacite = cap;
	}
	
	public boolean estVide() {
		return rayon.length == 0;
	}
	public boolean estPlein() {
		return nbPro == rayon.length;
	}

	@Override
	public void remplirRayon(Produit p) throws RayonPleinException {
		while(!estPlein()) {
			ajouterProduit(p);
		}
		System.out.println("Le rayon est rempli");
	}

	@Override
	public void ajouterProduit(Produit p) throws RayonPleinException {
		try {
			rayon[nbPro++] = p;
		} catch(ArrayIndexOutOfBoundsException e) {
			throw new RayonPleinException();
		}
	}
	
	@Override
	public void enleverProduit(Produit p) {
		try {
			rayon[--nbPro] = p;
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Rayon est vide");
		}
	}
	
	
	public int getNbProduit() {
		return nbPro;
	}
	
	public String toString() {
		String s = "Rayon : [";
		boolean isFirst = true;
		if(!estVide()) {
			for (Produit p : rayon) {
				if (p != null) {
					if (isFirst) {
						isFirst = false;
					}
					else {
						s += ", ";
					}
					s += p.getNom();
				}
			}
			s += "]";
			return s;
		}
		else
			return "Rayon vide";
	}
	
	public Rayon clone() {
		Rayon cpy = new Rayon(capacite);

		for(Produit p : rayon) {
			if (p != null) {
				try {
					cpy.ajouterProduit(p.clone());
				} catch (RayonPleinException e) {
					System.out.println(e);
					break;
				}
			}
		}
		return cpy;
	}
	
	
}
