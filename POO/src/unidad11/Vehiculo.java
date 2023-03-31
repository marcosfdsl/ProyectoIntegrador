package unidad11;

public class Vehiculo {

	private String matricula;
	private TipoVehiculo tipovehiculo;
	private String marca;
	
	public Vehiculo(String matricula, TipoVehiculo tipovehiculo, String marca) {
		this.matricula = matricula;
		this.tipovehiculo = tipovehiculo;
		this.marca = marca;
	}

	public String getMatricula() {
		return matricula;
	}

	public TipoVehiculo getTipovehiculo() {
		return tipovehiculo;
	}

	public String getMarca() {
		return marca;
	}

	@Override
	public String toString() {
		return "El vehículo con matrícula " + matricula + " es de tipo " + tipovehiculo + " y de marca " + marca + " y paga un peaje de " + this.tipovehiculo.getCantidadPeaje() + "€";
	}
	
}
