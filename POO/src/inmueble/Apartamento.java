package inmueble;

public class Apartamento extends Vivienda {

	private int valorAdministracion;
	
	public Apartamento(int id, int area, String direccion, int valorCompra, int numHabitaciones, int numBaños, int valorAdministracion) {
		super(id, area, direccion, valorCompra, numHabitaciones, numBaños);
		this.valorAdministracion=valorAdministracion;
	}

}
