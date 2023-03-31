package inmueble;

public class Comercial extends Local {

	private String centroComercial;

	public Comercial(int id, int area, String direccion, int valorCompra, String localizacion, String centroComercial) {
		super(id, area, direccion, valorCompra, localizacion);
		this.centroComercial = centroComercial;
	}

}
