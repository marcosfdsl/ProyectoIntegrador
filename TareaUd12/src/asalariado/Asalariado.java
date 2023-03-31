package asalariado;

public class Asalariado {
	
	// ATRIBUTOS
	
	private String nombre;
	private long dni;
	private int vacaciones;
	
	// CONSTRUCTOR
	
	public Asalariado(String nombre, long dni, int vacaciones) {
		this.nombre = nombre;
		this.dni = dni;
		this.vacaciones = vacaciones;
	}

	// GETTERS
	
	public String getNombre() {
		return nombre;
	}
	
	public long getDni() {
		return dni;
	}
	
	public int getVacaciones() {
		return vacaciones;
	}

	// SETTERS
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public void setVacaciones(int vacaciones) {
		this.vacaciones = vacaciones;
	}

}
