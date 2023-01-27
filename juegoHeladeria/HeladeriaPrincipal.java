package juegoEscogido;

import java.util.Scanner;
/* En esta clase permitiremos al usuario jugar llamando a los métodos correspondientes dentro de un bucle
 * para que se repita 10 veces antes de dar el final de jornada
 * @author Lucía Gil		19/12/2022
 */
public class HeladeriaPrincipal {

	public static void main(String[] args) {
		
		// Atributos
		Scanner sc = new Scanner(System.in);
		int baseEscogida;
		int saborEscogido;
		int toppingEscogido;
		Heladeria helado = new Heladeria();
		
		// Menú del juego
		System.out.println("----------Bienvenido a Pichu's Gelateria----------");
		System.out.println("Amanece un nuevo día y abres tu tienda dispuesto a ver las sonrisas de la gente mientras "
				+ "se come un helado junto a los 0ºC que hace en Burgos, entonces, entra un cliente...");
		
		
		// Se inicia un for de clientes, habrá 10 clientes por jornada
		for (int clientes=0; clientes<10; clientes++) {
			// Este método genera un helado al azar para que el cliente lo pida
			Heladeria.EscogerHelado();
			
			// Menús para escoger el helado que el jugador quiere hacer
			System.out.println("¿Qué base escogerás?");
			System.out.println("1. Base de cucurucho.");
			System.out.println("2. Base de tarrina.");
			baseEscogida=sc.nextInt();
			
			
			System.out.println("¿Qué sabor le ponemos?");
			System.out.println("1. Sabor vainilla");
			System.out.println("2. Sabor chocolate");
			System.out.println("3. Sabor cielo");
			System.out.println("4. Sabor pistacho");
			System.out.println("5. Sabor turrón");
			System.out.println("6. Sabor café");
			saborEscogido=sc.nextInt();
			
			
			System.out.println("¿Qué topping le ponemos?");
			System.out.println("1. Toppping de virutas de azúcar");
			System.out.println("2. Toppping de bolitas de chocolate blanco");
			System.out.println("3. Gominolas");
			System.out.println("4. Cereales");
			System.out.println("0. Sin toppings");
			toppingEscogido=sc.nextInt();
			
			// Una vez hecho el helado, se llama al método que comprueba si está hecho correctamente
			helado.HeladoEscogido(baseEscogida, saborEscogido, toppingEscogido);
			
			// Condición para que el último cliente no lleve a otro
				if (clientes < 9) {
					System.out.println("¡Ha venido otro cliente!");
				}
		}
		// El método FinJornada nos dará los resultados finales del juego
		Heladeria.FinJornada();

		sc.close();
	}

}
