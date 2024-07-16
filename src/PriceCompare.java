import java.util.*;

public class PriceCompare implements Comparator<Service>{
	
	public int compare(Service s1, Service s2) {
		if(s1.getRevenue() < s2.getRevenue()) return -1;
		if(s1.getRevenue() > s2.getRevenue()) return 1;
		else return 0;
	}
}
