package actividadrepasointerfaces;

public class Publicacion implements Prestable {
	
	static int numero = 0;

	private int codigo;
	private String titulo;
	private int año;
	private boolean prestado;
	
	public Publicacion(String titulo, int año) {
		codigo = generarCodigo();
		this.titulo = titulo;
		this.año = año;
		this.prestado = false;
	}

	@Override
	public void prestar() {
		if (prestado==true) {
			System.out.println("La publicación " + titulo + " ya está prestado.");
		}
		else {
			prestado = true;
			System.out.println("La publicación " + titulo + " se ha prestado.");
		}
	}

	@Override
	public void devolver() {
		if (prestado==false) {
			System.out.println("La publicación " + titulo + " no estaba prestado.");
		}
		else {
			prestado = false;
			System.out.println("La publicación " + titulo + " se ha devuelto.");
		}
	}

	@Override
	public void prestado() {
		if (prestado==true) {
			System.out.println("La publicación " + titulo + " está prestado.");
		}
		else {
			System.out.println("La publicación " + titulo + " no está prestado.");
		}
	}
	
	public int generarCodigo() {
		numero+=1;
		codigo=numero;
		return codigo;
	}

	@Override
	public String toString() {
		return "Código: " + codigo + " | Título: " + titulo + " | Año: " + año + " | Prestado: " + prestado;
	}
	
}
