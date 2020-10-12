package pe.como.java8.referencia.app;

import java.util.ArrayList;
import java.util.List;

import pe.como.java8.referencia.bean.User;
import pe.como.java8.referencia.interfaz.InterfTrabajo;
import pe.como.java8.referencia.interfaz.InterfTrabajoString;
import pe.como.java8.referencia.interfaz.InterfUser;

public class AppReferencia {

	
	public static void main(String[] args) {
		/*
		 * Referencia a static  Class::staticMetod Math::abs    ===> m ->Math.abs(n)
		 */
		//sin referencia statica
		//Interfaz
		InterfTrabajo trabajo = new InterfTrabajo() {
			//sobreescribiendo
			@Override
			public void accion() {
				// TODO Auto-generated method stub
				User.referenciaMetodoEstatica();
			}
		};
		
		//con referencia statica
		InterfTrabajo objReferenciaEstatica=() -> {
			System.err.println("Referencia a metodo estatico ");
			User.referenciaMetodoEstatica();
		};
		
		InterfTrabajo trabajoMR= User::referenciaMetodoEstatica;
		trabajoMR.accion();
		
//		objReferenciaEstatica.accion();			
		
		
		/*
		 * Probando a metodo de instancia de un objeto particular
		 *  instancia::metoodInstancia:  s.toString;
		 */
	
//		
		User objUser=new User("Alberto");
		
//		ReferenciaTrabajo objMetodoInstancia = () -> objUser.referenciaInstanciaParticular();
		
		 InterfTrabajo objMetodoInstancia2= objUser::referenciaInstanciaParticular;
		 
		 objMetodoInstancia2.accion();
//		 objMetodoInstancia.accion();
		 
		 /*Referencia a un metodo de instancia Class::metodoInstancia  String::toString    s->s.toString();
		  * de un objeto arbitrario 
		  * de un tipo particular  
		  * 
		  */
		 
		 InterfTrabajoString intefTtrabajoStrnrig = (palabra )->palabra.toUpperCase();
		 InterfTrabajoString trabajoStringRM = String::toUpperCase;
		 System.out.println(trabajoStringRM.accion("alberto"));
		 
		 List<User> user = new ArrayList<>();
		 user.add(new User("mario"));
		 user.add(new User("RicadO"));
		 user.add(new User("Manuel"));
		 
//		 user.forEach(nombre -> nombre.mostrarNombre());
		 user.forEach(User::mostrarNombre);
		 
		 
		 /*
		  * Referencia a un   Class::new    String::new   ()-> new String()
		  * Constructor
		  * 
		  */
		 
		 InterfUser interfUser= new InterfUser() {
			
			@Override
			public User crear(String nombre) {
				// TODO Auto-generated method stub
				return new User(nombre);
			}
		};
		
		InterfUser user2 = (nombre -> new User(nombre));
		InterfUser user3 = User::new;
		
		
		 
		 
	}
}
