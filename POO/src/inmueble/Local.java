package inmueble;

public class Local extends Inmueble {
	
	private String localizacion;
	
	public Local(int id, int area, String direccion, int valorCompra, String localizacion) {
		super(id, area, direccion, valorCompra);
		this.localizacion = localizacion;
	}

}