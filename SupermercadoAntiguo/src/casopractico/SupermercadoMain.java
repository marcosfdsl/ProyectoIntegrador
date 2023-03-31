package casopractico;

import java.util.*;

public class SupermercadoMain {
	
	// VARIABLES STATIC
	
	static Scanner sc = new Scanner(System.in);
	static TreeSet<String> productos = new TreeSet<>();
	static String respuesta1;
	static String respuesta2 = "";
	
	// MENÚ GENERAL

	public static void main(String[] args) {
			
		int num1 = 0;
		
		// INVOCAMOS LA FUNCIÓN QUE RELLENA EL TREESET DE PRODUCTOS
		
		rellenarStock();
		
		// INVOCAMOS EL PRIMER SWITCH (ELEGIR ENTRE EMPLEADO Y CLIENTE)
		
		invocarSwitch(num1);
		
		num1 = sc.nextInt();
		
		sc.close();

	}
	
	public static void rellenarStock () {
		
		productos.add("tomate");
		productos.add("aceite");
		productos.add("pan");
		productos.add("leche");
		productos.add("yogur");
		productos.add("queso");
		productos.add("jamón");
		productos.add("harina");
		productos.add("champú");
		productos.add("manzana");
	}
	
	public static void invocarSwitch (int num1) {
		
		// MOSTRAMOS EL MENÚ (EMPLEADO O CLIENTE)
		
		mostrarMenu();
			
		num1 = sc.nextInt();
		
		while (!(num1==1)&&!(num1==2)) {
			System.out.println("No le he entendido, escriba un número entre el 1 y el 2");
			num1 = sc.nextInt();
		}
			
		switch (num1) {

		case 1:
			// INVOCAMOS EL INICIO DE SESIÓN
			inicioSesion();
			break;
	
		case 2:
			int num2 = 0;
			// INVOCAMOS EL SWITCH DE CLIENTE
			invocarSwitchC(num2);
			break;
		}
	}
	
	public static void mostrarMenu () {
		
		// IMPRIMIMOS EL MENÚ (EMPLEADO O CLIENTE)
		
		System.out.println("----------------ACCESO----------------");
		System.out.println("1. Personal del supermercado");
		System.out.println("2. Cliente");
		System.out.println("--------------------------------------");
	}
	
	public static String opcionesMenu () {
		
		// SE PREGUNTA SI SE DESEA MOSTRAR DE NUEVO EL MENÚ O FINALIZAR EL PROGRAMA
		
		System.out.println("\n¿Desea elegir otra opción de MENÚ? (si/no)");
		respuesta1 = sc.nextLine().toLowerCase();
		if (respuesta1.isEmpty()) {
			respuesta1 = sc.nextLine().toLowerCase();
		}
		
		while (!(respuesta1.equals("si"))&&!(respuesta1.equals("no"))) {
			System.out.println("No le he entendido, ¿desea elegir otra opción de MENÚ? (si/no)");
			respuesta1 = sc.nextLine().toLowerCase();
		}
		
		return respuesta1;
	}

	
	// EMPLEADO
	
	public static void inicioSesion () {
		
		// INICIO DE SESIÓN EMPLEADO
		
		System.out.println("Escriba la contraseña");
		
		String intento;
		final String pw = "J4v4d0n4";
		
		intento = sc.nextLine();
		if (intento.isEmpty()) {
			intento = sc.nextLine();
		}

		for (int i = 2; i > 0&&!intento.equals(pw); i--) {
		System.out.println("Respuesta incorrecta, le quedan " + i + " intentos"); 
		intento = sc.nextLine();
		}
		
		if (!intento.equals(pw)) {
		System.out.println("Se le acabaron los intentos");
		System.exit(0);
		}
		
		else {
		System.out.println("Respuesta correcta");
		int num3 = 0;
		// INVOCAMOS EL SWITCH DE EMPLEADO SI LA CONTRASEÑA ES CORRECTA
		invocarSwitchE(num3);
		}
	}
	
	public static void invocarSwitchE (int num3) {
		
		// SWITCH DE EMPLEADO
		
		do {
			
			// INVOCA EL MENÚ DE EMPLEADO
			mostrarMenuE();
			num3 = sc.nextInt();
			
			while (!(num3==1)&&!(num3==2)&&!(num3==3)&&!(num3==4)&&!(num3==5)) {
				System.out.println("No le he entendido, escriba un número entre el 1 y el 5");
				num3 = sc.nextInt();
			}
			
			switch (num3) {

			case 1:
				System.out.println("Productos: " + productos);
				// SE PREGUNTA SI SE DESEA MOSTRAR DE NUEVO EL MENÚ O FINALIZAR EL PROGRAMA
				opcionesMenu();
				break;

			case 2:
				// INVOCAMOS EL CASO 2A DE EMPLEADO
				opcionE2A();
				// SE PREGUNTA SI SE DESEA MOSTRAR DE NUEVO EL MENÚ O FINALIZAR EL PROGRAMA
				opcionesMenu();
				break;

			case 3:
				// INVOCAMOS EL CASO 3 DE EMPLEADO
				opcionE3();	
				// SE PREGUNTA SI SE DESEA MOSTRAR DE NUEVO EL MENÚ O FINALIZAR EL PROGRAMA
				opcionesMenu();
				break;

			case 4:
				// INVOCAMOS EL CASO 4 DE EMPLEADO
				opcionE4();
				// SE PREGUNTA SI SE DESEA MOSTRAR DE NUEVO EL MENÚ O FINALIZAR EL PROGRAMA
				opcionesMenu();
				break;

			case 5:
				respuesta1 = "";
				break;
			}
		}
		
		while (respuesta1.equals("si"));
		
		System.out.println("¡Hasta pronto!");
		
		System.exit(0);
	}
	
	public static void mostrarMenuE () {
		
		// IMPRIME EL MENÚ DE EMPLEADO
		
		System.out.println("-----------------MENÚ-----------------");
		System.out.println("1. Mostrar productos del supermercado");
		System.out.println("2. Añadir productos");
		System.out.println("3. Eliminar producto");
		System.out.println("4. Modificar producto");
		System.out.println("5. Salir");
		System.out.println("--------------------------------------");
	}

	public static void opcionE2A () {
		
		TreeSet<String> productosNo = new TreeSet<>();
		
		// INVOCA EL CASO 2B DE EMPLEADO
		opcionE2B(productosNo);

		while (!(productosNo.isEmpty())) {
			
			System.out.println("Los productos " + productosNo + " ya se encuentran en el supermercado. ¿Desea añadir otro producto? (si/no)");
			productosNo.clear();
			respuesta2 = sc.nextLine().toLowerCase();

			while (!(respuesta2.equals("si"))&&!(respuesta2.equals("no"))) {
				System.out.println("No le he entendido, ¿desea elegir otro producto? (si/no)");
				respuesta2 = sc.nextLine().toLowerCase();
			}
			
			if (respuesta2.equals("si")) {
				// INVOCA EL CASO 2B DE EMPLEADO
				opcionE2B(productosNo);
			}
		}
	}
	
	public static void opcionE2B (TreeSet<String> productosNo) {
		
		// SE AÑADEN AL SUPERMERCADO LOS PRODUCTOS INDICADOS
		
		String productosAñadir;
		String[] productosAñadirArray;
		TreeSet<String> productosSi = new TreeSet<>();
		
		System.out.println("Escriba los productos a añadir separados por espacios y sin comas:");
		productosAñadir = sc.nextLine().toLowerCase();
		if (productosAñadir.isEmpty()) {
			productosAñadir = sc.nextLine().toLowerCase();
		}
		productosAñadirArray = productosAñadir.split(" ");
	
		for (int i = 0; i < productosAñadirArray.length; i++) {
			
			if (productos.contains(productosAñadirArray[i])) {
				productosNo.add(productosAñadirArray[i]);
			}
			
			else if (!(productos.contains(productosAñadirArray[i]))) {
				productos.add(productosAñadirArray[i]);
				productosSi.add(productosAñadirArray[i]);
				System.out.println("Los productos " + productosSi + " fueron añadidos correctamente");
				productosSi.clear();
			}
		}
		
	}
	
	public static void opcionE3 () {

		// SE ELIMINA DEL SUPERMERCADO EL PRODUCTO INDICADO
		
		String productoEliminar;
		
		System.out.println("Escriba el producto que quiere eliminar:");
		productoEliminar = sc.nextLine().toLowerCase();
		if (productoEliminar.isEmpty()) {
			productoEliminar = sc.nextLine().toLowerCase();
		}
		
		while (!(productos.contains(productoEliminar))) {
			System.out.println("El producto especificado no se encuentra en el supermercado, ¿desea volver a escribirlo? (si/no)");
			
			respuesta2 = sc.nextLine().toLowerCase();
			
			while (!(respuesta2.equals("si"))&&!(respuesta2.equals("no"))) {
				System.out.println("No le he entendido, ¿desea volver a escribirlo? (si/no)");
				respuesta2 = sc.nextLine().toLowerCase();
			}
			
			if (respuesta2.equals("si")) {
				System.out.println("Escriba el producto que quiere eliminar:");
				productoEliminar = sc.nextLine().toLowerCase();
				if (productoEliminar.isEmpty()) {
					productoEliminar = sc.nextLine().toLowerCase();
				}
			}
			
			else if (respuesta2.equals("no")) {
				return;
			}
		}
		
		productos.remove(productoEliminar);
		System.out.println("El producto fue eliminado con éxito");
	}
	
	public static void opcionE4 () {

		// SE MODIFICA UN PRODUCTO DEL SUPERMERCADO POR OTRO
		
		String productoModificar1;
		String productoModificar2;
		
		System.out.println("Escriba el producto que quiere modificar:");
		productoModificar1 = sc.nextLine().toLowerCase();
		if (productoModificar1.isEmpty()) {
			productoModificar1 = sc.nextLine().toLowerCase();
		}
			
		while (!(productos.contains(productoModificar1))) {
			System.out.println("El producto especificado no se encuentra en el supermercado, ¿desea volver a escribirlo? (si/no)");
			
			respuesta2 = sc.nextLine().toLowerCase();
			
			while (!(respuesta2.equals("si"))&&!(respuesta2.equals("no"))) {
				System.out.println("No le he entendido, ¿desea volver a escribirlo? (si/no)");
				respuesta2 = sc.nextLine().toLowerCase();
			}
			
			if (respuesta2.equals("si")) {
				System.out.println("Escriba el producto que quiere modificar:");
				productoModificar1 = sc.nextLine().toLowerCase();
				if (productoModificar1.isEmpty()) {
					productoModificar1 = sc.nextLine().toLowerCase();
				}
			}
			
			else if (respuesta2.equals("no")) {
				return;
			}
		}
		
		productos.remove(productoModificar1);
		
		System.out.println("Escriba el producto por el cual lo quiere cambiar:");
		productoModificar2 = sc.nextLine().toLowerCase();
		if (productoModificar2.isEmpty()) {
			productoModificar2 = sc.nextLine().toLowerCase();
		}
		
		if (productos.contains(productoModificar2)) {
			System.out.println("El producto " + productoModificar2 + " ya se encuentra en el supermercado, el producto " + productoModificar1 + " no ha sido modificado");
			productos.add(productoModificar1);
		}
		
		else {
			productos.add(productoModificar2);
			System.out.println("El producto fue cambiado con éxito");
		}
		
	}

	// CLIENTE
	
	public static void invocarSwitchC (int num2) {
		
		// SWITCH DE CLIENTE
		
		ArrayList<String> cestaSi = new ArrayList<>();
		ArrayList<String> cestaNo = new ArrayList<>();
		
		do {
			
			// INVOCA EL MENÚ DE CLIENTE
			mostrarMenuC();
			num2 = sc.nextInt();
			
			while (!(num2==1)&&!(num2==2)&&!(num2==3)&&!(num2==4)&&!(num2==5)&&!(num2==6)) {
				System.out.println("No le he entendido, escriba un número entre el 1 y el 6");
				num2 = sc.nextInt();
			}
			
			switch (num2) {

			case 1:
				System.out.println("Productos: " + productos);
				// SE PREGUNTA SI SE DESEA MOSTRAR DE NUEVO EL MENÚ O FINALIZAR EL PROGRAMA
				opcionesMenu();
				break;

			case 2:
				// INVOCAMOS EL CASO 2A DE CLIENTE
				opcionC2A(cestaSi, cestaNo);
				// SE PREGUNTA SI SE DESEA MOSTRAR DE NUEVO EL MENÚ O FINALIZAR EL PROGRAMA
				opcionesMenu();
				break;

			case 3:
				// INVOCAMOS EL CASO 3 DE CLIENTE
				opcionC3(cestaSi);
				// SE PREGUNTA SI SE DESEA MOSTRAR DE NUEVO EL MENÚ O FINALIZAR EL PROGRAMA
				opcionesMenu();
				break;

			case 4:
				// INVOCAMOS EL CASO 4 DE CLIENTE
				opcionC4(cestaSi);
				// SE PREGUNTA SI SE DESEA MOSTRAR DE NUEVO EL MENÚ O FINALIZAR EL PROGRAMA
				opcionesMenu();
				break;
				
			case 5:
				// INVOCAMOS EL CASO 5 DE CLIENTE
				opcionC5(cestaSi);
				// SE PREGUNTA SI SE DESEA MOSTRAR DE NUEVO EL MENÚ O FINALIZAR EL PROGRAMA
				opcionesMenu();
				break;

			case 6:
				respuesta1 = "";
				break;
			}
		}
		
		while (respuesta1.equals("si"));
		
		System.out.println("¡Hasta pronto!");
		
		System.exit(0);
	}
	
	public static void mostrarMenuC () {
		
		System.out.println("-----------------MENÚ-----------------");
		System.out.println("1. Ver productos del supermercado");
		System.out.println("2. Añadir productos al carrito");
		System.out.println("3. Mostrar carrito de la compra");
		System.out.println("4. Consultar producto de carrito");
		System.out.println("5. Eliminar producto");
		System.out.println("6. Salir");
		System.out.println("--------------------------------------");
	}
	
	public static void opcionC2A (ArrayList<String> cestaSi, ArrayList<String> cestaNo) {
		
		// INVOCA EL CASO 2B DE CLIENTE
		opcionC2B(cestaSi, cestaNo);

		while (!(cestaNo.isEmpty())) {
			
			System.out.println("Los productos " + cestaNo + " no están disponibles. ¿Desea elegir otro producto? (si/no)");
			cestaNo.clear();
			respuesta2 = sc.nextLine().toLowerCase();

			while (!(respuesta2.equals("si"))&&!(respuesta2.equals("no"))) {
				System.out.println("No le he entendido, ¿desea elegir otro producto? (si/no)");
				respuesta2 = sc.nextLine().toLowerCase();
			}
			
			if (respuesta2.equals("si")) {
				opcionC2B(cestaSi, cestaNo);
			}
		}
	}
	
	public static void opcionC2B (ArrayList<String> cestaSi, ArrayList<String> cestaNo) {
		
		// SE AÑADEN A LA CESTA LOS PRODUCTOS INDICADOS
		
		String cestaString = "";
		String[] cestaArray;
		
		System.out.println("Escriba sus productos separados por espacios y sin comas, respetando tildes:");
		cestaString = sc.nextLine().toLowerCase();
		if (cestaString.isEmpty()) {
			cestaString = sc.nextLine().toLowerCase();
		}
		cestaArray = cestaString.split(" ");

		for (int i = 0; i < cestaArray.length; i++) {
			
			if (productos.contains(cestaArray[i])) {
				cestaSi.add(cestaArray[i]);
			}
			
			else if (!(productos.contains(cestaArray[i]))) {
				cestaNo.add(cestaArray[i]);
			}
		}
	}
		
	public static void opcionC3 (ArrayList<String> cestaSi) {
		
		// SE MUESTRA EL CONTENIDO DE LA CESTA
		
		if (!(cestaSi.isEmpty())) {
			System.out.println("Su carrito contiene los siguientes productos: " + cestaSi);
		}
		
		else if (cestaSi.isEmpty()) {
			System.out.println("Su carrito está vacío");
		}
	}
	
	public static void opcionC4 (ArrayList<String> cestaSi) {
		
		// SE CONSULTA SI EL PRODUCTO INDICADO ESTÁ EN LA CESTA
		
		String productoConsultar;
		
		System.out.println("Escriba el producto que quiere consultar:");
		productoConsultar = sc.nextLine().toLowerCase();
		if (productoConsultar.isEmpty()) {
			productoConsultar = sc.nextLine().toLowerCase();
		}

		if (cestaSi.contains(productoConsultar)) {
			System.out.println("Su cesta contiene el producto " + productoConsultar);
		}
		
		else {
			System.out.println("Su cesta no contiene el producto " + productoConsultar);
		}
	}
	
	public static void opcionC5 (ArrayList<String> cestaSi) {
		
		// SE ELIMINA UN PRODUCTO DE LA CESTA
		
		String cestaEliminar;
		
		if (cestaSi.isEmpty()) {
			System.out.println("Su carrito está vacío");
		}
		
		else {
			System.out.println("Escriba el producto que quiere eliminar:");
			cestaEliminar = sc.nextLine().toLowerCase();
			if (cestaEliminar.isEmpty()) {
				cestaEliminar = sc.nextLine().toLowerCase();
			}
			
			while (!(cestaSi.contains(cestaEliminar))) {
				System.out.println("El producto especificado no se encuentra en su cesta, ¿desea volver a escribirlo? (si/no)");
				
				respuesta2 = sc.nextLine().toLowerCase();
				
				while (!(respuesta2.equals("si"))&&!(respuesta2.equals("no"))) {
					System.out.println("No le he entendido, ¿desea volver a escribirlo? (si/no)");
					respuesta2 = sc.nextLine().toLowerCase();
				}
				
				if (respuesta2.equals("si")) {
					System.out.println("Escriba el producto que quiere eliminar:");
					cestaEliminar = sc.nextLine().toLowerCase();
					if (cestaEliminar.isEmpty()) {
						cestaEliminar = sc.nextLine().toLowerCase();
					}
				}
				
				else if (respuesta2.equals("no")) {
					return;
				}
			}
			
			cestaSi.remove(cestaEliminar);
			
			System.out.println("El producto fue eliminado con éxito");
			
		}
	}
	
}