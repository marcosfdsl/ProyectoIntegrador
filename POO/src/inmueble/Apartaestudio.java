package inmueble;

public class Apartaestudio extends Apartamento {

	public Apartaestudio(int id, int area, String direccion, int valorCompra, int numHabitaciones, int numBaños,
			int valorAdministracion) {
		super(id, area, direccion, valorCompra, 1, numBaños, valorAdministracion);
	}
	
}
