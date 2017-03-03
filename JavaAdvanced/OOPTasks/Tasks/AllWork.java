
public class AllWork {
	
	private Task [] tasks;
	private int freePlacesForTasks;
	private int currentUnassignedTask;
	private int addedTasks=0;
	
	public AllWork(int index) { //подава се индекс за броя задачи в масива
		tasks = new Task[index]; // инициализираме нов масив със зададен брой задачи
		freePlacesForTasks=index; // толкова свободни места за задачи има
		currentUnassignedTask=0; // индексът на първата незаета задача е 0
	}
	
	public void addTask (Task t) {
		if (freePlacesForTasks > 0) {
			tasks[addedTasks++] = t;
			freePlacesForTasks--;
		}
		
	}
	
	public Task getNextTask () {
		if (currentUnassignedTask < this.tasks.length) { //ако индексът на текущата свободна задача е по-малък от дължината на масива
			return tasks[currentUnassignedTask++]; //връщаме текущата свободна задача и увеличаваме индекса
		} else {
		return null; // в противен случай връща нул, но то е без значение, защото 
		// отдолу имам метод, който проверявава дали има още невзети задачи и в метода work се прави проверка преди всяко даване на нова задача, дали
		// това условие е вярно, т.е няма да вземе задача, която е нул
		}
	}
	
	public boolean isAllWorkDone () {
		for (int i = 0; i < tasks.length; i++) {
			if (tasks[i].getWorkingHours() != 0) { // ако по някоя задача има още време за работа,
				return false; // връщаме фолс
			}
		}
		return true;
	}
	
	public boolean allTasksTaken() {
		if(currentUnassignedTask == tasks.length) { // проверява дали индексът на текущите незаети задачи не е станал равен на дължината на масива
			return true; // ако е - връщаме, че всички задачи са взети
		}
		return false;
	}

	public int getFreePlacesForTasks() {
		return freePlacesForTasks;
	}
	
	

}
