package Bank;

public abstract class BankProduct {
	
	private String name;
	protected double annualRate;
	protected int period; //in months (1 to 60)
	protected double amount;
	
	
	public BankProduct(String name, double rate, int period, double value) {
		if(name != null && !name.isEmpty()) {
			this.name = name;
		}
		if (period > 0 && period <= 60) {
			this.period = period;
		}
		if (value > 0) {
			this.amount = value;
		}
		
		this.annualRate=rate;
		

	}

	public double calculateInterest () { //smqta lihvata za celiq srok na produkta
		return (this.amount*(this.annualRate/100))*(double)this.period/12; // sumata na produkta(dali depozit ili kredit) po lihvata v procent, umnojeno po broq meseci,deleno na 12
	} 
	
	public void printInfoForProduct() {
		System.out.println(this.name + " with " + this.annualRate  + "% annual rate, for  " + this.period + " months. " + "Amount " + this.amount );
	}
}
