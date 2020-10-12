package pe.como.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import pe.como.java8.stream.bean.User;


public class StreamPrueba {

	private static List<User> users;
	
	//conjunto de funciones
	public static void main(String[] args) {
		setUpUser();
		Stream<List<User>> stream = Stream.of(users);
		users.stream();
		users.stream().forEach(e ->e.setNombre(e.getNombre()+" Apellido"));
		
		/*users.stream().forEach(e -> 
		System.out.println(e.getId()+" "+ e.getNombre()));*/
		
//		Stream.of(users);
		imprimirLista();
		
		List<String> listString = users.stream().map(e -> e.getNombre()).collect(Collectors.toList());
		System.out.println("===========");
		listString.stream().forEach(e -> System.out.println(e));
		
		System.out.println("======FILTERS=====");
		setUpUser();
		List<User> userFilter = users.stream()
										.filter(e -> e.getNombre()!="Alberto")
										.filter(e -> e.getId()<3)
										.collect(Collectors.toList());
		
		userFilter.stream().forEach(e -> System.out.println(e.getId()+ " "+ e.getNombre()));
		System.out.println("======Find User=====");
		setUpUser();
		User user= users.stream()
						   .filter(e -> e.getNombre().equals("Alberto"))
						   .findFirst()
						   .orElse(new User(1, "pedro"));
		System.out.println(user.getId()+ " " + user.getNombre());
		
		System.out.println("======FlatMap=====");
		List<List<String>> nombreVariasListas = new ArrayList<>(
				Arrays.asList(
						new ArrayList<String>(Arrays.asList("Alberto","Maria","Pedro")),
						new ArrayList<String>(Arrays.asList("Monica","Pablo"))));
		
		//convertir varias listas a varias listas
		List<String> nombresUnicaLista =  nombreVariasListas.stream()
				.flatMap(e -> e.stream())
				.collect(Collectors.toList());
		nombresUnicaLista.stream().forEach(e -> System.out.println(e));

		System.out.println("======Peek=====");//sin ser una accion final
		setUpUser();
		
		List<User> user2 = users.stream()
				.peek(e -> e.setNombre(e.getNombre()+" Apellido")).collect(Collectors.toList());
		
		user2.stream().forEach(e -> System.out.println(e.getNombre()));
		
		System.out.println("======Count=====");
		setUpUser();
		long numeroFiltrado = users.stream()
				.filter( e -> e.getId()< 3)
				.count();
		System.out.println(numeroFiltrado);
		System.out.println("======Skip Limit=====");//Skip salta | limit limita
		
		
		String []  abc = {"a" , "b" , "c" , "d" , "e" , "f" ,"g" ,"h" , "i" , "j"};
		
		List<String> abcFilter = Arrays.stream(abc)
				.skip(2)  //los 2 primeros registros no considerar
				.limit(4)
				.collect(Collectors.toList());
		
		abcFilter.stream().forEach(e -> System.out.println(e));
		
		System.out.println("======Sort=====");//ordena la lista
		users  = users.stream()
			.sorted(Comparator.comparing(User::getNombre))
			.collect(Collectors.toList());
		imprimirLista();
		
		System.out.println("======MIX MAX=====");
		setUpUser();
		User userMin =  users.stream()
				.min(Comparator.comparing(User::getId))
				.orElse(null);
		System.out.println(userMin.getId());
		User userMax =  users.stream()
				.max(Comparator.comparing(User::getId))
				.orElse(null);
		
		System.out.println(userMax.getId());
		
		System.out.println("======DISTINC=====");
		String []  abc1 = {"a" , "b" , "c" , "d" , "e" , "f" ,"g" ,"h" , "i" , "j", "a" , "c"};
		
		List<String> abcFilter1= Arrays.stream(abc1)
									.distinct().collect(Collectors.toList());
		
		abcFilter1.stream().forEach(e ->  System.out.println(e));
									
		System.out.println("======allMatch,anyMatch, noneMatch=====");//el predicaado es verdadero|algu|verifica si alguno pasa del predicado
		
		List<Integer> listaNumeros = Arrays.asList(100, 300 , 900, 5000);
		boolean allMatch = listaNumeros.stream().allMatch(e -> e>301);
		System.out.println(allMatch);
		boolean anyMatch = listaNumeros.stream().anyMatch(e -> e>301);
		System.out.println(anyMatch);
		boolean noneMatch = listaNumeros.stream().noneMatch(e -> e> 1000);
		System.out.println(noneMatch);
		
		System.out.println("======SUM AVAREGE RANGE=====");//el predicaado es verdadero|algu|verifica si alguno pasa del predicado 
		//range iteracion de nelementos
		setUpUser();
		double  result = users.stream()	
				.mapToInt(User::getId)
				.average()
				.orElse(0);
		System.out.println("promedio : " + result);
		
		result = users.stream()
					.mapToInt(User::getId)
					.sum();
		System.out.println("suma : " + result);
		System.out.println("suma : " + IntStream.range(0, 100).sum());
					
		System.out.println("======REDUCE====="); //stream y lo combina en un unico resultado | fol
		setUpUser();
		int numero = users.stream()
						.mapToInt(User::getId)
						.reduce(0, Integer::sum);
		System.out.println("suma " + numero);
		
		System.out.println("======JOINING====="); //concatena una se
		setUpUser();
		String names = users.stream()
						.map(User::getNombre)
						.collect(Collectors.joining("|"))
						.toString();
		System.out.println(names);

		System.out.println("======SUMMARIZINDOUBLE====="); //
		setUpUser();
		DoubleSummaryStatistics stadistica = users.stream()
												.collect(Collectors.summarizingDouble(User::getId));
		
		System.out.println("MEDIA : " +stadistica.getAverage());
		System.out.println("MAXIMO : " +stadistica.getMax());
		System.out.println("MINIMO : "+stadistica.getMin());
		System.out.println("CANTIDAD"+stadistica.getCount());
		System.out.println("SUMA"+stadistica.getSum());
		
		DoubleSummaryStatistics stadistica1 = users.stream()
				.mapToDouble(User::getId)
				.summaryStatistics();

		System.out.println("MEDIA : " +stadistica1.getAverage());
		System.out.println("MAXIMO : " +stadistica1.getMax());
		System.out.println("MINIMO : "+stadistica1.getMin());
		System.out.println("CANTIDAD"+stadistica1.getCount());
		System.out.println("SUMA"+stadistica1.getSum());
		
		
		System.out.println("======PARTITION BY====="); //
		setUpUser();
		List<Integer> listEnteros = Arrays.asList(5,7,34,56,2,3,67,4,98);
		
		Map<Boolean, List<Integer>> esMayor = listEnteros.stream()
					.collect(Collectors.partitioningBy(e ->e>10 ));
		
		esMayor.get(true).stream().forEach(e -> System.out.println(e));
		System.out.println("SEGUNDA LISTA");
		esMayor.get(false).stream().forEach(e -> System.out.println(e));
		
		System.out.println("======GROUP BY====="); //
		setUpUser();
		
		Map<Character, List<User>> grupoAlfabetico = users.stream()
				.collect(Collectors.groupingBy(e -> new Character(e.getNombre().charAt(0))));
		
		grupoAlfabetico.get('A').stream().forEach(e -> System.out.println(e.getNombre()));
		grupoAlfabetico.get('E').stream().forEach(e -> System.out.println(e.getNombre()));
		grupoAlfabetico.get('R').stream().forEach(e -> System.out.println(e.getNombre()));
		System.out.println("======MAPPING====="); // CONVIERTE UNA LISTA DE OBJETOS A OTRA LISTA DE OBJETOS QUE QUERAMOS
		
		setUpUser();
		List<String> personas = users.stream()
				.collect(Collectors.mapping(User::getNombre, Collectors.toList()));
		personas.stream().forEach(e ->  System.out.println(e));
		System.out.println("======STREAM PARALELO====="); // EJECUCION EN PARALELO HASTA VARIOS HILOS
		setUpUser();
		
		long tiempo1=System.currentTimeMillis();
		listString.stream().forEach(e -> convertirAMayuscula(e));
		long tiempo2 = System.currentTimeMillis();
		System.out.println(tiempo2 - tiempo1);
		
		tiempo1=System.currentTimeMillis();
		listString.parallelStream().forEach(e -> convertirAMayuscula(e));
		tiempo2=System.currentTimeMillis();
		System.out.println("PARALELO "+(tiempo2 - tiempo1));
	}
	
	private static String convertirAMayuscula (String nombre){
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nombre.toUpperCase();
	}
	
	private static void setUpUser(){
		users =  new ArrayList<>();
		users.add(new User(1,"Ricardo"));
		users.add(new User(2,"Enzo"));
		users.add(new User(3,"Alberto"));
		users.add(new User(4,"Diego"));
		users.add(new User(5,"Roberto"));
		users.add(new User(6,"Alberto"));
	}
	
	
	private static void imprimirLista(){
		users.stream().forEach(e -> System.out.println(e.getId()+ " "+ e.getNombre()));
	}
}
