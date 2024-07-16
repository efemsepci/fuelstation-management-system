
public class GasolineService extends FuelService{
	
	boolean hasCoupon;
	
	public GasolineService(String carPlate, double revenue, double litersBought, boolean hasCoupon) {
		super(carPlate, revenue, litersBought);
		this.hasCoupon = hasCoupon;
	}
	
	@Override
	public void displayServiceInfo() {
		System.out.println("Gasoline Service...");
		super.displayServiceInfo();
		if(hasCoupon == true) {
			System.out.println("Has 10% discount coupon");
		}
	}
	
	@Override
	public double makeTransaction(double averageGasolinePrice) {
		double price;
		double disCountRatio = 0.9;
		if(hasCoupon == true) {
			price = averageGasolinePrice*litersBought*disCountRatio;
		}
		else {
			price = averageGasolinePrice*litersBought;
		}
		super.makeTransaction(price);
		return revenue;
	}
	
	@Override
	public double calculate() {
		return revenue;
	}

}
