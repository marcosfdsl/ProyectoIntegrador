package inmueble;

public class Inmueble {
	
	private int id;
	private int area;
	private String direccion;
	private int valorCompra;
	
	public Inmueble(int id, int area, String direccion, int valorCompra) {
		this.id = id;
		this.area = area;
		this.direccion = direccion;
		this.valorCompra = valorCompra;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
		this.area = area;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(int valorCompra) {
		this.valorCompra = valorCompra;
	}

}
