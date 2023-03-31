package tareasperiodicas;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TPReloj extends TareaPeriodica {

	public TPReloj() {
		super();
	}
	
	public String leerHora() {
		Calendar cal = new GregorianCalendar();
		return cal.get(Calendar.HOUR_OF_DAY) + ":" + cal.get(Calendar.MINUTE) + ":" + cal.get(Calendar.SECOND);
	}
	
}
