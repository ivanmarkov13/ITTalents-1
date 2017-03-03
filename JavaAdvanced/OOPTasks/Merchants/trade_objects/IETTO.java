package trade_objects;

import java.util.ArrayList;

public interface IETTO {
	public void addProducts(ArrayList<Product> products);
	public ArrayList<Product> getProducts();
	public abstract int getTax();



}
