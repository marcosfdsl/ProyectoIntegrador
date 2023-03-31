package vehiculo_coche;

public class Vehiculo {
	
	// ATRIBUTOS

	private int ruedas;
	private int velocidad;
	
	// CONSTRUCTOR 1
	
	public Vehiculo(int ruedas, int velocidad) {
		this.ruedas = ruedas;
		this.velocidad = velocidad;
	}
	
	// CONSTRUCTOR 2 (VALORES A 0)
	
	public Vehiculo() {
		this(0, 0);
	}
	
	// MÉTODO QUE ACELERA
	
	public void acelerar(int mas) {
		System.out.println("(Método 'acelerar' ejecutado desde la clase padre)");
		if ((velocidad+mas)<120) {
			velocidad+=mas;
			System.out.println("Se ha acelerado el vehículo hasta " + velocidad + "km/h\n");
		}
		else {
			System.out.println("No se ha acelerado el vehículo\n");
		}
	}
	
	// MÉTODO QUE FRENA
	
	public void frenar(int menos) {
		System.out.println("(Método 'frenar' ejecutado desde la clase padre)");
		if ((velocidad-menos)>=0) {
			velocidad-=menos;
			System.out.println("Se ha frenado el vehículo hasta " + velocidad + "km/h\n");
		}
		else {
			System.out.println("No se ha frenado el vehículo\n");
		}
	}

	// GETTERS
	
	public int getRuedas() {
		return ruedas;
	}

	public int getVelocidad() {
		return velocidad;
	}
	
}
