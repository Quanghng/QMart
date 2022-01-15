package produit;

public class Beignet extends Produit {
	private float diametre;
	
	public Beignet(float prix, float dia) {
		super("Pizza", prix);
		diametre = dia;
	}
	
	
	public String toString() {
		return super.toString() + "\n \t  Taille : " + diametre + " cm"; 
	}

	public float getDiametre() {
		return diametre;
	}
	
	@Override
	public Produit clone() {
		return new Beignet(prix, diametre);
	}
}
