package patterns.structural.bridge;

public class BridgeRunner {

	public static void main(String[] args) {
		Program[] programs = { 
				new BankSystem(new JavaDeveloper()),
				new StockExchange(new CppDeveloper())
		};
		for (Program program : programs) {
			program.developProgram();
		}
	}

}
