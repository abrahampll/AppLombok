package model;

import app.Animal;
import interfaz.IFelino;

public class Jaguar extends Animal implements IFelino {

	private int edad;
	private float peso;
	
	
	public Jaguar() {
		this.setEdad(0);
		this.setPeso(0.0f);
	}
	
	public Jaguar(int edad, float peso) {
		this.edad = edad;
		this.peso = peso;
	}

	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public float getPeso() {
		return peso;
	}
	
	public void setPeso(float peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Jaguar [edad=" + edad + ", peso=" + peso + "]";
	}

	@Override
	public void rugir() {
		System.out.println("El jaguar ruge");
		
	}

	@Override
	public void maullar() {
		throw new UnsupportedOperationException("El jaguar no maulla");
	}

	@Override
	public void cazar() {
		// TODO Auto-generated method stub
		System.out.println("El jaguar no caza!");
	}
	
	
	public void dormir() {
		System.out.println("El jaguar	 duerme");
	}

	public void comer() {
		System.out.println("El jaguar come!");
	}
	
	
}
