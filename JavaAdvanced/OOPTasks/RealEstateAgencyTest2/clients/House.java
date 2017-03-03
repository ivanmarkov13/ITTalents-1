package clients;

import clients.Apartment.ConstructionType;

public class House extends Estate {
	
	
	public enum HouseType {FLOOR, WHOLE_HOUSE}
	
	private ConstructionType constructionType;
	private HouseType houseType;
	
	public House(HouseType houseType, ConstructionType cType,String description, String address, int price, double size) {
		super(EstateType.HOUSE, description, address, price, size);
		this.houseType = houseType;
		this.constructionType = cType;
	}

}
