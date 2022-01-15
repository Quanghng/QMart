package produit;

public class Boisson extends Produit {
	protected float vol;
	
	public Boisson(float prix, float vol) {
		super("Boisson", prix);
		this.vol = vol;
	}
	
	
	public String toString() {
		return super.toString() + "\n \t  Volume : " + vol;
	}

	public float getVol() {
		return vol;
	}
	
	@Override
	public Produit clone() {
		Boisson cpy = new Boisson(prix, vol);
		if(nom == "Cocktail") {
			cpy.nom = "Cocktail";
		}
		return cpy;
	}
}
