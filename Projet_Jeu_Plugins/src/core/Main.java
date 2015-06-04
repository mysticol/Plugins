package core;

import jobs.Carte;
import jobs.Guerrier;
import jobs.Nourriture;
import jobs.Or;
import jobs.Paysan;

public class Main {

	public static void main(String[] args) {
		
		Paysan paysan1 = new Paysan(100, 50, 50);
		Guerrier guerrier1 = new Guerrier(200, 10);
		Or or1 = new Or(1000);
		Nourriture nourriture1 = new Nourriture(1000);
		Carte carte1 = new Carte(8,8);
		
		System.out.println(paysan1.toString());
		System.out.println(guerrier1.toString());
		System.out.println(or1.toString());
		System.out.println(nourriture1.toString());
		
		paysan1.Recolter(or1);
		paysan1.Recolter(nourriture1);
		
		System.out.println(paysan1.toString());
		System.out.println(or1.toString());
		System.out.println(nourriture1.toString());
		carte1.Afficher();
		
		
		

	}

}
