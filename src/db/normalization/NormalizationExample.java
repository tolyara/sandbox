package db.normalization;

import java.util.ArrayList;
import java.util.Collection;
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
        employeesRaw.add(new Employee("Tushentsov Ruslan", "skates, motorcycle"));
        employeesRaw.add(new Employee("Oneshko Yulik", "drawing, playstation"));
        employeesRaw.add(new Employee("Vlasov Anton", "toys, cars"));
        employeesRaw.add(new Employee("Gridin Kuzma", "games, photo"));

        // after
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Tushentsov Ruslan", "skates"));
        employees.add(new Employee("Tushentsov Ruslan", "motorcycle"));
        employees.add(new Employee("Oneshko Yulik", "drawing"));
        employees.add(new Employee("Oneshko Yulik", "playstation"));
        employees.add(new Employee("Vlasov Anton", "toys"));
        employees.add(new Employee("Vlasov Anton", "cars"));
        employees.add(new Employee("Gridin Kuzma", "games"));
        employees.add(new Employee("Gridin Kuzma", "photo"));
    }

    /*
       1) There is a primary key in the table
       2) All attributes depend on the primary key as a whole and not on any part of it
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
        employees.add(new Employee(3, "Oneshko Yulik"));

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
        All attributes depend on the primary key and not on any other attributes
     */
    public static void thirdForm() {
        // before
        List<EmployeeAddresses> employeeAddressesList = new ArrayList<>();
        employeeAddressesList.add(new EmployeeAddresses(1, "Vlasov Anton", "Shushary", "+11111"));
        employeeAddressesList.add(new EmployeeAddresses(2, "Khovansky Yura", "Vykhino", "+22222"));
        employeeAddressesList.add(new EmployeeAddresses(3, "Oneshko Yulik", "Devyatkino", "+33333"));
        employeeAddressesList.add(new EmployeeAddresses(4, "Gridin Kuzma", "Shushary", "+11111"));

        // after
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Vlasov Anton", 1));
        employees.add(new Employee(2, "Khovansky Yura", 2));
        employees.add(new Employee(3, "Oneshko Yulik", 3));
        employees.add(new Employee(4, "Gridin Kuzma", 1));

        List<Address> addresses = new ArrayList<>();
        addresses.add(new Address(1, "Shushary", "+11111"));
        addresses.add(new Address(2, "Vykhino", "+22222"));
        addresses.add(new Address(3, "Devyatkino", "+33333"));
    }

    /*
        Boyce-Codd normal form
        Key attributes must not depend on non-key attributes
     */
    public static void thirdFormEnhanced() {
        // before
        List<ProjectTasks> projectTasksList = new ArrayList<>();
        projectTasksList.add(new ProjectTasks(1, "video filming", "Vlasov Anton"));
        projectTasksList.add(new ProjectTasks(1, "video editing", "Petr Korneev"));
        projectTasksList.add(new ProjectTasks(2, "video filming", "Vlasov Anton"));
        projectTasksList.add(new ProjectTasks(2, "video filming", "Oneshko Yulik"));
        projectTasksList.add(new ProjectTasks(2, "video editing", "Egor FromGor"));

        // after
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Vlasov Anton", "video filming"));
        employees.add(new Employee(2, "Petr Korneev", "video editing"));
        employees.add(new Employee(3, "Oneshko Yulik", "video filming"));
        employees.add(new Employee(4, "Egor FromGor", "video editing"));

        List<EmployeeProjects> employeeProjects = new ArrayList<>();
        employeeProjects.add(new EmployeeProjects(1, 1));
        employeeProjects.add(new EmployeeProjects(2, 1));
        employeeProjects.add(new EmployeeProjects(1, 2));
        employeeProjects.add(new EmployeeProjects(3, 2));
        employeeProjects.add(new EmployeeProjects(4, 2));
    }

    /*
        Multivalued dependencies are eliminated
    */
    public static void fourthForm() {
        // problem: one employee has many projects and many hobbies but projects and hobbies are independent things

        // before
        Collection<EmployeeProjects> employeeProjectsRaw = new ArrayList<>();
        employeeProjectsRaw.add(new EmployeeProjects(1, "Vlasov Anton", 1, "Reshala", "toys"));
        employeeProjectsRaw.add(new EmployeeProjects(1, "Vlasov Anton", 2, "Izmeny", "cars"));
        employeeProjectsRaw.add(new EmployeeProjects(2, "VKhovansky Yura", 1, "Reshala", "alcohol"));
        employeeProjectsRaw.add(new EmployeeProjects(2, "VKhovansky Yura", 3, "Serdtsa za lubov", "guitar"));
        employeeProjectsRaw.add(new EmployeeProjects(3, "Oneshko Yulik", 2, "Izmeny", "electronics"));
        employeeProjectsRaw.add(new EmployeeProjects(3, "Oneshko Yulik", 3, "Serdtsa za lubov", "cars"));

        // after
        Collection<EmployeeProjects> employeeProjects = new ArrayList<>();
        employeeProjects.add(new EmployeeProjects(1, 1));
        employeeProjects.add(new EmployeeProjects(1, 2));
        employeeProjects.add(new EmployeeProjects(2, 1));
        employeeProjects.add(new EmployeeProjects(2, 3));
        employeeProjects.add(new EmployeeProjects(3, 2));
        employeeProjects.add(new EmployeeProjects(3, 3));

        Collection<Employee> employees = new ArrayList<>(); // hobbies can be also moved to a separate table
        employees.add(new Employee("Vlasov Anton", "toys"));
        employees.add(new Employee("Vlasov Anton", "cars"));
        employees.add(new Employee("VKhovansky Yura", "alcohol"));
        employees.add(new Employee("VKhovansky Yura", "guitar"));
        employees.add(new Employee("Oneshko Yulik", "electronics"));
        employees.add(new Employee("Oneshko Yulik", "cars"));
    }

    /*
        Non-trivial dependencies are eliminated (decomposition without losses)
    */
    public static void fifthForm() {
        // before
        List<ProjectTasks> projectTasksList = new ArrayList<>();
        projectTasksList.add(new ProjectTasks(1, "Reshala","video filming", "Vlasov Anton"));
        projectTasksList.add(new ProjectTasks(1, "Reshala","video editing", "Khovansky Yura"));
        projectTasksList.add(new ProjectTasks(2, "Serdtsa za lubov","advertising", "Khovansky Yura"));
        projectTasksList.add(new ProjectTasks(3, "Izmeny","video editing", "Oneshko Yulik"));
        projectTasksList.add(new ProjectTasks(3, "Izmeny","video filming", "Vlasov Anton"));
        projectTasksList.add(new ProjectTasks(4, "Nemnozhko razvedeny","video filming", "Vlasov Anton"));

        // after
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Vlasov Anton", "video filming"));
        employees.add(new Employee(2, "Khovansky Yura", "video editing"));
        employees.add(new Employee(2, "Khovansky Yura", "advertising"));
        employees.add(new Employee(3, "Oneshko Yulik", "video editing"));

        List<EmployeeProjects> employeeProjects = new ArrayList<>();
        employeeProjects.add(new EmployeeProjects(1, 1));
        employeeProjects.add(new EmployeeProjects(2, 1));
        employeeProjects.add(new EmployeeProjects(2, 2));
        employeeProjects.add(new EmployeeProjects(3, 3));
        employeeProjects.add(new EmployeeProjects(1, 3));
        employeeProjects.add(new EmployeeProjects(1, 4));

        List<ProjectTasks> projectTasks = new ArrayList<>();
        projectTasks.add(new ProjectTasks(1, "Reshala").setTask("video filming"));
        projectTasks.add(new ProjectTasks(1, "Reshala").setTask("video editing"));
        projectTasks.add(new ProjectTasks(2, "Serdtsa za lubov").setTask("advertising"));
        projectTasks.add(new ProjectTasks(3, "Izmeny").setTask("video editing"));
        projectTasks.add(new ProjectTasks(3, "Izmeny").setTask("video filming"));
        projectTasks.add(new ProjectTasks(4, "Nemnozhko razvedeny").setTask("video filming"));
    }

}

class Employee {

    private int employeeId;
    private String name;
    private String hobbies;
    private int addressId;
    private String skill;

    public Employee(String name, String hobbies) {
        this.name = name;
        this.hobbies = hobbies;
    }

    public Employee(int employeeId, String name) {
        this.employeeId = employeeId;
        this.name = name;
    }

    public Employee(int employeeId, String name, int addressId) {
        this.employeeId = employeeId;
        this.name = name;
        this.addressId = addressId;
    }

    public Employee(int employeeId, String name, String skill) {
        this.employeeId = employeeId;
        this.name = name;
        this.skill = skill;
    }

}

class EmployeeProjects {

    private int employeeId;
    private int projectId;
    private String name;
    private String project;
    private String projectClient;
    private String hobbies;

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

    public EmployeeProjects(int employeeId, String name, int projectId, String project, String hobbies) {
        this.employeeId = employeeId;
        this.name = name;
        this.projectId = projectId;
        this.project = project;
        this.hobbies = hobbies;
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

class EmployeeAddresses {

    private int employeeId;
    private String name;
    private int addressId;
    private String address;
    private String phone;

    public EmployeeAddresses(int employeeId, String name, String address, String phone) {
        this.employeeId = employeeId;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

}

class Address {

    private int addressId;
    private String address;
    private String phone;

    public Address(int addressId, String address, String phone) {
        this.addressId = addressId;
        this.address = address;
        this.phone = phone;
    }

}

class ProjectTasks {

    private int projectId;
    private String project;
    private String task;
    private String responsibleEmployee;

    public ProjectTasks(int projectId, String task, String responsibleEmployee) {
        this.projectId = projectId;
        this.task = task;
        this.responsibleEmployee = responsibleEmployee;
    }

    public ProjectTasks(int projectId, String project, String task, String responsibleEmployee) {
        this.projectId = projectId;
        this.task = task;
        this.responsibleEmployee = responsibleEmployee;
        this.project = project;
    }

    public ProjectTasks(int projectId, String project) {
        this.projectId = projectId;
        this.project = project;
    }

    public ProjectTasks setTask(String task) {
        this.task = task;
        return this;
    }

}
