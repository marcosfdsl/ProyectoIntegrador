package unidad11;

public enum TipoVehiculo {

	COCHE(20, 4),
	CAMION(100, 8),
	MOTO(10, 2);
	
	private int cantidadPeaje;
	private int numRuedas;
	
	private TipoVehiculo(int peaje, int ruedas) {
		this.cantidadPeaje=peaje;
		this.numRuedas=ruedas;
	}

	public int getCantidadPeaje() {
		return cantidadPeaje;
	}

	public void setCantidadPeaje(int cantidadPeaje) {
		this.cantidadPeaje = cantidadPeaje;
	}

	public int getNumRuedas() {
		return numRuedas;
	}

	public void setNumRuedas(int numRuedas) {
		this.numRuedas = numRuedas;
	}
	
}
