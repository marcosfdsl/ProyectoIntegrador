package herencia;

public class Empleado {

	protected String nombre;
	protected String apellidos;
	protected int sueldo;
	protected int antiguedad;
	
	public Empleado(String nombre, String apellidos) {
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Empleado(String nombre, String apellidos, int sueldo, int antiguedad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sueldo = sueldo;
		this.antiguedad = antiguedad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
	
	public void subirSueldo() {
		sueldo = sueldo/100*105;
	}
	
}
