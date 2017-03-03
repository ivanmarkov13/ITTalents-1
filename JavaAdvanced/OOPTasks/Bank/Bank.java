package Bank;

public class Bank {
	
	private  String name;
	private String address;
	private BankProduct [] products = new BankProduct[100];
	private double moneyOnHand;
	private double bankReserve;
	private int currentProduct=0;
	private Customer[] customers = new Customer[25];
	private int currentCustomers;
	
	public Bank(String name, String address,  double moneyOnHand) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
		if (address != null && !address.isEmpty()) {
			this.address = address;
		}
		if (moneyOnHand > 0) {
			this.moneyOnHand = moneyOnHand; 
			bankReserve = 0;
		}
		
	}
	
	public Customer[] getCustomers() {
		return this.customers;
	}
	
	public void addCustomer(Customer c) {
		if (currentCustomers < customers.length) {
			customers[currentCustomers++] = c;
		}
	}
	
	public void takeDeposit (Deposit deposit) { //priemane na depozit
		if (deposit.amount > 0) { // ako razmera na depozita e po-golqm ot nula
			products[currentProduct++] = deposit; //dobavqme depozita w masiva ot produkti
			this.moneyOnHand+=deposit.amount; // uvelichavame nalichnite pari
			this.bankReserve += 0.1*deposit.amount; // uvelichavame rezerva s 10% ot stojnostta na depozita
		}
	}
	
	
	public void payInterestOnDeposit () { // plashtane na lihvi po depoziti
		for (int i = 0; i < products.length; i++) { 
			if (products[i] instanceof Deposit) { //ako w masiva ot produkti imame depozit
				products[i].amount += products[i].calculateInterest(); //uvelichavame razmera my
				this.moneyOnHand-=products[i].calculateInterest(); //namalqvame nalichnite pari na bankata
				this.bankReserve += 0.1*products[i].calculateInterest(); //suotvetno rezervut trqbva da se uvelichi
			}
		}
	}
	public void giveCredit(Customer customer, Credit credit) { //poneje metodut za smqtane na mesechna vnoska raboti direktno s podaden kredit, koito vkliuchva v stoinostta si i stoinostta na lihvata, 
		Credit creditWithInterest= credit; //pravq dopulnitelna promenliva ot tip credit(koito vkliuchva i lihvata si), chrez koqto da proverq dali 
		creditWithInterest.amount = credit.amount+credit.calculateInterest(); //mesechnata wnoska po iskaniq kredit + mesechnite wnoski po nalichnite krediti na klienta(ako ima takiva) ne nadvishavat polovinata ot zaplatata mu
		if ((creditWithInterest.calculateInstallment() + customer.calculateSumForMonthInstallments()) <= 0.5*customer.getSalary() && this.moneyOnHand-credit.amount>this.bankReserve) { // sushto taka proverqvam i dali sled prispadane na sumata na kredita ot nalichnite si pari, bankata shte razpolaga sus zaduljitelni rezerv ot 10% 	
			this.moneyOnHand-=credit.amount; //vadim sumata na kredita ot nalichnite pari na bankata
			System.out.print(customer.getName() + " is getting a credit for  " + credit.amount + ". ");
			System.out.println("The interest for the period is " + credit.calculateInterest());
			double creditRealAmount= credit.amount; // promenliva, koqto da podadem na klienta,za da vidim realno kolko pari poluchava ot kredita, zashtoto na sledvashtiq red promenqm sumata na kredita
			credit.amount+=credit.calculateInterest(); //poneje sumata ot kredita, koqto realno shte poluchi bankata shte e ravna na razmera na kredita + lihvata za celiq period, trqbva predi da dobavim kredita kum masiva s produkti na bankata da dobavim sumata na lihvata kym stoinostta mu
			products[currentProduct++] = credit; //dobavqme kredita w masiva na bankata
			customer.getNewCredit(credit,creditRealAmount); //klienta poluchava kredita(realnata suma na kredita+lihvata)
			credit.printInfoForProduct(); //printim kakuv kredit poluchava klienta
			
		} else {
			System.out.print(customer.getName() + " cannot get the credit - ");
			credit.printInfoForProduct();
		}
	}
	
	public void printInfoForBank () {
		System.out.println("The bank money on hand is: " + moneyOnHand);
		System.out.println("The bank reserve is: " + bankReserve);
		
	}
	public void printInforForBankCustomers() {
		for (int i = 0; i < customers.length; i++) {
			if (customers[i] != null) {
				customers[i].printInfoForCustomer();
				System.out.println("***********************");
				}
			}
		
	}
	
	
	

}
