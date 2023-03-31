package inmueble;

public class Oficina extends Local {

	private boolean gobierno;

	public Oficina(int id, int area, String direccion, int valorCompra, String localizacion, boolean gobierno) {
		super(id, area, direccion, valorCompra, localizacion);
		this.gobierno = gobierno;
	}
	
}
