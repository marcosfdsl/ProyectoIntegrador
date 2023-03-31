package inmueble;

public class Vivienda extends Inmueble {

	private int numHabitaciones;
	private int numBaños;
	
	public Vivienda(int id, int area, String direccion, int valorCompra, int numHabitaciones, int numBaños) {
		super(id, area, direccion, valorCompra);
		this.numHabitaciones = numHabitaciones;
		this.numBaños = numBaños;
	}
		
}
