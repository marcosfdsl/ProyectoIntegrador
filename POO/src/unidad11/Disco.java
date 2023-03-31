package unidad11;

import java.util.*;

public class Disco {
	
	private String nombre;
	private int año_pub;
	private double precio;
	private int numCanciones;
	ArrayList <Cancion> canciones;
	
	public Disco(String nombre, int año_pub, double precio, int numCanciones) {
		this.nombre = nombre;
		this.año_pub = año_pub;
		this.precio = precio;
		this.numCanciones = numCanciones;
		this.canciones = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getAño_pub() {
		return año_pub;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getNumCanciones() {
		return numCanciones;
	}
	
	public void anyadirCanciones(Cancion c) {
		canciones.add(c);
	}
	
	public void imprimirCanciones() {
		
		for (int i=0; i<canciones.size(); i++) {
			System.out.println("La canción " + (i+1) + " llamada " + canciones.get(i).getNombre() + " tiene una duración de " + canciones.get(i).getDuracion());
		}
		
	}

}
