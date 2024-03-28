package interview.java15;

/**
 * https://www.baeldung.com/java-15-new
 */
public class Java15 {

    public static void main(String[] args) {
        records();
    }

    private static void records () {
        Person person1 = new Person("Person1", 10);
        Person person2 = new Person("Person2", -5);

        System.out.println(person1);
        System.out.println(person2);
    }

}

record Person(String name, int age) {

    /*
        While records eliminate a lot of boilerplate code, they also allow us to override some default behaviors.
        For example, we could define a canonical constructor that does some validation:
     */
    public Person {
        if(age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
    }

}

