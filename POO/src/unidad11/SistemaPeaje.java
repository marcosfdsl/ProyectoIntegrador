package unidad11;

public class SistemaPeaje {

	public static void main(String[] args) {

		Peaje miPeaje = new Peaje("San Rafael", "Segovia");
		
		Vehiculo v1 = new Vehiculo("3212DFB", TipoVehiculo.COCHE, "Kia");
		Vehiculo v2 = new Vehiculo("1259KHY", TipoVehiculo.CAMION, "Iveco");
		Vehiculo v3 = new Vehiculo("3456RDS", TipoVehiculo.MOTO, "Honda");
		Vehiculo v4 = new Vehiculo("5698DGB", TipoVehiculo.COCHE, "Renault");
		
		miPeaje.anyadirVehiculo(v1);
		miPeaje.anyadirVehiculo(v2);
		miPeaje.anyadirVehiculo(v3);
		miPeaje.anyadirVehiculo(v4);
		
		miPeaje.calcularPeaje();
		
		System.out.println(miPeaje.imprimir());
		
	}

}
