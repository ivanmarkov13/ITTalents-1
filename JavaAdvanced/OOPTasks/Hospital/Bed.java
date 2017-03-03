package hospital;

public class Bed {
	
	private boolean isEmpty;
	
	public Bed() {
		this.isEmpty = true;
	}
	
	public boolean getIsEmpty () {
		return this.isEmpty;
	}
	public void setEmpty(boolean b) {
		this.isEmpty=b;
		
	}
}
