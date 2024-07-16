
public class Diesel {
	
	String origin;
	double pricePerLiter;
	double totalLiters;
	
	//constructor
	public Diesel(String origin, double pricePerLiter, double totalLiters) {
		this.origin = origin;
		this.pricePerLiter = pricePerLiter;
		this.totalLiters = totalLiters;
	}
	
	
	public void displayInformation() {
		System.out.println("Diesel...");
		System.out.println("The origin is: " + origin);
		System.out.println("Price per liter is: " + pricePerLiter);
		System.out.println("Total liters of this Diesel is: " + totalLiters);
		System.out.println();
	}

}
