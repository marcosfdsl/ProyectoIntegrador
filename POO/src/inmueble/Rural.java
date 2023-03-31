package inmueble;

public class Rural extends Casa {

	private int distanciaNucleo;
	private int altitud;
	
	public Rural(int id, int area, String direccion, int valorCompra, int numHabitaciones, int numBaños, int distanciaNucleo,
			int altitud) {
		super(id, area, direccion, valorCompra, numHabitaciones, numBaños);
		this.distanciaNucleo = distanciaNucleo;
		this.altitud = altitud;
	}

}
