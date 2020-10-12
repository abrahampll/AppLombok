package pe.como.java8;

import pe.como.java8.service.InterfazDefault;
import pe.como.java8.service.InterfazSuma;
import pe.como.java8.service.MiNombreIntf;

public class Lambda implements InterfazDefault{

	public static void main(String[] args) {
		System.out.println(System.getProperty("java.runtime.version"));
		
		/*puede devolver un string un entero o un booleano
		 * () ->"mi nombre es ";
		 * (n) -> n*n;
		 * (n) -> n==2;
		 */
		System.out.print("Sin Lambda");
		MiNombreIntf miNombre=new MiNombreIntf(){

			@Override
			public String miNombre() {
				// TODO Auto-generated method stub
				return "Abraham";
			}
			
		};
		
		System.out.print("\t\t"+miNombre.miNombre()+"\n");
		
		MiNombreIntf interfaz= () ->"Abraham Peralta";
		System.out.print("Uso de Lambda :");
		System.err.print("\t\t"+interfaz.miNombre()+"\n");
		
		InterfazSuma Interfazjava7= new InterfazSuma() {
			
			@Override
			public int suma(int a, int b) {
				return a+b;
			}
		};
		
		System.err.print("Sin Interfaz 2"+"\t\t"+Interfazjava7.suma(4, 6));
		System.out.println("");		
		
		System.err.print("Interfaz funcional 3 :"+"\t");
		
		InterfazSuma suma= (a,c)-> a+c;
		
		System.out.print("\t\t"+suma.suma(2, 4)+"\n");
		System.err.print("Interfaz funcional 4: ");
		InterfazSuma sum2= (b,c) -> {
			int suma1=b+c;
			int a=b*c;
			System.err.print("Mensaje Lambda :"+"\n");
			System.err.print(" Suma : "+suma1+"\n");
			System.err.print("Multiplicacion : "+a+"\n");
			System.out.print("valor 1: "+b+"\r");
			return 3;
		};
		System.out.print(sum2.suma(2, 3)+"\n");
		Lambda objLambda = new Lambda();
		System.out.println(objLambda.nombrePorDefautl("Abraham"));
		objLambda.mostrarNombre("Julian");
		
		
		
		
		System.exit(0);
	}

	@Override
	public void mostrarNombre(String nombre) {
		// TODO Auto-generated method stub
		System.out.println("Nombre : "+nombre);
		
	}
	
}
