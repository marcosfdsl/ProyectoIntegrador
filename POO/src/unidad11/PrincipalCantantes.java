package unidad11;

public class PrincipalCantantes {

	public static void main(String[] args) {
		
		Disco d1 = new Disco ("Big Fish", 2022, 10.0, 12);
		Disco d2 = new Disco ("Heroine", 2019, 6.99, 7);

		Cantante c1 = new Cantante ("Marcos", "Fernández de Salamanca López", 21, "Sofos", Estilo.RAP, 2, d1);
		Cantante c2 = new Cantante ("Col3trane", Estilo.POP);
		
		Cancion s1 = new Cancion("Big Fish", "3:45");
		Cancion s2 = new Cancion("Suerte", "2:27");
		Cancion s3 = new Cancion("Conflicto", "3:09");
		
		c1.getDisco().anyadirCanciones(s1);
		c1.getDisco().anyadirCanciones(s2);
		c1.getDisco().anyadirCanciones(s3);
		
		System.out.println("El cantante " + c1.getNombreArtistico() + " tiene el disco " + c1.getDisco().getNombre() + ", que está formado por " + c1.getDisco().getNumCanciones() + " canciones\n");
		c1.getDisco().imprimirCanciones();

	}

}
