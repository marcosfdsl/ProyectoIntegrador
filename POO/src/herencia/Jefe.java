package herencia;

public class Jefe extends Empleado {
	
	private int bonus;

	public Jefe(String nombre, String apellidos, int sueldo, int antiguedad, int bonus) {
		super(nombre, apellidos, sueldo, antiguedad);
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
}
