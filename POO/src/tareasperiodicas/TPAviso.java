package tareasperiodicas;

public class TPAviso extends TareaPeriodica {
	
	private String msg;
	
	public TPAviso(String msg, int periodoSegs) {
		super(periodoSegs);
		this.msg=msg;
	}
	
	public String leerMsg() {
		return msg;
	}

}
