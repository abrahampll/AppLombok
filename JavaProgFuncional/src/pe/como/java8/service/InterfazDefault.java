package pe.como.java8.service;


public interface InterfazDefault {
	
	void mostrarNombre(String nombre);
	
	default String nombrePorDefautl(String nombre){
		return "Nombre : "+nombre;
	}

}
