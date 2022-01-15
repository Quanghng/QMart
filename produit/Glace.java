package produit;

import java.util.ArrayList;

public class Glace extends Produit {
	private String saveur;
	private int index;
	private static ArrayList<String> menu;
	
	
	public Glace(float prix, int ind) {
		super("Glace", prix);
		if (ind == -1) {
			saveur = menu.toString();
		}
		else{
			saveur = menu.get(ind);
		}
		index = ind;
	}
	
	public void mixFlavor(int ind) {
		saveur += " and " + menu.get(ind);
		prix *= 2;
	}
	
	public void rainbow() {
		saveur = "";
		boolean isFirst = true;
		for (int i = 0; i < menu.size(); i++) {
			if (isFirst) {
				isFirst = false;
			}
			else {
				saveur += ", ";
				saveur += menu.get(i);
			}
			saveur +=  menu.get(i);
		}
		prix *=3;
	}
	
	//Initializer ArrayList
	public static void setMenu() {
		menu = new ArrayList<String>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
			add("Banane");
			add("Fraise");
			add("Choco");
		}};
	}
	
	public void setIndex(int ind) {
		index = ind;
		saveur = menu.get(ind);
	}
	
	public static ArrayList<String> getMenu(){
		return menu;
	}
	
	public void ajouterSaveur(String saveur) {
		menu.add(saveur);
	}
	
	
	@Override
	public String toString() {
		return super.toString() + "\n \t  Saveur : " + saveur;
	}

	@Override
	public Produit clone() {
		return new Glace(prix, index);
	}

}
