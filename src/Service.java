import java.util.*;

public class Service implements Profitable, Comparable<Service>{
	
	String carPlate;
	double revenue;
	
	public Service(String carPlate, double revenue) {
		this.carPlate = carPlate;
		this.revenue = revenue;
	}
	
	public String getCarPlate() {
		return carPlate;
	}
	
	public double getRevenue() {
		return revenue;
	}
	
	public void displayServiceInfo() {
		System.out.println("Car Plate is " + getCarPlate());
		System.out.println("The revenue from this service is " + getRevenue());
	}
	
	public double makeTransaction(double price) {
		revenue = price;
		return revenue;
	}
	public double calculate() {
		return revenue;
	}
	
	@Override
	public int compareTo(Service s) {
		if(this.getCarPlate().length() > s.getCarPlate().length()) {
			return 1;
		}
		else if(this.getCarPlate().length() < s.getCarPlate().length()) {
			return -1;
		}
		return this.getCarPlate().compareTo(s.getCarPlate());
	}
}
