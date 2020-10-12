package pe.como.java8.referencia.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class User	 {
	
	
	private String nombre;
	
	//Referencia a metodo statico
	public static void referenciaMetodoEstatica(){
		System.out.println("Probando a referencia metodo Estatico");
	}
	
	//referencia a una metodo de una instancia de un objeto arbitrario particular
	public void referenciaInstanciaParticular(){
		System.out.println("Probando Referencia a Metodo de Objeto particular");
	}
	
	
	
	public void mostrarNombre(){
		System.out.println(nombre);
	}
	
	 

}
