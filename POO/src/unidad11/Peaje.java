package unidad11;

import java.util.*;

public class Peaje {

	private String nombre;
	private String provincia;
	private int totalPeaje;
	private int totalCamiones;
	private int totalCoches;
	private int totalMotos;
	private ArrayList <Vehiculo> coches;
	
	public Peaje(String nombre, String provincia) {
		super();
		this.nombre = nombre;
		this.provincia = provincia;
		this.totalPeaje = 0;
		this.totalCamiones = 0;
		this.totalCoches = 0;
		this.totalMotos = 0;
		this.coches = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public void anyadirVehiculo(Vehiculo v) {
		coches.add(v);
		
		if (v.getTipovehiculo().name().equals(TipoVehiculo.COCHE.name())) {
			this.totalCoches++;			
		}
		
		else if (v.getTipovehiculo().name().equals(TipoVehiculo.CAMION.name())) {
			this.totalCamiones++;			
		}
		
		else {
			this.totalMotos++;			
		}
		
	}
	
	public int calcularPeaje () {
		
		int total = 0;
		
		for (Vehiculo v:coches) {
			total+=v.getTipovehiculo().getCantidadPeaje();
		}
		
		totalPeaje = total;
		
		return total;
		
	}
	
	public String imprimir() {
		
		String texto = "El peaje de " + this.nombre + " de la provincia de " + this.provincia + " ha recaudado " + this.totalPeaje + "€. Los vehículos que han pasado son:\n";
		
		String textoCoche = "";
		
		for (Vehiculo v:coches) {
			textoCoche += v.toString()+"\n";
		}
		
		texto = texto + textoCoche;
		
		return texto;
	
	}
	
}
