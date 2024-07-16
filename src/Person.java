
public class Person implements Profitable {
	
	String name;
	String surname;
	double salary;
	
	public Person(String name, String surname) {
		this.name = name;
		this.surname = surname;
		salary = 100;
	}
	
	public void displayInformation() {
		System.out.println("Name: " + name);
		System.out.println("Surname: " + surname);
	}
	
	public double calculate() {
		return salary;
	}
	
	public void incJobCount() {
		
	}
}
