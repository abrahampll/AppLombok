package pe.com.app.soft.creacionales.singleton.app;

import pe.com.app.soft.creacionales.singleton.model.Conexion;

public class AppSingleton {

	public static void main(String[] args) {
		
		//Instanciación por constructor prohibido por ser "private"
		//Conexion c = new Conexion();
		Conexion c = Conexion.getInstancia();
		c.conectar();
		c.desconectar();
	
		boolean rpta = c instanceof Conexion;
		System.out.println(rpta);
	}
	
}
