package solid.open_close;

public class MainBad {
	
	public static void main(String[] args) {
		Celica celica = new Celica();
		workInTaxi(celica);
	}
	
	static void workInTaxi(Toyota toyota) {
//		if (toyota instanceof Toyota) {
//			toyota.getPassenger();
//		} else {
//			toyota.getPassengers();
//		}
	}

}

//class Toyota {
//	
//	void getPassengers() {
//		System.out.println("Getting passengers... ");
//	}
//	
//	void getPassenger() {
//		System.out.println("Getting one passenger... ");
//	}
//	
//}
//
//class Celica extends Toyota {
//		
//}