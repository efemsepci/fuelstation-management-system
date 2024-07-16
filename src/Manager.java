
public class Manager extends Person {
	
	int jobYear;
	
	public Manager(String name, String surname, int jobYear) {
		super(name,surname);
		this.jobYear = jobYear;
	}
	
	@Override
	public double calculate() {
		double managerExtra = 200;
		double newSalary = salary + managerExtra + (jobYear*50);
		salary = newSalary;
		return -salary;
	}

}
