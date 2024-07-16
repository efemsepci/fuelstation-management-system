
public class Personnel extends Person{
	int jobCount;
	
	public Personnel(String name, String surname) {
		super(name,surname);
		jobCount = 0;
	}
	
	@Override
	public void incJobCount() {
		jobCount++;
	}
	
	@Override
	public double calculate() {
		double newSalary = salary + (jobCount*1.5);
		salary = newSalary;
		return -salary;
	}
}
