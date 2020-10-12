package app;

import model.Jaguar;

public class Principal {

	public static void main(String[] args) {
		//Instanci = crerar un objeto
		Jaguar yagua= new Jaguar(10,120f);
		
		Jaguar yagua2= new Jaguar();
		
		System.out.println(yagua2	);
//		System.out.println("Edad : "+yagua.getEdad()+" Peso : "+yagua.getPeso());
		System.out.println(yagua.toString());
		yagua.cazar();
		yagua.rugir();
		yagua.dormir();
		yagua.maullar();
		yagua.comer();
		
		System.exit(0);
		
	}
}
