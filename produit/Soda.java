package produit;

import java.util.ArrayList;

public class Soda extends Boisson {
	private static ArrayList<String> listMarque;
	private String marque;
	private int index;
	
	public Soda(float prix, float vol, int ind) {
		super(prix, vol);
		if (ind == -1) {
			marque = listMarque.toString();
		}
		else{
			marque = listMarque.get(ind);
		}
		index = ind;
	}
	
	public String toString() {
		return super.toString() + "\n \t  Soda marque : " + marque;
	}
	
	//Initializer ArrayList
	public static void setMarque() {
		listMarque = new ArrayList<String>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
			add("Coca");
			add("Oragina");
			add("Sprite");
		}};
	}
	
	public void setIndex(int ind) {
		index = ind;
		marque = listMarque.get(ind);
	}

	
	public static ArrayList<String> getMarque(){
		return listMarque;
	}
	
	@Override
	public Produit clone() {
		return new Soda(prix, vol, index);
	}
}
