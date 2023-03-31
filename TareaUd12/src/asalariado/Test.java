package asalariado;

public class Test {

	public static void main(String[] args) {
		
		// CREACIÓN OBJETOS/EMPLEADOS

		EmpleadoProduccion empProd = new EmpleadoProduccion("Pepe", 1234567890L, 22, "mañana");
		EmpleadoDistribucion empDis = new EmpleadoDistribucion("Paco", 9876543210L, 21, "norte");
		
		// MÉTODOS PROPIOS Y DERIVADOS EMPLEADOPRODUCCIÓN
		
		empProd.setNombre("José");
		empProd.setTurno("tarde");
		
		// MÉTODOS PROPIOS Y DERIVADOS EMPLEADODISTRIBUCIÓN
		
		empDis.setNombre("Francisco");
		empDis.setZona("sur");

		// TOSTRING
		
		System.out.println(empProd.toString());
		System.out.println(empDis.toString());
		
	}

}
