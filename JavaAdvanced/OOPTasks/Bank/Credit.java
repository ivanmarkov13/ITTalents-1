package Bank;

public abstract class Credit extends BankProduct {
	
	double monthInstallment;

	public Credit(String name,double rate, int period, double value) {
		super(name,rate,period,value);
	}
	
	

	public double calculateInstallment() { // smqta mesechnata vnoska po kredita
		monthInstallment =  this.amount/this.period; //tq e ravna na sumata na kredita(koqto wkliuchva lihvata za perioda),razdelena na broq meseci
		return monthInstallment;
	}
	
	

	public void printInfoForProduct() {
		super.printInfoForProduct();
		System.out.println("Month installment: " + this.calculateInstallment());
	}

}
