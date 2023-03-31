package vehiculo_coche;

public class Test {

	public static void main(String[] args) {
		
		// CREACIÓN OBJETO TIPO COCHE

		Coche damcar = new Coche(4, 0, 60);
		
		// MÉTODOS ACELERAR, CONSUMIR Y FRENAR
		
		damcar.acelerar(100-damcar.getVelocidad());
		damcar.consumir(20);
		damcar.frenar(damcar.getVelocidad()-60);
		
		// GETTER PARA CONSULTAR DEPÓSITO
		
		System.out.println("Quedan " + damcar.getCombustible() + " litros de combustible\n");
		
		// MÉTODOS ACELERAR, CONSUMIR Y FRENAR
		
		damcar.acelerar(90-damcar.getVelocidad());
		damcar.consumir(10);
		damcar.frenar(damcar.getVelocidad()-0);
		
		// MÉTODO ACELERAR (NO PROCEDE AL RESULTAR EN MÁS DE 120KM/H)
		
		damcar.acelerar(130-damcar.getVelocidad());
		
		// GETTER PARA CONSULTAR DEPÓSITO
		
		System.out.println("Quedan " + damcar.getCombustible() + " litros de combustible\n");
		
	}

}
