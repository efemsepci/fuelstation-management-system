
public class CarWash extends Service {
	final static double basePrice = 10;
	
	public CarWash(String carPlate, double revenue) {
		super(carPlate,revenue);
	}
	
	public double getBasePrice() {
		return basePrice;
	}
	
	@Override
	public void displayServiceInfo() {
		System.out.println("Car Wash Service...");
		super.displayServiceInfo();
	}
	
	@Override
	public double makeTransaction(double basePrice) {
		super.makeTransaction(basePrice);
		return revenue;
	}
	
	@Override
	public double calculate() {
		return basePrice;
	}
}
