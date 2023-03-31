package abstraccion;

import java.util.*;

public class PrincipalPersona {

	public static void main(String[] args) {

		Alumno a1 = new Alumno("Javi", "Mañeru", "Informática");
		Alumno a2 = new Alumno("Raúl", "Castillo", "Diseño");
		Empleado e1 = new Empleado("Carlos", "Vega", 3, 1200);
		Empleado e2 = new Empleado("María", "Verdugo", 2, 1150);

		ArrayList<Persona> arr = new ArrayList<>();
		
		arr.add(a1);
		arr.add(a2);
		arr.add(e1);
		arr.add(e2);
		
		for (int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i).getDatos());
		}
		
	}

}
