package actividadrepasointerfaces;

public class Revista extends Publicacion {
	
	private int numero;

	public Revista(String titulo, int año, int numero) {
		super(titulo, año);
		this.numero = numero;
	}

	@Override
	public String toString() {
		return super.toString() + " | Número Revista: " + numero;
	}

}
