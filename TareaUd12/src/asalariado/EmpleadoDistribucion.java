package asalariado;

public class EmpleadoDistribucion extends Asalariado {

	// ATRIBUTOS
	
	private String zona;
	
	// CONSTRUCTOR

	public EmpleadoDistribucion(String nombre, long dni, int vacaciones, String zona) {
		super(nombre, dni, vacaciones);
		this.zona = zona;
	}
	
	// GETTERS

	public String getZona() {
		return zona;
	}
	
	// SETTERS

	public void setZona(String zona) {
		this.zona = zona;
	}

	// TOSTRING
	
	public String toString() {
		return "Empleado: distribución | Nombre: " + getNombre() + " | DNI: " + getDni() + " | Vacaciones: " + getVacaciones() + " | Zona: " + getZona();
	}
	
	
	
}
