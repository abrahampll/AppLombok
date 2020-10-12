package pe.como.java8.optional;

import java.util.Optional;

public class OptionalPrueba {

	public static void main(String[] args) {
//		probarOptional(null);
//		orElseOptional(null);
//		orElseThrow(null);
		isPresent("alberto");
		isPresent(null);
	}
	
	public static void probarOptional(String nombre){
		System.out.println(nombre.length());
		
		
	}
	
	
	public static void crearOptional(){
		Optional<String> optional=Optional.empty();
		optional.get();
	}

	public static void orElseOptional(String nombre){
		Optional<String> optional = Optional.ofNullable(nombre);
//		Optional<String> optional1 = Optional.of(nombre);
		
		String nombreOfNullable=optional.orElse("vacio");
//		String nombreOf = optional1.orElse("vacio");
		
		System.out.println(nombreOfNullable);
//		System.out.println(nombreOf);
	}
	
	
	public static void orElseThrow(String nombre){
		Optional<String> optional = Optional.ofNullable(nombre);
		optional.orElseThrow(NullPointerException::new);
	}
	
	public static void isPresent(String nombre){
		Optional<String> optional = Optional.ofNullable(nombre);
		System.out.println(optional.isPresent());
	}
}
