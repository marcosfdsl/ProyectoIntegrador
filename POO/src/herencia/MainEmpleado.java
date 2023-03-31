package herencia;

public class MainEmpleado {

	public static void main(String[] args) {

		Empleado e1 = new Empleado("Marcos", "Salamanca", 1000, 2);
		
		System.out.println(e1.getSueldo());
		
		e1.subirSueldo();
		
		System.out.println(e1.getSueldo());
		
		Jefe j1 = new Jefe("Calos", "Salamanca", 2000, 10, 100);
		
		System.out.println(j1.getBonus());

	}

}
