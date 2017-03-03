

public class Employee {
	
	private final String name;
	private Task currentTask;
	private double hoursLeft;
	public static AllWork allWork; // ������ � ������, ������ � ���� �� ������ ���������
	
	
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
	
	public void workDuringTheDay () { // ���� � �����, ����� ������ �������� ������ �� ��������� ���� ����� ��� 
		if (this.getCurrentTask().getWorkingHours() != 0) { // ��� ��� ��� ������ �� �������� ������ �� ������� ���, ������ ������� ������,
			this.showReport(); // ������� ������ 
			this.work(); // � ���� ��������� �� ������ �� �������� ������
			this.showReport(); // ��� ������ �� ������� ������, �� �� �� ���� ����� ���� ������� �� �������� ������ � ����� ���� ��� �� �������� ���
		}
		if (this.getCurrentTask().getWorkingHours() == 0 && !Employee.allWork.allTasksTaken()) { // ��� �������� ������ � ��������� � ��� ��� ��� ������� ������,
			this.setCurrentTask(Employee.allWork.getNextTask()); // ���������� �������� ���� ������
			this.showReport(); // ������� ����� � ������ �� ������, ����� � ���� ��� ��� ������ �� ����
			if (this.getHoursLeft() != 0) { // ��� ��� ��� ������ �� �������� ���,
				this.work(); // //���������� ������ ��� �� ������ ������
				this.showReport(); // ������ ������� ���������� �� ���������� ����� �� �������� ������
			}
		}
	}
			
		public void work () { // ���� � �����, ����� ������������ ����� ����� �� ������, ������ �������� ������ �� ��������� ������
			System.out.println(this.getName() + " is working...");
			if (this.hoursLeft > currentTask.getWorkingHours()) { // ��� �������� �� ��������� �� ������ �� �������� �� �������� ������,
				this.hoursLeft -= currentTask.getWorkingHours(); // ���������� ����� ���� ������� �� ���������, ���� ���� ������ ��������
				currentTask.setWorkingHours(0); // ���������� ������� �� ��������
			}
			else 
				if (this.hoursLeft < currentTask.getWorkingHours()) { // ��� �������� �� ��������� �� ��-�����, 
					currentTask.setWorkingHours(currentTask.getWorkingHours()-this.hoursLeft); // ���������� ����� ���� ������� �� ��������, ���� ���� ������ ��������� ���
					this.setHoursLeft(0); // ���������� �������� ���
				} 
				else { // ��� �������� �� ������ �� �������� � �������� �� ��������� �� �����,
					this.setHoursLeft(0); // ���������� �������� ���
					currentTask.setWorkingHours(0); // ���������� ������� �� ��������
				}
	}
	
	public void startWorkingDay () {
		setHoursLeft(8);
	}

	public void showReport () {
		if (this.currentTask.getWorkingHours() == 0 && this.getHoursLeft() != 0 ) { // ��� �������� � ���������, �� ��� ��� ����� �� ���� �� �������� ���
			System.out.println("Employee name: " + this.getName()); 
			System.out.println("Employee's current task: " + this.currentTask.getName());
			System.out.println( this.getCurrentTask().toString() + " is completed and " + this.getName() + " has " + this.getHoursLeft() + " working hours left.");
				if (!allWork.allTasksTaken()) {
					System.out.println(this.getName() + " is getting another task. "); // �����������, �� ������ ���� ������ �� ���������, ��� ��� ��� ��� �������� �������
				} 
				else {
					System.out.println("All tasks are taken so " + this.getName() + " has nothing to do!"); //
				}
			}
		else 
			if (this.getHoursLeft() == 0 && this.currentTask.getWorkingHours() != 0) { // ��� �������� �� � ���������, �� ��������� ��� � ���������
				System.out.println("Employee name: " + this.getName()); 
				System.out.println("Employee's current task: " + this.currentTask.getName());
				System.out.println(this.getName() + " does not have any more work hours for today. The employee has " + this.currentTask.getWorkingHours() + " hours left on the current task.");
			}
			else 
			if (this.getHoursLeft() == 0 && this.currentTask.getWorkingHours() == 0) { // ��� �������� � ��������� � �������� ��� � ���������
				System.out.println("Employee name: " + this.getName()); 
				System.out.println("Employee's current task: " + this.currentTask.getName());
				System.out.println(this.getName() + " has completed  " + currentTask.toString() +  " and the work day is over.");
			}
			else {
				System.out.println("Employee name: " + this.getName()); // ��������� �������, ����� ���� ����������, ������ ������� ��������� ��� � ��� ����������� ������ ��� ������ ������� ���� ������ 
				System.out.println("Employee's current task: " + this.currentTask.getName());
				System.out.println("Employee's working hours left: " + this.getHoursLeft());
				System.out.println("Employee's hours left on current task: " + this.currentTask.getWorkingHours());
			}
	}
	
	

}



