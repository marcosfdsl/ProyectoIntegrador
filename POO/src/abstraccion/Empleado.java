package abstraccion;

public class Empleado extends Persona {

	private int antiguedad;
	private double sueldo;
	
	public Empleado(String nombre, String apellidos, int antiguedad, double sueldo) {
		super(nombre, apellidos);
		this.antiguedad = antiguedad;
		this.sueldo = sueldo;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public String getDatos() {
		return "El empleado " + this.getNombre() + " tiene un sueldo de " + this.getSueldo() + "€ y una antigüedad de " + this.getAntiguedad();
	}
	
}
