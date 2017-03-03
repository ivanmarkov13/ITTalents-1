package Bank;

public class Customer {
	
	private String name;
	private String address;
	private double cash;
	private double salary;
	private Credit [] credits = new Credit [5];
	private Deposit [] deposits = new Deposit [10];
	private int currentDeposit=0; //broqch, koito shte izpolzwam kato indeks pri dovawqne na depozit
	private int currentCredit=0; //analogichno s kredit
	private Bank myBank;
	
	public Customer( String name, double cash, double salary, Bank myBank) {
		if (name!=null && !name.isEmpty()) {
			this.name = name;
		}
		if (cash>0) {
			this.cash = cash;
		}
		if (salary > 0) {
			this.salary = salary;
		}
		this.myBank = myBank;
	}
	
	public String getName() {
		return this.name;
	}
	public double getCash() {
		return this.cash;
	}
	public double getSalary() {
		return salary;
	}

	public void openDeposit (boolean shortDeposit, double amount) { //metod za otvarqne na depozit, koito priema buleva promenliva, za da se znae kakuv depozit se otvarq i amount of deposit
		if(this.cash >= amount) { //ako klienta ima parite, pravi depozit
			Deposit deposit;
			if (shortDeposit) { //v zivisimost ot tova, syzdavame short ili long deposit s podadenata suma
				deposit = new ShortDeposit(amount);
			}
			else {
				deposit = new LongDeposit (amount);
			}
			this.cash -= amount; // vadim ot nalichnite pari razmera na depozita
			deposits[currentDeposit++] = deposit; // dobavqme deposita w masiva s depoziti na klienta
			myBank.takeDeposit(deposit); // bankata priema depozita
			
		}
	}
	
	public void askForCredit (Credit credit) { // zaqvqvame, che iskame kredit
		this.myBank.giveCredit(this, credit);  // izvikva se metoda na bankata za davane na kredit, koito prai proverki
	}

	
	
	public void getNewCredit (Credit credit, double realAmount) { // poluchavame nov kredit, no stoinostta mu e veche uvelichena s razmera na lihvata, zatova ima i parametur za realna poluchavana stoiost na kredita
		this.cash += realAmount; // dobavqme realnata suma kym nalichnite pari
		this.credits[currentCredit++] = credit; //  slagame kredita (sus stoinostta, koqto shte vrushtame) v masiva s krediti na klienta
	}
	
	public void payMoneyForCredit (Credit credit) { //pogasqvane na vnoski po kredit, priema kato parametur po koi kredit shte vnasqme i kakwa suma
		if ( credit.monthInstallment < this.cash) { // ako razpolagame s tazi suma i tq e polojitena
			credit.amount -= credit.monthInstallment; // vadim q ot razmera na kredita
			this.cash -= credit.monthInstallment; // i ot nalichnite pari
		}
		
	}
	
	public void printInfoForCustomer() {
		System.out.println("Customer " + this.name);
		System.out.println("Cash: " + this.cash);
		System.out.println("Salary: " + this.salary);
		System.out.println("Credits: ");
		for (int i = 0; i < credits.length; i++) {
			if(credits[i] != null) {
			credits[i].printInfoForProduct();
			}
		}
		System.out.println("Deposits: ");
		for (int i = 0; i < deposits.length; i++) {
			if (deposits[i] != null) {
				deposits[i].printInfoForProduct();
			}
		}
	}
		
		public double calculateSumForMonthInstallments () { //smqta mesechnata suma za vnoski po vsichki krediti
			double sumForMonthInstallments = 0;
			for (int i = 0; i < credits.length; i++) {
				if (credits[i] != null ) { //ako ima kredit
					sumForMonthInstallments += credits[i].monthInstallment; //tazi suma se uvelichava s razmera na mesechnata mu vnoska po suotvetniq kredits
				}
			}
			return sumForMonthInstallments;
		}

		public Credit[] getCredits() {
			return credits;
		}

		

		public Deposit[] getDeposits() {
			return deposits;
		}
}

	


