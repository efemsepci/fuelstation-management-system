
public class FuelService extends Service{
	
	double litersBought;
	
	public FuelService(String carPlate, double revenue, double litersBought) {
		super(carPlate,revenue);
		this.litersBought = litersBought;
	}
	
	@Override
	public void displayServiceInfo() {
		System.out.println("Bought "+litersBought+" liters.");
		super.displayServiceInfo();
	}
	
	@Override
	public double makeTransaction(double price) {
		super.makeTransaction(price);
		return revenue;
	}
}
