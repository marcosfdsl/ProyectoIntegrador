package composicion;

import java.util.*;

public class Cuenta {
	
	private long numero;
	private double saldo;
	private double interesAnual;
	private Cliente cliente;
	private ArrayList<Movimiento> movimientos;
	
	public class Movimiento {
		
		private Date fecha;
		private char tipo;
		private double importe;
		
		public Movimiento(Date fecha, char tipo, double importe) {
			this.fecha = fecha;
			this.tipo = tipo;
			this.importe = importe;
		}

		@Override
		public String toString() {
			return "-El día " + fecha + " se hizo un movimiento de tipo " + tipo + " con un importe de " + importe + "€";
		}
		
	}
	
	public Cuenta(long numero, double interesAnual, Cliente cliente) {
		this.numero = numero;
		this.saldo = 0;
		this.interesAnual = interesAnual;
		this.cliente = cliente;
		this.movimientos = new ArrayList<>();
	}
	
	public Cuenta(long numero) {
		this(numero, 0.1, null);
	}
	
	public void ingreso(double cantidad) {
		Movimiento m = new Movimiento(new Date(), 'I', cantidad);
		movimientos.add(m);
		this.saldo += cantidad;
	}
	
	public void reintegro(double cantidad) {
		Movimiento m = new Movimiento(new Date(), 'R', cantidad);
		movimientos.add(m);
		this.saldo -= cantidad;
	}

	public long getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void enRojo() {
		if(saldo<0) {
			System.err.println("El saldo se encuentra en números rojos");
		}
		else {
			System.out.println("El saldo no se encuentra en números rojos");
		}
	}

	public ArrayList<Movimiento> getMovimientos() {
		return movimientos;
	}
	
}
