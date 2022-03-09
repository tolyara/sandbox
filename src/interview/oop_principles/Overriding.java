package interview.oop_principles;

import java.io.FileNotFoundException;

public class Overriding {

	public static void main(String[] args) throws FileNotFoundException {
		
		new Human().getName();
		
	}
	
}

class Human {
	
	int name;

	public int getName() throws FileNotFoundException {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}
	
}

class Teacher extends Human {
	
	@Override
	public int getName() {
		return name;
	}

	@Override
	public void setName(int name) {
		this.name = name;
	}
	
}