package vehiculo_coche;

public class Coche extends Vehiculo {

	// ATRIBUTOS
	
	private int combustible;
	
	// CONSTRUCTOR 1

	public Coche(int ruedas, int velocidad, int combustible) {
		super(ruedas, velocidad);
		this.combustible = combustible;
	}
	
	// CONSTRUCTOR 2 (VALORES A 0)
	
	public Coche() {
		this(0, 0, 0);
	}
	
	// MÉTODO QUE REPOSTA COMBUSTIBLE
	
	public void repostar(int mas) {
		System.out.println("(Método 'repostar' ejecutado desde la clase hija)");
		if ((combustible+mas)<60) {
			combustible+=mas;
			System.out.println("Se han repostado " + mas + " litros\n");
		}
		else {
			System.out.println("No se ha repostado combustible\n");
		}
	}
	
	// MÉTODO QUE CONSUME COMBUSTIBLE
	
	public void consumir(int menos) {
		System.out.println("(Método 'consumir' ejecutado desde la clase hija)");
		if ((combustible-menos)>=0) {
			combustible-=menos;
			System.out.println("Se han consumido " + menos + " litros\n");
		}
		else {
			System.out.println("No se ha consumido combustible\n");
		}
	}
	
	// GETTERS

	public int getCombustible() {
		return combustible;
	}
	
}
