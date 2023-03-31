package casopractico;

import java.util.*;

public class Carrito {
	
	private ArrayList<Producto> productosCarrito;
	
	public Carrito() {
		this.productosCarrito = new ArrayList<>();
	}

	public ArrayList<Producto> productosCarrito() {
		return productosCarrito;
	}
	
	public Producto productoConcretoCarrito(Producto producto) {
		return productosCarrito.get(productosCarrito.indexOf(producto));
	}

	public void añadirProducto(String producto, Supermercado supermercado) {	
		int contador = 0;
		
		for (int i=0; i<supermercado.productosDisponibles().size(); i++) {
			
			if (producto.equalsIgnoreCase(supermercado.productosDisponibles().get(i).getNombre())) {
				productosCarrito.add(supermercado.productosDisponibles().get(i));
				System.out.println("El producto " + producto.toLowerCase() + " fue añadido.");
			}
			else {
				contador+=1;
			}
		}
		if (contador==supermercado.productosDisponibles().size()) {
			System.out.println("El producto " + producto.toLowerCase() + " no se encuentra disponible.");
		}
	}
	
	public void eliminarProducto(String producto) {
		int contador = 0;
		
		for (int i=0; i<productosCarrito().size(); i++) {
			
			if (producto.equalsIgnoreCase(productosCarrito.get(i).getNombre())) {
				productosCarrito.remove(productosCarrito().get(i));
				System.out.println("El producto " + producto.toLowerCase() + " fue eliminado del carrito.");
				contador-=1;
			}
			else {
				contador+=1;
			}
			
		}
		if (contador==productosCarrito().size()) {
			System.out.println("El producto " + producto.toLowerCase() + " no se encuentra en el carrito.");
		}
	}
	
	public void comprobarProducto(String producto) {
		int contador = 0;
		
		for (int i=0; i<productosCarrito().size(); i++) {
			
			if (producto.equalsIgnoreCase(productosCarrito.get(i).getNombre())) {
				System.out.println("El producto " + producto.toLowerCase() + " se encuentra en el carrito y vale " 
				+ productosCarrito.get(i).getPrecio() + "€.");
				contador-=1;
			}
			else {
				contador+=1;
			}
			
		}
		if (contador==productosCarrito().size()) {
			System.out.println("El producto " + producto.toLowerCase() + " no se encuentra en el carrito.");
		}
	}
	
	public String total() {
		int suma = 0;
		for (int i=0; i<productosCarrito.size(); i++) {
			suma+=productosCarrito.get(i).getPrecio();
		}
		String total = "El total a pagar es de " + suma + "€.";
		return total;
	}

	@Override
	public String toString() {
		
		Collections.sort(productosCarrito, new Comparator<Producto>(){
			public int compare(Producto p1, Producto p2) {
			     return (p1.getNombre()).compareTo(p2.getNombre());
			}
		});
		
		if (productosCarrito.isEmpty()) {
			return "El carrito está vacío.";
		}
		else {
			return "El carrito contiene los siguientes productos: " + productosCarrito;
		}
		
	}

}
