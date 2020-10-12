package pe.com.app.soft.creacionales.singleton.model;

public class Conexion {

	//Declaracion
	private static Conexion instancia;
	//	private static Conexion instancia = new Conexion();

	//Para evitar instancia mediante operador "new"
	private Conexion() {
		
	}
	
	//Para obtener la instancia unicamente por este metodo
	public static Conexion getInstancia() {
			if(instancia == null) {
				instancia = new Conexion();
			}
		return instancia;
	}
	
	
	//Metodo de prueba
	public void conectar() {
		System.out.println("Me conecte a la BD");
	}

	public void desconectar() {
		System.out.println("Me desconecte a la BD");
	}
	
}
