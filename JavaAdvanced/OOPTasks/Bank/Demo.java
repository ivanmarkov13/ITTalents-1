package Bank;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(9.0/12);
		
		Bank unicredit = new Bank("Unicredit Bulbank", "Sofia",	1000000);
		Customer pesho = new Customer("Petur Petrov", 1000, 8000, unicredit);
		Customer gosho = new Customer("Georgi Georgiev", 200, 600, unicredit);
		Customer ivan = new Customer("Ivan Ivanov", 800, 2000, unicredit);
		Customer martin = new Customer("Martin Marinov", 100, 450, unicredit);
		Customer dragan = new Customer("Drago Draganov", 50, 900, unicredit);
		Customer petkan = new Customer("Petkan Petkanov", 1000, 1300, unicredit);
		Customer mitko = new Customer("Dimitur Dimitrov", 600, 800, unicredit);
		Customer ivo = new Customer("Ivo Ivov", 450, 1248, unicredit);
		Customer vesko = new Customer("Veselin Veselinov", 690, 940, unicredit);
		Customer vladi = new Customer("Vladimir Vladimirov", 340, 900, unicredit);
		
		unicredit.addCustomer(pesho);
		unicredit.addCustomer(gosho);
		unicredit.addCustomer(ivan);
		unicredit.addCustomer(martin);
		unicredit.addCustomer(dragan);
		unicredit.addCustomer(petkan);
		unicredit.addCustomer(mitko);
		unicredit.addCustomer(ivo);
		unicredit.addCustomer(vesko);
		unicredit.addCustomer(vladi);
		
		Random r = new Random();
		pesho.openDeposit( true, ((r.nextInt(20) + 80)/100.0)*pesho.getCash());
		gosho.openDeposit(false, ((new Random().nextInt(20)+80)/100.0)*gosho.getCash());
		ivan.openDeposit(false, ((new Random().nextInt(20)+80)/100.0)*ivan.getCash());
		martin.openDeposit(false, ((new Random().nextInt(20)+80)/100.0)*martin.getCash());
		dragan.openDeposit(false, ((new Random().nextInt(20)+80)/100.0)*dragan.getCash());
		petkan.openDeposit(false, ((new Random().nextInt(20)+80)/100.0)*petkan.getCash());
		mitko.openDeposit(false, ((new Random().nextInt(20)+80)/100.0)*mitko.getCash());
		ivo.openDeposit(false, ((new Random().nextInt(20)+80)/100.0)*ivo.getCash());
		vesko.openDeposit(false, ((new Random().nextInt(20)+80)/100.0)*vesko.getCash());
		vladi.openDeposit(false, ((new Random().nextInt(20)+80)/100.0)*vladi.getCash());
		
		unicredit.printInfoForBank();
		
		
		for (int i = 0; i < unicredit.getCustomers().length; i++) {
			if (unicredit.getCustomers()[i] != null) {
				if (i%2 != 0) {
					HomeCredit homeCredit = new HomeCredit((new Random().nextInt(36)+24),(new Random().nextInt(50000)+50000));
					unicredit.getCustomers()[i].askForCredit(homeCredit);
				
			}
				else {
					ConsumerCredit consumerCredit = new ConsumerCredit(new Random().nextInt(36),new Random().nextInt(30000));
					unicredit.getCustomers()[i].askForCredit(consumerCredit);
				}
			}
		}
		unicredit.printInforForBankCustomers();
		
		unicredit.printInfoForBank();
		unicredit.payInterestOnDeposit();
		unicredit.printInfoForBank();
		
		System.out.println(pesho.getCredits()[0].amount);
		pesho.payMoneyForCredit(pesho.getCredits()[0]);
		System.out.println(pesho.getCredits()[0].amount);

		
		
		
		
	}

}
