package inmueble;

public class Conjunto extends Urbana {
	
	private int valorAdministracion;
	private boolean areasComunes;

	public Conjunto(int id, int area, String direccion, int valorCompra, int numHabitaciones, int numBaños, int valorAdministracion, boolean areasComunes) {
		super(id, area, direccion, valorCompra, numHabitaciones, numBaños);
		this.valorAdministracion = valorAdministracion;
		this.areasComunes = areasComunes;
	}

}
