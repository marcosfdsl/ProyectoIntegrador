package unidad11;

public class Cantante {
	
	private String nombre;
	private String apellidos;
	private int edad;
	private String nombreArtistico;
	private Estilo estilo;
	private int numeroDiscos;
	private Disco disco;
	
	Cantante(String nombre, String apellidos, int edad, String nombreArtistico, Estilo estilo, int numeroDiscos, Disco disco) {
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.edad=edad;
		this.nombreArtistico=nombreArtistico;
		this.estilo=estilo;
		this.numeroDiscos=numeroDiscos;
		this.disco=disco;
	}
	
	Cantante(String nombreArtistico, Estilo estilo) {
		this.nombreArtistico=nombreArtistico;
		this.estilo=estilo;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombreArtistico() {
		return nombreArtistico;
	}

	public void setNombreArtistico(String nombreArtistico) {
		this.nombreArtistico = nombreArtistico;
	}

	public Estilo getEstilo() {
		return estilo;
	}

	public void setEstilo(Estilo estilo) {
		this.estilo = estilo;
	}

	public int getNumeroDiscos() {
		return numeroDiscos;
	}

	public void setNumeroDiscos(int numeroDiscos) {
		this.numeroDiscos = numeroDiscos;
	}
	
	public Disco getDisco() {
		return disco;
	}

	public void setDisco(Disco disco) {
		this.disco = disco;
	}

	@Override
	public String toString() {
		return "Cantante [nombre=" + nombre + ", apellidos=" + apellidos + ", edad=" + edad + ", nombreArtistico="
				+ nombreArtistico + ", estilo=" + estilo + ", numeroDiscos=" + numeroDiscos + "]";
	}

}
