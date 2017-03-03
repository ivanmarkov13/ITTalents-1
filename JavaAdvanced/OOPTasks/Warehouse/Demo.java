package wareHouse;

import java.util.Random;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Supplier supplier = new Supplier();
		Warehouse warehouse = new Warehouse(supplier);

		Store store1 = new Store(warehouse);
		Store store2 = new Store(warehouse);
		Store store3 = new Store(warehouse);
		
		Customer c1 = new Customer(store1);
		Customer c2 = new Customer(store1);
		Customer c3 = new Customer(store1);
		Customer c4 = new Customer(store2);
		Customer c5 = new Customer(store2);
		Customer c6 = new Customer(store2);
		Customer c7 = new Customer(store3);
		Customer c8 = new Customer(store3);
		Customer c9 = new Customer(store3);
		
		Customer [] customers = {c1, c2, c3, c4, c5, c6, c7, c8, c9};
		
		for (int i = 0; i < 60; i+=5) {
			for (int j = 0; j < customers.length; j++) {
				System.out.println("Customer ¹" + (j+1));
			customers[j].buyProduct();
			}
			
			
		}

	}

}
