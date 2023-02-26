package db.normalization;

import java.util.ArrayList;
import java.util.List;

public class NormalizationExample {

    public static void main(String[] args) {

    }

    /*
        1) Each table cell must contain only one value
        2) There should be no duplicate lines
     */
    public static void firstForm() {
        // before
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Suvorov Alex", "skates, motorcycle"));
        employees.add(new Employee("Ivanov Illya", "drawing, playstation"));
        employees.add(new Employee("Vlasov Anton", "toys, cars"));
        employees.add(new Employee("Gridin Kuzma", "games, photo"));

        // after
        List<Employee> employees2 = new ArrayList<>();
        employees.add(new Employee("Suvorov Alex", "skates"));
        employees.add(new Employee("Suvorov Alex", "motorcycle"));
        employees.add(new Employee("Ivanov Illya", "drawing"));
        employees.add(new Employee("Ivanov Illya", "drawing"));
        employees.add(new Employee("Vlasov Anton", "toys"));
        employees.add(new Employee("Vlasov Anton", "cars"));
        employees.add(new Employee("Gridin Kuzma", "games"));
        employees.add(new Employee("Gridin Kuzma", "photo"));
    }

}

class Employee {

    private String name;
    private String hobbies;

    public Employee(String name, String hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

}
