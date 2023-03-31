package tareasperiodicas;

public class AppGestorTareas {

	public static void main(String[] args) {

		TareaPeriodica tp = new TareaPeriodica();
		
		TPAviso tpa = new TPAviso("Estudiar tema de herencia", 2);
		
		while(!tp.necesitaEjecucion()) {
			System.out.println("Esperando la ejecución de la tarea periódica...");
		}
		
		tp.ejecutarTarea();
		
		while(!tpa.necesitaEjecucion()) {
			System.out.println("Esperando ejecución de aviso...");
		}
		
		System.out.println("Aviso: " + tpa.leerMsg());

	}

}
