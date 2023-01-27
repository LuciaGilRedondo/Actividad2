package juegoEscogido;

import java.util.Random;
import java.text.DecimalFormat;
/* En esta clase vamos a establecer los método para jugar el juego de la heladería, que serán 3:
 * el primero asignará un helado al azar, el segundo comparará el helado creado con el que hizo 
 * el usuario y el tercero evaluará el resultado final.
 * @author Lucía Gil		18/12/2022
 */
public class Heladeria {
	
	// Atributos, entre ellos el random y el formato para los céntimos
	DecimalFormat euros = new DecimalFormat("#0.00€");
	static Random cliente = new Random();
	static int base;
	static int sabor;
	static int topping;
	static double sueldo=0;
	
	/*
	 * Este método genera, a partir del objeto random, un helado al azar, y saca por pantalla
	 * el resultado dado, para que el jugador sepa qué helado hacer.
	 * 
	 * En la parte del sabor, también existe la opción de que el cliente no sepa el sabor que quiere
	 */
	public static void EscogerHelado() {
		base=cliente.nextInt(1,3);
		switch (base) {
		case 1:
			System.out.print("El cliente quiere un helado de cucurucho");
			break;
		case 2:
			System.out.print("El cliente quiere un helado de tarrina");
			break;
		}
		
		sabor=cliente.nextInt(1,8);
		switch (sabor) {
		case 1:
			System.out.print(" de vainilla, ");
			break;
		case 2:
			System.out.print(" de chocolate, ");
			break;
		case 3:
			System.out.print(" sabor cielo, ");
			break;
		case 4:
			System.out.print(" de pistacho, ");
			break;
		case 5:
			System.out.print(" de turrón, ");
			break;
		case 6:
			System.out.print(" de café, ");
			break;
		case 7:
			System.out.print(", el cliente no sabe con exactitud el "
					+ "sabor que quiere, lo que sí tiene seguro es que lo quiere ");
			break;
		}
		
		topping=cliente.nextInt(0,5);
		switch (topping) {
		case 1:
			System.out.println("con virutas de azúcar por encima.");
			break;
		case 2:
			System.out.println("con bolitas de chocolate blanco por encima.");
			break;
		case 3:
			System.out.println("con gominolas por encima.");
			break;
		case 4:
			System.out.println("con cereales por encima.");
			break;
		default:
			System.out.println("sin toppings.");
			break;
		}
	}
	
	/*
	 * Este método evalua el helado hecho por el cliente, asignará 1 punto por cada aspecto del 
	 * helado hecho correctamente, si se acierta todo, hay un 50% de probabilidades de que te de
	 * propina, sin embargo, si fallas algo al cliente no le gustará y habrá un 50% de 
	 * probabilidades de que no nos pague, si nada de esto ocurre, simplemente nos pagará y se irá.
	 * Al final de cada pedido nos saldrá el saldo total recaudado.
	 */
	public void HeladoEscogido(int baseEscogida, int saborEscogido, int toppingEscogido) {
		int puntos=0;
		// Esta condición indica que si un cliente no sabe el sabor y lo escogemos nosotros, podrá gustarle o no
		if (sabor==7) {
			if (cliente.nextInt(1,3)==1) {
				System.out.println("¡Al cliente le ha gustado el sabor! "
						+ "Definitivamente pondrá una buena reseña sobre nosotros en Google :D");
				puntos+=2;
			} else {
				System.out.println("Al cliente no le gustó mucho el helado...");
				sueldo+=1.3;
			}
		} else {
			if (saborEscogido==sabor) {
				puntos+=1;
			}
		}
		
		if (baseEscogida==base) {
			puntos+=1;
		}
		
		if (toppingEscogido==topping) {
			puntos+=1;
		}
		
		if (puntos<=2 && sabor!=7) {
			System.out.print("El cliente está a disgusto con el helado que le has dado");
			if (cliente.nextBoolean()) {
				System.out.print(" y ha salido corriendo sin pagar!");
				System.out.println();
			} else {
				sueldo+=1.3;
				System.out.println();
			}
		}
		
		if (puntos==3) {
			if (cliente.nextBoolean()) {
				double propina=cliente.nextDouble(0.1,1.5);
				System.out.println("¡El cliente agradece tu amable trato con " + euros.format(propina) + " de propina!");
				sueldo+=1.3+propina;
			} else {
				System.out.println("El cliente agarra el helado con una sonrisa y te da el dinero correspondiente :)");
				sueldo+=1.3;
			}
		}
		
		if (puntos!=3 && puntos>2) {
			System.out.println("El cliente agarra el helado con una sonrisa y te da el dinero correspondiente :)");
			sueldo+=1.3;
		}
		
		System.out.println("Sueldo recaudado hasta ahora: " + euros.format(sueldo));
		
	}
	
	/*
	 * Este método se llama una vez han venido los 10 clientes, evalua el sueldo total, si la cantidad llega a 13 (hacer todos
	 * los helados bien, sin tener en cuenta la propina) entonces dirá que ha sido un buen día, si está pordebajo de 9 dirá lo 
	 * contrario.
	 */
	public static void FinJornada() {
		System.out.print("Se acabó la jornada por hoy, ");
		
		if (sueldo>13) {
			System.out.println("ha sido un día muy productivo");
		} else if (sueldo<9) {
			System.out.println("ha habido alguna pérdida, te vas triste del trabajo pero con la esperanza de que mañana sea un día mejor");
		} else {
			System.out.println("ha habido sus más y sus menos, pero ha sido una buena jornada, te vas a casa con ganas de esforzarte más mañana");
		}
	}
	
}
