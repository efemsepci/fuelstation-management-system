
public class DieselService extends FuelService{
	
	boolean disCountedAntiFreeze;
	int disCountedAntiFreezeCount;
	double disCountedAntiFreezePrice;
	
	public DieselService(String carPlate, double revenue, double litersBought, boolean disCountedAntiFreeze,int disCountedAntiFreezeCount) {
		super(carPlate,revenue,litersBought);
		this.disCountedAntiFreeze = disCountedAntiFreeze;
		this.disCountedAntiFreezeCount = disCountedAntiFreezeCount;
		disCountedAntiFreezePrice = 25;
	}
	
	@Override
	public void displayServiceInfo() {
		System.out.println("Diesel Service...");
		super.displayServiceInfo();
		System.out.println("Bought "+disCountedAntiFreezeCount+" discounted anti-freeze");
	}
	
	@Override
	public double makeTransaction(double averageDieselPrice) {
		
		double price;
		
		price = (averageDieselPrice*litersBought)+(disCountedAntiFreezePrice*disCountedAntiFreezeCount);
		super.makeTransaction(price);
		return revenue;
		
	}
	
	@Override
	public double calculate() {
		return revenue;
	}


}
