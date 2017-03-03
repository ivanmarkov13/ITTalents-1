
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		Employee [] employees = new Employee [5];
		employees[0] = new Employee("Petyr");
		employees[1] = new Employee("Georgi");
		employees[2] = new Employee("Ivan");
		employees[3] = new Employee("Dragan");
		employees[4] = new Employee("Petkan");
		
		Employee.allWork = new AllWork (12);
		Employee.allWork.addTask(new OrganizationTask("Task one", 7));
		Employee.allWork.addTask(new SimpleTask("Task two", 4));
		Employee.allWork.addTask(new MaintenanceTask("Task three", 12));
		Employee.allWork.addTask(new MaintenanceTask("Task four", 16));
		Employee.allWork.addTask(new MaintenanceTask("Task five", 11));
		Employee.allWork.addTask(new OrganizationTask("Task six", 9));
		Employee.allWork.addTask(new OrganizationTask("Task seven", 9));
		Employee.allWork.addTask(new MaintenanceTask("Task eight", 15));
		Employee.allWork.addTask(new OrganizationTask("Task nine", 9));
		Employee.allWork.addTask(new SimpleTask("Task ten", 6));
		Employee.allWork.addTask(new SimpleTask("Task eleven ", 3));
		Employee.allWork.addTask(new SimpleTask("Task twelve", 1));
			
		for (int i = 0; i < employees.length; i++) {
			employees[i].setCurrentTask(Employee.allWork.getNextTask()); // задача задача на всеки служител
		}
		
		int counter=0; // брояч за дните
		while (true) {
			if (Employee.allWork.isAllWorkDone()) { // когато всички задачи са приключили, приключва и цикълът 
				System.out.println("All tasks are completed for " + counter + " days!");
				break;
			}
			System.out.println("Day " + ++counter);
			for (int i = 0; i < employees.length; i++) { // за всеки служител
				employees[i].startWorkingDay(); // започва нов ден
				employees[i].workDuringTheDay(); // всеки служител работи през деня (довършва текуща задача/взима нова задача)
				System.out.println("*********************");
			}
			System.out.println("---------------------");	
		}
		
			
	}
		
}


