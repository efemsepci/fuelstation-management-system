import java.util.*;
import java.util.Locale; // i imported it because of InputMismatchException for double values.

public class Station {

	String stationName;
	int ID;
	Gasoline[] gasolineArray;
	Diesel[] dieselArray;
	Service[] serviceArray;
	Person[] personList;
	static double averageGasolinePrice;
	static double totalGasolineInStation;
	static double averageDieselPrice;
	static double totalDieselInStation;
	static ArrayList<Profitable> profitable = new ArrayList<Profitable>();
	
	//constructor
	public Station(String stationName, int ID ) {
		this.stationName = stationName;
		this.ID = ID;
		gasolineArray = new Gasoline[10];
		dieselArray = new Diesel[10];
		serviceArray = new Service[10];
		personList = new Person[10];
	}
	
	public static Station createStation() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter the name of the Station: ");
		String myStationName = sc.nextLine();
		System.out.print("Please enter the Station ID: ");
		int myID = 0;
		boolean error = true;
		while(error) {
			try {
				myID = sc.nextInt();
				error = false;
			}
			catch (InputMismatchException e){
				System.err.println("ID should be an integer...");
				System.out.print("Please enter the Station ID: ");
				sc.next();
			}
		}
		Station myStation = new Station(myStationName, myID);
		
		return myStation;
	}
	
	public static void findStationAndAddGasoline(Station[] stationArray) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Please enter the ID of the Station you want to search: ");
		int id = sc.nextInt();
		sc.nextLine();
		boolean check = false;
		int stationIndex = 0;
		for(int i = 0; stationArray[i] != null; i++) {
			if(stationArray[i].ID == id) {
				check = true;
				stationIndex = i;
				break;
			}
		}
		if(check == true) {
			System.out.println();
			System.out.print("Please enter the origin of gasoline: ");
			String origin = sc.nextLine();
			System.out.print("Please enter the price per liter: ");
			double price = 0;
			boolean error1 = true;
			while(error1) {
				try {
					price = sc.nextDouble();
					error1 = false;
				}
				catch (InputMismatchException e) {
					System.err.println("price should be double...");
					System.out.print("Please enter the price per liter: ");
					sc.next();
				}
			}
			System.out.print("Please enter the total shipment volume in liter: ");
			double liter = 0;
			boolean error2 = true;
			while(error2) {
				try {
					liter = sc.nextDouble();
					error2 = false;
				}
				catch(InputMismatchException e) {
					System.err.println("liter should be double...");
					System.out.print("Please enter the total shipment volume in liter: ");
					sc.next();
				}
			}
			totalGasolineInStation += liter;
			Gasoline myGasoline = new Gasoline(origin,price,liter);
			int gasolineIndex = 0;
			while(stationArray[stationIndex].gasolineArray[gasolineIndex]!=null) {
				gasolineIndex++;
			}
			stationArray[stationIndex].gasolineArray[gasolineIndex] = myGasoline;
			
		}
		else {
			System.out.println();
			System.out.println("No station found with the given ID!");
		}
		int totalPrice = 0;
		for(int i = 0;stationArray[stationIndex].gasolineArray[i]!=null;i++) {
			totalPrice += stationArray[stationIndex].gasolineArray[i].pricePerLiter*stationArray[stationIndex].gasolineArray[i].totalLiters;
		}
		averageGasolinePrice = totalPrice/totalGasolineInStation;
		
		System.out.println();
		System.out.println("The total gasoline liters in Station #"+id+" is "+totalGasolineInStation);
		System.out.println("The average gasoline price in Station #"+id+" is "+averageGasolinePrice);
		
	}
	
	public static void findStationAndAddDiesel(Station[] stationArray) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Please enter the ID of the Station you want to search: ");
		int id = sc.nextInt();
		sc.nextLine();
		boolean check = false;
		int stationIndex = 0;
		for(int i = 0; stationArray[i] != null; i++) {
			if(stationArray[i].ID == id) {
				check = true;
				stationIndex = i;
				break;
			}
		}
		if(check == true) {
			System.out.println();
			System.out.print("Please enter the origin of diesel: ");
			String origin = sc.nextLine();
			System.out.print("Please enter the price per liter: ");
			double price = 0;
			boolean error1 = true;
			while(error1) {
				try {
					price = sc.nextDouble();
					error1 = false;
				}
				catch (InputMismatchException e) {
					System.err.println("price should be double...");
					System.out.print("Please enter the price per liter: ");
					sc.next();
				}
			}
			System.out.print("Please enter the total shipment volume in liter: ");
			double liter = 0;
			boolean error2 = true;
			while(error2) {
				try {
					liter = sc.nextDouble();
					error2 = false;
				}
				catch(InputMismatchException e) {
					System.err.println("liter should be double...");
					System.out.print("Please enter the total shipment volume in liter: ");
					sc.next();
				}
			}
			totalDieselInStation += liter;
			Diesel myDiesel = new Diesel(origin,price,liter);
			int dieselIndex = 0;
			while(stationArray[stationIndex].dieselArray[dieselIndex]!=null) {
				dieselIndex++;
			}
			stationArray[stationIndex].dieselArray[dieselIndex] = myDiesel;
			
		}
		else {
			System.out.println();
			System.out.println("No station found with the given ID!");
		}
		int totalPrice = 0;
		for(int i = 0;stationArray[stationIndex].dieselArray[i]!=null;i++) {
			totalPrice += stationArray[stationIndex].dieselArray[i].pricePerLiter*stationArray[stationIndex].dieselArray[i].totalLiters;
		}
		averageDieselPrice = totalPrice/totalDieselInStation;
		
		System.out.println();
		System.out.println("The total diesel liters in Station #"+id+" is "+totalDieselInStation);
		System.out.println("The average diesel price in Station #"+id+" is "+averageDieselPrice);
		
	}
	
	public static void addPerson(Station[] stationArray) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. Add a personnel");
		System.out.println("2. Add a manager");
		int option = sc.nextInt();
		
		if(option == 1) {
			System.out.println();
			System.out.print("Please enter the ID of the Station you want to add a person: ");
			int id = sc.nextInt();
			System.out.println();
			sc.nextLine();
			boolean check = false;
			int stationIndex = 0;
			for(int i = 0; stationArray[i] != null; i++) {
				if(stationArray[i].ID == id) {
					check = true;
					stationIndex = i;
					break;
				}
			}
			if(check == true) {
				System.out.print("Please enter a name: ");
				String personnelName = sc.nextLine();
				System.out.print("Please enter a surname: ");
				String personnelSurname = sc.nextLine();
				Personnel personnel = new Personnel(personnelName, personnelSurname);
				int personnelIndex = 0;
				while(stationArray[stationIndex].personList[personnelIndex]!=null) {
					personnelIndex++;
				}
				stationArray[stationIndex].personList[personnelIndex] = personnel;
				profitable.add(personnel);
				
				
			}
			else {
				System.out.println();
				System.out.println("No station found with the given ID!");
			}
		}
		else if (option == 2) {
			System.out.println();
			System.out.print("Please enter the ID of the Station you want to search: ");
			int id = sc.nextInt();
			System.out.println();
			sc.nextLine();
			boolean check = false;
			int stationIndex = 0;
			for(int i = 0; stationArray[i] != null; i++) {
				if(stationArray[i].ID == id) {
					check = true;
					stationIndex = i;
					break;
				}
			}
			if(check == true) {
				System.out.print("Please enter a name: ");
				String managerName = sc.nextLine();
				System.out.print("Please enter a surname: ");
				String managerSurname = sc.nextLine();
				System.out.print("Please enter how many years the manager is working: ");
				int managerYear = sc.nextInt();
				Manager manager = new Manager(managerName, managerSurname, managerYear);
				int managerIndex = 0;
				while(stationArray[stationIndex].personList[managerIndex]!=null) {
					managerIndex++;
				}
				stationArray[stationIndex].personList[managerIndex] = manager;
				profitable.add(manager);
				
			}
			else {
				System.out.println();
				System.out.println("No station found with the given ID!");
			}
		}
		
	}
	
	public static void displayStationInventory(Station[] stationArray) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Please enter the ID of the Station you want to display: ");
		int id = sc.nextInt();
		boolean check = false;
		
	
		for(int i = 0; stationArray[i] != null; i++) {
			if(stationArray[i].ID == id) {
				check = true;
				break;
			}
		
	
		}
		if(check == true) {
			System.out.println();
			System.out.println("Displaying the inventory of Station #"+id);
			System.out.println();
			for(int i = 0; stationArray[i] != null; i++ ) {
				if(stationArray[i].ID == id) {
					
					for(int j = 0; stationArray[i].gasolineArray[j] != null; j++ ) {
						stationArray[i].gasolineArray[j].displayInformation();
					}
					
					System.out.println("The total gasoline liters in Station #"+id+" is "+totalGasolineInStation);
					System.out.println("The average gasoline price in Station #"+id+" is "+averageGasolinePrice);
					System.out.println();
					for(int j = 0; stationArray[i].dieselArray[j] != null; j++ ) {
						stationArray[i].dieselArray[j].displayInformation();
					}
					
					System.out.println("The total diesel liters in Station #"+id+" is "+totalDieselInStation);
					System.out.println("The average diesel price in Station #"+id+" is "+averageDieselPrice);
				}
			}
		}
		else {
			System.out.println();
			System.out.println("No station found with the given ID!");
		}
	}
	
	public static void sellGasoline(Station[] stationArray) {

		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Please enter the ID of the Station you want to sell Gasoline: ");
		int id = sc.nextInt();
		sc.nextLine();
		boolean check = false;
		int stationIndex = 0;
		for(int i = 0; stationArray[i] != null; i++) {
			if(stationArray[i].ID == id) {
				check = true;
				stationIndex = i;
				break;
			}
			
		}
		if(check == true) {
			System.out.println();
			System.out.print("Please enter the car plate: ");
			String carP = null;
			boolean error = true;
			while(error) {
				try {
					carP = sc.nextLine();
					authenticateCarPlate(carP);
					error = false;
				}
				catch(CarPlateException e){
					System.err.println("Please enter a valid Car Plate...");
					//e.printStackTrace(); i used this line for checking exceptions.
					System.out.print("Please enter the car plate: ");
				}
			}
			System.out.print("Please enter the gasoline liter: ");
			double gasolineL = sc.nextDouble();
			sc.nextLine();
			boolean couponCheck;
			if(gasolineL<=totalGasolineInStation) {
				totalGasolineInStation -= gasolineL;
				System.out.print("Please enter if you have a coupon (y/n): ");
				String haveCoupon = sc.nextLine();
				if(haveCoupon.equals("y")) {
					couponCheck = true;
				}
				else{
					couponCheck = false;
				}
				double revenue = 0;
				GasolineService gasService = new GasolineService(carP,revenue,gasolineL,couponCheck);
				revenue = gasService.makeTransaction(averageGasolinePrice);
				int serviceIndex = 0;
				for(int i = 0; stationArray[stationIndex].serviceArray[i] != null; i++) {
					serviceIndex++;
				}
				stationArray[stationIndex].serviceArray[serviceIndex] = gasService;
				profitable.add(gasService);
				
				Random random = new Random();
				int indexPersonnel = random.nextInt(stationArray[stationIndex].personList.length);
				while(!(stationArray[stationIndex].personList[indexPersonnel] instanceof Personnel)) {
					indexPersonnel = random.nextInt(stationArray[stationIndex].personList.length);
				}
				Person personnelHelped = stationArray[stationIndex].personList[indexPersonnel];
				System.out.println("Personnel that helped during service:");
				personnelHelped.displayInformation();
				personnelHelped.incJobCount();
				
			}
			else {
				System.out.println("Not enough gasoline in the station!");
			}
			
		}
		else {
			System.out.println();
			System.out.println("No station found with the given ID!");
		}
		
	}
	
	public static void sellDiesel(Station[] stationArray) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Please enter the ID of the Station you want to sell Diesel: ");
		int id = sc.nextInt();
		sc.nextLine();
		boolean check = false;
		int stationIndex = 0;
		for(int i = 0; stationArray[i] != null; i++) {
			if(stationArray[i].ID == id) {
				check = true;
				stationIndex = i;
				break;
			}
			
		}
		if(check == true) {
			System.out.println();
			System.out.print("Please enter the car plate: ");
			String carP = null;
			boolean error = true;
			while(error) {
				try {
					carP = sc.nextLine();
					authenticateCarPlate(carP);
					error = false;
				}
				catch(CarPlateException e){
					System.err.println("Please enter a valid Car Plate...");
					//e.printStackTrace(); i used this line for checking exceptions.
					System.out.print("Please enter the car plate: ");
				}
			}
			System.out.print("Please enter the diesel liter: ");
			double dieselL = sc.nextDouble();
			sc.nextLine();
			boolean antiFreezeCheck = false;
			int antiFreezeCount;
			if(dieselL<=totalDieselInStation) {
				totalDieselInStation -= dieselL;
				System.out.print("Please enter if you want discounted anti-freeze (y/n): ");
				String dcAntiFreeze = sc.nextLine();
				if(dcAntiFreeze.equals("y")) {
					antiFreezeCheck = true;
					System.out.print("Please enter how many anti-freeze you want: ");
					antiFreezeCount = sc.nextInt();
				}
				else {
					antiFreezeCheck = false;
					antiFreezeCount = 0;
				}
				double revenue = 0;
				DieselService dieselService = new DieselService(carP,revenue,dieselL,antiFreezeCheck,antiFreezeCount);
				revenue = dieselService.makeTransaction(averageDieselPrice);
				int serviceIndex = 0;
				for(int i = 0; stationArray[stationIndex].serviceArray[i] != null; i++) {
					serviceIndex++;
				}
				stationArray[stationIndex].serviceArray[serviceIndex] = dieselService;
				profitable.add(dieselService);
				
				Random random = new Random();
				int indexPersonnel = random.nextInt(stationArray[stationIndex].personList.length);
				while(!(stationArray[stationIndex].personList[indexPersonnel] instanceof Personnel)) {
					indexPersonnel = random.nextInt(stationArray[stationIndex].personList.length);
				}
				Person personnelHelped = stationArray[stationIndex].personList[indexPersonnel];
				System.out.println("Personnel that helped during service:");
				personnelHelped.displayInformation();
				personnelHelped.incJobCount();
				
			}
			else {
				System.out.println("Not enough gasoline in the station!");
			}
			
		}
		else {
			System.out.println();
			System.out.println("No station found with the given ID!");
		}
	}

	public static void sellCarWash(Station[] stationArray) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Please enter the ID of the Station you want to sell car wash: ");
		int id = sc.nextInt();
		sc.nextLine();
		boolean check = false;
		int stationIndex = 0;
		for(int i = 0; stationArray[i] != null; i++) {
			if(stationArray[i].ID == id) {
				check = true;
				stationIndex = i;
				break;
			}
			
		}
		if(check == true) {
			System.out.println();
			System.out.print("Please enter the car plate: ");
			String carP = null;
			boolean error = true;
			while(error) {
				try {
					carP = sc.nextLine();
					authenticateCarPlate(carP);
					error = false;
				}
				catch(CarPlateException e){
					System.err.println("Please enter a valid Car Plate...");
					//e.printStackTrace(); i used this line for checking exceptions.
					System.out.print("Please enter the car plate: ");
				}
			}
			
			double revenue = 0;
			CarWash carWash = new CarWash(carP,revenue);
			revenue = carWash.makeTransaction(carWash.getBasePrice());
			int serviceIndex = 0;
			for(int i = 0; stationArray[stationIndex].serviceArray[i] != null; i++) {
				serviceIndex++;
			}
			stationArray[stationIndex].serviceArray[serviceIndex] = carWash;
			profitable.add(carWash);
				
			Random random = new Random();
			int indexPersonnel = random.nextInt(stationArray[stationIndex].personList.length);
			while(!(stationArray[stationIndex].personList[indexPersonnel] instanceof Personnel)) {
				indexPersonnel = random.nextInt(stationArray[stationIndex].personList.length);
			}
			Person personnelHelped = stationArray[stationIndex].personList[indexPersonnel];
			System.out.println("Personnel that helped during service:");
			personnelHelped.displayInformation();
			personnelHelped.incJobCount();
				
			}
			
		
		else {
			System.out.println();
			System.out.println("No station found with the given ID!");
		}
	}
	
	public static void displayServices(Station[] stationArray) {

		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Please enter the ID of the Station you want to display: ");
		int id = sc.nextInt();
		boolean check = false;
		
	
		for(int i = 0; stationArray[i] != null; i++) {
			if(stationArray[i].ID == id) {
				check = true;
				break;
			}
		
	
		}
		if(check == true) {
			System.out.println();
			System.out.println("Displaying the sold services of Station #"+id);
			System.out.println();
			ArrayList<Service> services = new ArrayList<Service>();
			for(int i = 0; stationArray[i] != null; i++ ) {
				if(stationArray[i].ID == id) {
					for(int j = 0; stationArray[i].serviceArray[j] != null; j++ ) {
						services.add(stationArray[i].serviceArray[j]); 
						}
				}
			}
			PriceCompare priceCompare = new PriceCompare();
			Collections.sort(services, priceCompare);
			for(Service ser: services) {
				ser.displayServiceInfo();
				System.out.println();
			}
		}
		else {
			System.out.println();
			System.out.println("No station found with the given ID!");
		}
	}
	
	public static void displayServices2(Station[] stationArray) {
		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Please enter the ID of the Station you want to display: ");
		int id = sc.nextInt();
		boolean check = false;
		
	
		for(int i = 0; stationArray[i] != null; i++) {
			if(stationArray[i].ID == id) {
				check = true;
				break;
			}
		
	
		}
		if(check == true) {
			System.out.println();
			System.out.println("Displaying the sold services of Station #"+id);
			System.out.println();
			ArrayList<Service> services = new ArrayList<Service>();
			for(int i = 0; stationArray[i] != null; i++ ) {
				if(stationArray[i].ID == id) {
					for(int j = 0; stationArray[i].serviceArray[j] != null; j++ ) {
						services.add(stationArray[i].serviceArray[j]); 
						}
				}
			}
			Collections.sort(services);
			for(Service ser: services) {
				ser.displayServiceInfo();
				System.out.println();
			}
		}
		else {
			System.out.println();
			System.out.println("No station found with the given ID!");
		}
	}
	
	public static void calculateNetProfit(Station[] stationArray) {

		Scanner sc = new Scanner(System.in).useLocale(Locale.US);
		System.out.print("Please enter the ID of the Station you want to calculate profit: ");
		int id = sc.nextInt();
		System.out.println();
		sc.nextLine();
		boolean check = false;
		int stationIndex = 0;
		for(int i = 0; stationArray[i] != null; i++) {
			if(stationArray[i].ID == id) {
				check = true;
				stationIndex = i;
				break;
			}
		}
		if(check == true) {
			double netProfit = 0;
			Iterator<Profitable> it = profitable.iterator();
			while(it.hasNext()) {
				Profitable profit = it.next();
				
				if(profit instanceof Personnel) {
					double money = profit.calculate();
					System.out.print("Personnel: " + money);
					System.out.println();
					netProfit += money;
				}
				else if (profit instanceof Manager) {
					double money = profit.calculate();
					System.out.print("Manager: " + money);
					System.out.println();
					netProfit += money;
				}
				else if (profit instanceof DieselService) {
					double money = profit.calculate();
					System.out.print("DieselService: " + money);
					System.out.println();
					netProfit += money;
				}
				else if (profit instanceof GasolineService) {
					double money = profit.calculate();
					System.out.print("GasolineService: " + money);
					System.out.println();
					netProfit += money;
				}
				else if (profit instanceof CarWash) {
					double money = profit.calculate();
					System.out.print("CarWash: " + money);
					System.out.println();
					netProfit += money;
				}
				
			}
			System.out.print("Net profit of the station is: " + netProfit);
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("No station found with the given ID!");
			}
		}
	
	public static void authenticateCarPlate(String carPlate) throws CarPlateException {
		
		String[] splittedCarP = carPlate.split(" ");
		
		int cityNumber = Integer.parseInt(splittedCarP[0]);
		
		String letterCheck = splittedCarP[1];
		
		
		if(!(cityNumber <= 81 && cityNumber >= 1)) {
			throw new CarPlateException("Exception1");

		}
		else if(letterCheck.length() == 0 || letterCheck.length() > 3 ) {
			throw new CarPlateException("Exception2");
		}
		for (int i = 0; i<letterCheck.length(); i++) {
			if(!(letterCheck.charAt(i) >= 65 && letterCheck.charAt(i) <= 90)) {
				throw new CarPlateException("Exception3");
			}
		}
	}

}




























