package produit;

public class Baguette extends Produit {
	private boolean bio;
	
	public Baguette (float prix, boolean bio) {
		super("Baguette", prix);
		if(bio) {
			nom += " bio";
		}
	}
	
	public void makeBio() {
		if(bio) {
			System.out.println("Déjà très bonne!");
		}
		else {
			bio = true;
			prix *= 2;
		}
	}
	
	public String toString() {
		return (bio) ? super.toString() + "\n \t  Bio" : super.toString();
	}

	@Override
	public Produit clone() {
		return new Baguette(prix, bio);
	}
}
