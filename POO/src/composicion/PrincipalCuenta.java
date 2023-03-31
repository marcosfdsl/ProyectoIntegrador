package composicion;

import java.util.*;

public class PrincipalCuenta {

	static Scanner sc;
	static String respuesta;

	public static void main(String[] args) {

		Cliente t1 = new Cliente("Marcos", "Salamanca", "Maestro Cubiles", "Torrelodones");

		Cuenta c1 = new Cuenta(1234567890123456L, 0.05, t1);
		
		Cuenta.Movimiento mov = c1.new Movimiento(new Date(), 'I', 200);

		menu();

		while (!respuesta.equals("3")) {

			while (!respuesta.equals("1") && !respuesta.equals("2") && !respuesta.equals("3")) {
				System.out.println("No le he entendido");
				menu();
			}

			if (respuesta.equals("1")) {
				System.out.println("¿Cuánto desea ingresar?");
				double ingreso = sc.nextDouble();
				c1.ingreso(ingreso);
				System.out.println("El saldo actual es " + c1.getSaldo() + "€");
				menu();
			}

			else {
				System.out.println("¿Cuánto desea retirar?");
				double retiro = sc.nextDouble();
				c1.reintegro(retiro);
				System.out.println("El saldo actual es " + c1.getSaldo() + "€");
				menu();
			}

		}

		System.out.println("\nSe han realizado los siguientes movimientos:");
		for (int i = 0; i < c1.getMovimientos().size(); i++) {
			System.out.println(c1.getMovimientos().get(i));
		}
		System.out.println("El saldo actual es " + c1.getSaldo() + "€");
		System.out.println("\nHasta pronto");

	}

	public static void menu() {

		System.out.println("\n1. Ingresar dinero");
		System.out.println("2. Sacar dinero");
		System.out.println("3. Salir\n");
		System.out.println("Para elegir una opción, escriba un número entre el 1 y el 3:");

		sc = new Scanner(System.in);

		respuesta = sc.nextLine();

	}

}
