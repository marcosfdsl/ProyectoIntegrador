package abstraccion;

public class Alumno extends Persona {

	private String carrera;

	public Alumno(String nombre, String apellidos, String carrera) {
		super(nombre, apellidos);
		this.carrera = carrera;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	@Override
	public String getDatos() {
		return "El alumno " + this.getNombre() + " cursa la carrera " + this.getCarrera();
	}
	
}
