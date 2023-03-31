package asalariado;

public class EmpleadoProduccion extends Asalariado {
	
	// ATRIBUTOS
	
	private String turno;
	
	// CONSTRUCTOR

	public EmpleadoProduccion(String nombre, long dni, int vacaciones, String turno) {
		super(nombre, dni, vacaciones);
		this.turno = turno;
	}

	// GETTERS
	
	public String getTurno() {
		return turno;
	}
	
	// SETTERS

	public void setTurno(String turno) {
		this.turno = turno;
	}
	
	// TOSTRING

	@Override
	public String toString() {
		return "Empleado: producción | Nombre: " + getNombre() + " | DNI: " + getDni() + " | Vacaciones: " + getVacaciones() + " | Turno: " + getTurno();
	}
	
}
