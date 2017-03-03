
public abstract class Task {

		private final String name;
		private double workingHours;
		
		public Task (String name, double workingHours) {
			if (name != null && !name.isEmpty() && workingHours > 0) {
				this.name=name;
				this.workingHours=workingHours;
			}
			else {
				this.name = "Task";
				this.workingHours = 8;
			}
		}

		public String getName() {
			return name;
		}

		public double getWorkingHours() {
			return workingHours;
		}

		public void setWorkingHours(double workingHours) {
			if (workingHours >= 0) {
				this.workingHours = workingHours;
			}
		}
		
		public String toString() {
			return this.getName();
		}

	}


