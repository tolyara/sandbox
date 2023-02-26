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
        List<Employee> employeesRaw = new ArrayList<>();
        employeesRaw.add(new Employee("Suvorov Alex", "skates, motorcycle"));
        employeesRaw.add(new Employee("Ivanov Illya", "drawing, playstation"));
        employeesRaw.add(new Employee("Vlasov Anton", "toys, cars"));
        employeesRaw.add(new Employee("Gridin Kuzma", "games, photo"));

        // after
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Suvorov Alex", "skates"));
        employees.add(new Employee("Suvorov Alex", "motorcycle"));
        employees.add(new Employee("Ivanov Illya", "drawing"));
        employees.add(new Employee("Ivanov Illya", "drawing"));
        employees.add(new Employee("Vlasov Anton", "toys"));
        employees.add(new Employee("Vlasov Anton", "cars"));
        employees.add(new Employee("Gridin Kuzma", "games"));
        employees.add(new Employee("Gridin Kuzma", "photo"));
    }

    /*
       1) There is a primary key in the table
       2) All attributes depend on the primary key as a whole, and not on any part of it.
    */
    public static void secondForm() {
        // before
        List<EmployeeProjects> employeeProjectsList = new ArrayList<>();
        employeeProjectsList.add(new EmployeeProjects(1, 1, "Vlasov Anton", "Reshala", "Coca Cola"));
        employeeProjectsList.add(new EmployeeProjects(1, 2, "Vlasov Anton", "Izmeny", "Samsung"));
        employeeProjectsList.add(new EmployeeProjects(2, 1, "Khovansky Yura", "Reshala", "Coca Cola"));
        employeeProjectsList.add(new EmployeeProjects(3, 2, "Oneshko Yulik", "Izmeny", "Samsung"));

        // after
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Vlasov Anton"));
        employees.add(new Employee(2, "Khovansky Yura"));
        employees.add(new Employee(1, "Oneshko Yulik"));

        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1, "Reshala", "Coca Cola"));
        projects.add(new Project(2, "Izmeny", "Samsung"));

        List<EmployeeProjects> employeeProjects = new ArrayList<>();
        employeeProjects.add(new EmployeeProjects(1, 1));
        employeeProjects.add(new EmployeeProjects(1, 2));
        employeeProjects.add(new EmployeeProjects(2, 1));
        employeeProjects.add(new EmployeeProjects(3, 2));
    }

    /*

     */
    public static void thirdForm() {
        // before

        // after
    }

}

class Employee {

    private int employeeId;
    private String name;
    private String hobbies;

    public Employee(String name, String hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

}

class EmployeeProjects {

    private int employeeId;
    private int projectId;
    private String name;
    private String project;
    private String projectClient;

    public EmployeeProjects(int employeeId, int projectId, String name, String project, String projectClient) {
        this.employeeId = employeeId;
        this.projectId = projectId;
        this.name = name;
        this.project = project;
        this.projectClient = projectClient;
    }

    public EmployeeProjects(int employeeId, int projectId) {
        this.employeeId = employeeId;
        this.projectId = projectId;
    }

}

class Project {

    private int projectId;
    private String project;
    private String projectClient;

    public Project(int projectId, String project, String projectClient) {
        this.projectId = projectId;
        this.project = project;
        this.projectClient = projectClient;
    }

}
