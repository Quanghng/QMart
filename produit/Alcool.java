package produit;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Alcool extends Boisson {
	private float deg;
	
	public Alcool(float prix, float vol, float deg) {
		super(prix, vol);
		this.deg = deg;
	}
	
	public String toString() {
		return super.toString() + "\n \t  Alcool " + deg + " deg";
	}
	
	public boolean verification(Scanner scanner) {
		int x = 0;
		try {
			System.out.println("Entrer votre age : ");
			x = scanner.nextInt();
			System.out.println("Vous avez " + x + " ans");
		return (x >= 18);
		} catch (InputMismatchException e) {
			System.out.println("Le nombre est mal formé");
		}
		return false;
	}


	@Override
	public Produit clone() {
		return new Alcool(prix, vol, deg);
	}
}
