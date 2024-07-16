
public class Gasoline {
	
	String origin;
	double pricePerLiter;
	double totalLiters;
	
	//constructor
	public Gasoline(String origin, double pricePerLiter, double totalLiters) {
		this.origin = origin;
		this.pricePerLiter = pricePerLiter;
		this.totalLiters = totalLiters;
	}
	
	public void displayInformation() {
		System.out.println("Gasoline...");
		System.out.println("The origin is: " + origin);
		System.out.println("Price per liter is: " + pricePerLiter);
		System.out.println("Total liters of this gasoline is: " + totalLiters);
		System.out.println();
	}

}
