package aceptaelreto;

import java.util.*;

public class AceptaElReto {

	static Scanner sc;

	public static void main(String[] args) {

		sc = new Scanner(System.in);

		int desconocidos = sc.nextInt();
		ArrayList<String> al = new ArrayList<>();

		sc.nextLine();

		for (int i = 0; i < desconocidos; i++) {
			String p1 = sc.nextLine();
			al.add(p1.substring(4, p1.length()));
		}

		for (int i = 0; i < al.size(); i++) {
			System.out.println("Hola, " + al.get(i) + ".");
		}

		sc.close();

	}

}
