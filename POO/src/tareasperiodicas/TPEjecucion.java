package tareasperiodicas;

public class TPEjecucion extends TareaPeriodica {
	
	private String cmd;
	
	public TPEjecucion(String cmd, int periodoSegs) {
		super(periodoSegs);
		this.cmd=cmd;
	}
	
	public String leerCmd() {
		return cmd;
	}

}
