

public class Employee {
	
	private final String name;
	private Task currentTask;
	private double hoursLeft;
	public static AllWork allWork; // полето е статик, защото е общо за всички служители
	
	
	public Employee (String name) {
		if (name != null && !name.isEmpty()) {
			this.name = name;
		}
		else {
			this.name = "Employee";
		}
	}

	public Task getCurrentTask() {
		return this.currentTask;
	}

	public void setCurrentTask(Task currentTask) {
		if (currentTask != null ) {
			this.currentTask = currentTask;
		}
	}
	
	public double getHoursLeft() {
		return hoursLeft;
	}

	public void setHoursLeft(double hoursLeft) {
		if (hoursLeft >= 0) {
			this.hoursLeft = hoursLeft;
		}
	}

	public String getName() {
		return name;
	}
	
	public void workDuringTheDay () { // това е метод, който описва работния процес на служителя през целия ден 
		if (this.getCurrentTask().getWorkingHours() != 0) { // ако има още работа по текущата задача от предния ден, когато започне новият,
			this.showReport(); // изписва репорт 
			this.work(); // и кара служителя да работи по текущата задача
			this.showReport(); // тук отново се изписва репорт, за да се види колко часа остават по текущата задача и колко часа има от работния ден
		}
		if (this.getCurrentTask().getWorkingHours() == 0 && !Employee.allWork.allTasksTaken()) { // ако текущата задача е направена и все още има незаети задачи,
			this.setCurrentTask(Employee.allWork.getNextTask()); // служителят получава нова задача
			this.showReport(); // показва каква е новата му задача, както и дали има още часове за днес
			if (this.getHoursLeft() != 0) { // ако има още часове от работния ден,
				this.work(); // //служителят работи още по новата задача
				this.showReport(); // отново показва информация за оставащото време по текущата задача
			}
		}
	}
			
		public void work () { // това е метод, който интерпретира какво точно се случва, когато служител работи по конкретна задача
			System.out.println(this.getName() + " is working...");
			if (this.hoursLeft > currentTask.getWorkingHours()) { // ако часовете на служителя са повече от часовете за текущата задача,
				this.hoursLeft -= currentTask.getWorkingHours(); // пресмятаме колко часа остават на служителя, след като свърши задачата
				currentTask.setWorkingHours(0); // зануляваме времето на задачата
			}
			else 
				if (this.hoursLeft < currentTask.getWorkingHours()) { // ако часовете на служителя са по-малко, 
					currentTask.setWorkingHours(currentTask.getWorkingHours()-this.hoursLeft); // пресмятаме колко часа остават по задачата, след като свърши работният ден
					this.setHoursLeft(0); // зануляваме работния ден
				} 
				else { // ако часовете за работа по задачата и часовете на служителя са равни,
					this.setHoursLeft(0); // зануляваме работния ден
					currentTask.setWorkingHours(0); // зануляваме времето на задачата
				}
	}
	
	public void startWorkingDay () {
		setHoursLeft(8);
	}

	public void showReport () {
		if (this.currentTask.getWorkingHours() == 0 && this.getHoursLeft() != 0 ) { // ако задачата е изпълнена, но има още време до края на работния ден
			System.out.println("Employee name: " + this.getName()); 
			System.out.println("Employee's current task: " + this.currentTask.getName());
			System.out.println( this.getCurrentTask().toString() + " is completed and " + this.getName() + " has " + this.getHoursLeft() + " working hours left.");
				if (!allWork.allTasksTaken()) {
					System.out.println(this.getName() + " is getting another task. "); // информираме, че даваме нова задача на служителя, ако все още има останали незаети
				} 
				else {
					System.out.println("All tasks are taken so " + this.getName() + " has nothing to do!"); //
				}
			}
		else 
			if (this.getHoursLeft() == 0 && this.currentTask.getWorkingHours() != 0) { // ако задачата не е завършена, но работният ден е приключил
				System.out.println("Employee name: " + this.getName()); 
				System.out.println("Employee's current task: " + this.currentTask.getName());
				System.out.println(this.getName() + " does not have any more work hours for today. The employee has " + this.currentTask.getWorkingHours() + " hours left on the current task.");
			}
			else 
			if (this.getHoursLeft() == 0 && this.currentTask.getWorkingHours() == 0) { // ако задачата е завършена и работния ден е приключил
				System.out.println("Employee name: " + this.getName()); 
				System.out.println("Employee's current task: " + this.currentTask.getName());
				System.out.println(this.getName() + " has completed  " + currentTask.toString() +  " and the work day is over.");
			}
			else {
				System.out.println("Employee name: " + this.getName()); // дефоултно условие, което дава информация, когато започва работният ден и има незавършена задача или когато подадем нова задача 
				System.out.println("Employee's current task: " + this.currentTask.getName());
				System.out.println("Employee's working hours left: " + this.getHoursLeft());
				System.out.println("Employee's hours left on current task: " + this.currentTask.getWorkingHours());
			}
	}
	
	

}



