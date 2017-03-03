package Citizens;

public abstract class Citizen {
	protected String name;
	private String address;
	private int age;
	protected String role;
	
	
	public Citizen(String name,String role) {
		this.name = name;
		this.role = role;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void printInfo() {
		System.out.print(this.role+ " - " + this.name);
	}
	
	

}
