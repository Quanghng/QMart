package produit;

public abstract class Produit {
	protected String nom;
	protected float prix;
	protected static int cpt = 0;
	public final int id;
	
	public Produit(String nom, float prix) {
		id = cpt++;
		this.nom = nom;
		this.prix = prix;
	}
	
	public String toString() {
		return "Produit" + id + ": " + nom.toUpperCase()  + " \n \t  Prix : " + prix + " eu";
	}
	
	public float getPrix() {
		return prix;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String s) {
		nom = s;
	}
	
	public void promotion(int pourcentage) {
		prix -= (prix * pourcentage)/100;
	}
	
	public abstract Produit clone();

}
