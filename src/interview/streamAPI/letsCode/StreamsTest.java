package interview.streamAPI.letsCode;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import interview.streamAPI.letsCode.domain.Department;
import interview.streamAPI.letsCode.domain.Employee;
import interview.streamAPI.letsCode.domain.Position;

public class StreamsTest {

	private static List<Employee> employees = List.of(new Employee("Michael", "Smith", 243, 43, Position.CHEF),
			new Employee("Jane", "Smith", 523, 40, Position.MANAGER),
			new Employee("Jury", "Gagarin", 6423, 26, Position.MANAGER),
			new Employee("Jack", "London", 5543, 53, Position.WORKER),
			new Employee("Eric", "Jackson", 2534, 22, Position.WORKER),
			new Employee("Andrew", "Bosh", 3456, 44, Position.WORKER),
			new Employee("Joe", "Smith", 723, 30, Position.MANAGER),
			new Employee("Jack", "Gagarin", 7423, 35, Position.MANAGER),
			new Employee("Jane", "London", 7543, 42, Position.WORKER),
			new Employee("Mike", "Jackson", 7534, 31, Position.WORKER),
			new Employee("Jack", "Bosh", 7456, 54, Position.WORKER),
			new Employee("Mark", "Smith", 123, 41, Position.MANAGER),
			new Employee("Jane", "Gagarin", 1423, 28, Position.MANAGER),
			new Employee("Sam", "London", 1543, 52, Position.WORKER),
			new Employee("Jack", "Jackson", 1534, 27, Position.WORKER),
			new Employee("Eric", "Bosh", 1456, 32, Position.WORKER));

	private static List<Department> departments = List.of(new Department(1, 0, "Head"), new Department(2, 1, "West"),
			new Department(3, 1, "East"), new Department(4, 2, "Germany"), new Department(5, 2, "France"),
			new Department(6, 3, "China"), new Department(7, 3, "Japan"));
	
	public static void main(String[] args) throws Exception {
		
		creation();
		
	}
	
	public static void creation() throws Exception {
		
		Stream<String> lines = Files.lines(Paths.get("some.txt"));
//		Stream<Path> list = Files.list(Paths.get("./"));
//		Stream<Path> walk = Files.walk(Paths.get("./"), 3);
//		
//		IntStream intStream = IntStream.of(1, 2, 3, 4);
//		DoubleStream doubleStream = DoubleStream.of(1.2, 3.4);
		
		lines.forEach(System.out::println);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
