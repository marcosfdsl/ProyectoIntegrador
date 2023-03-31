package tareasperiodicas;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TareaPeriodica {
	
	private int periodoSegs;
	private Date ultimaEj;
	private boolean activa;
	
	public TareaPeriodica(int periodoSegs) {
		this.periodoSegs=periodoSegs;
		this.activa=true;
		actualizarReloj();
	}
	
	public TareaPeriodica() {
		this(1);
	}
	
	public void actualizarReloj() {
		ultimaEj = new Date();
	}
	
	public boolean necesitaEjecucion() {
		if(!activa) {
			return false;
		}
		Calendar calProximaEjec=new GregorianCalendar();
		calProximaEjec.setTime(ultimaEj);
		calProximaEjec.add(Calendar.SECOND, periodoSegs);
		Calendar calAhora=new GregorianCalendar();
		return(calProximaEjec.before(calAhora));
 	}
	
	public void ejecutarTarea() {
		for (int i=0; i<10000; i++) {
			System.out.println("Ejecución de tarea genérica!!!");
		}
	}
	
	public void activar() {
		activa=true;
	}
	
	public void desactivar() {
		activa=false;
	}

}
