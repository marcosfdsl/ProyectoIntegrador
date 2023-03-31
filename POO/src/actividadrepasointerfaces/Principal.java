package actividadrepasointerfaces;

import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		
		Libro l1 = new Libro("Geronimo Stilton", 2005);
		Libro l2 = new Libro("Boom", 2007);
		Libro l3 = new Libro("Una Vez", 2008);
		
		Revista r1 = new Revista("Forbes", 2009, 21);
		Revista r2 = new Revista("Times", 2011, 49);
		Revista r3 = new Revista("FleekMag", 2014, 16);
		
		ArrayList<Publicacion> arr = new ArrayList<>();
		
		arr.add(l1);
		arr.add(l2);
		arr.add(l3);
		arr.add(r1);
		arr.add(r2);
		arr.add(r3);
		
		arr.get(0).prestar();
		arr.get(1).prestar();
		arr.get(3).prestar();
		
		System.out.println();
		
		for (int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i).toString());
		}
		
		System.out.println();
		
		arr.get(0).devolver();
		arr.get(3).devolver();
		
		System.out.println();
		
		for (int i=0; i<arr.size(); i++) {
			System.out.println(arr.get(i).toString());
		}

	}

}
