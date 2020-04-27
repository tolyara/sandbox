package interview.collections;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

public class EnumSetsAndMaps {

	public static void main(String[] args) {
//		EnumSet<WeekDay> holidays = EnumSet.of(WeekDay.SATURDAY, WeekDay.SUNDAY);
//		
//		for (WeekDay day : holidays) {
//			System.out.println(day);
//		}	
		
		//-------------------
		
		List<Auto> sedans = new ArrayList<Auto>();
		sedans.add(new Auto("Renault Logan"));
		sedans.add(new Auto("Opel Omega"));
		
		List<Auto> coupes = new ArrayList<Auto>();
		coupes.add(new Auto("Hyundai Tiburon"));
		coupes.add(new Auto("Mitsubishi Eclipse"));
		
		EnumMap<AutoType, List<Auto>> enumMap = new EnumMap<AutoType, List<Auto>>(AutoType.class);
		enumMap.put(AutoType.SEDAN, sedans);
		enumMap.put(AutoType.COUPE, coupes);
		
		System.out.println(enumMap.get(AutoType.SEDAN));
	}

}

enum WeekDay {
	MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}

class Auto {

	private String brand;

	public Auto(String brand) {
		this.brand = brand;
	}

	@Override
	public String toString() {
		return "Auto [brand=" + brand + "]";
	}

}

enum AutoType {
	SEDAN, COUPE, HATCHBACK
}