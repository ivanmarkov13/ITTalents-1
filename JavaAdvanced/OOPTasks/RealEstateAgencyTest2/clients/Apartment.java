package clients;

import clients.Estate.EstateType;

public class Apartment extends Estate {
	
	
	public enum ApartmentType { STUDIO, GARSIONERA, TWO_ROOM, THREE_ROOM, MEZONET}
	public enum ConstructionType {EPK, TUHLA, PANEL, KIRPICH}
	
	private EstateType estateType;
	private ApartmentType type;
	private ConstructionType construtionType;
	
	
	public Apartment(ApartmentType type, ConstructionType cType, String description, String address, int price, double size) {
		super(EstateType.APARTMENT, description, address, price, size);
		this.type = type;
		this.construtionType = cType;
		
	}

}
