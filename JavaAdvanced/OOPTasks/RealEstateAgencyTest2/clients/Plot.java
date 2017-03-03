package clients;

import clients.Estate.EstateType;

public class Plot extends Estate {
	
	public enum PlotType {NIVA, POLYANA, GORA}
	
	private PlotType plotType;
	private boolean inRegulation;
	
	
	public Plot(PlotType plotType, boolean inRegulation,String description, String address, int price, double size) {
		super(EstateType.PLOT, description, address, price, size);
		this.plotType = plotType;
		this.inRegulation = inRegulation;
	}
}
