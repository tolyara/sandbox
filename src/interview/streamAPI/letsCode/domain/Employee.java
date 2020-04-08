package interview.streamAPI.letsCode.domain;

public class Employee {

	private String firstName;
    
    private String lastName;
    
    private int id;
    
    private int age;
    
    private Position position;
    
	public Employee(String firstName, String lastName, int id, int age, Position position) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.age = age;
		this.position = position;
	}    
	
}
