
public class AllWork {
	
	private Task [] tasks;
	private int freePlacesForTasks;
	private int currentUnassignedTask;
	private int addedTasks=0;
	
	public AllWork(int index) { //������ �� ������ �� ���� ������ � ������
		tasks = new Task[index]; // �������������� ��� ����� ��� ������� ���� ������
		freePlacesForTasks=index; // ������� �������� ����� �� ������ ���
		currentUnassignedTask=0; // �������� �� ������� ������� ������ � 0
	}
	
	public void addTask (Task t) {
		if (freePlacesForTasks > 0) {
			tasks[addedTasks++] = t;
			freePlacesForTasks--;
		}
		
	}
	
	public Task getNextTask () {
		if (currentUnassignedTask < this.tasks.length) { //��� �������� �� �������� �������� ������ � ��-����� �� ��������� �� ������
			return tasks[currentUnassignedTask++]; //������� �������� �������� ������ � ����������� �������
		} else {
		return null; // � �������� ������ ����� ���, �� �� � ��� ��������, ������ 
		// ������ ���� �����, ����� ����������� ���� ��� ��� ������� ������ � � ������ work �� ����� �������� ����� ����� ������ �� ���� ������, ����
		// ���� ������� � �����, �.� ���� �� ����� ������, ����� � ���
		}
	}
	
	public boolean isAllWorkDone () {
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i].getWorkingHours() != 0) { // ��� �� ����� ������ ��� ��� ����� �� ������,
				return false; // ������� ����
			}
		}
		return true;
	}
	
	public boolean allTasksTaken() {
		if(currentUnassignedTask == tasks.length) { // ��������� ���� �������� �� �������� ������� ������ �� � ������ ����� �� ��������� �� ������
			return true; // ��� � - �������, �� ������ ������ �� �����
		}
		return false;
	}

	public int getFreePlacesForTasks() {
		return freePlacesForTasks;
	}
	
	

}
