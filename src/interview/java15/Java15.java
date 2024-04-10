package interview.java15;

/**
 * https://www.baeldung.com/java-15-new
 */
public class Java15 {

    public static void main(String[] args) {
        records();
    }

    private static void records() {
        Person person1 = new Person("Person1", 10);
        Person person2 = new Person("Person2", -5);

        System.out.println(person1);
        System.out.println(person2);
    }

    /*
        Currently, Java provides no fine-grained control over the inheritance.
        Access modifiers such as public, protected, private, as well as the default package-private, provide very coarse-grained control.

        To that end, the goal of sealed classes is to allow individual classes to declare which types may be used as sub-types.
        This also applies to interface and determining which types can implement them.

     */
    private static void sealedClasses() {

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

//abstract sealed class SealedPerson
//        permits Employee, Manager {
//}

/*
    It’s important to note that any class that extends a sealed class must itself be declared sealed, non-sealed, or final.
    This ensures the class hierarchy remains finite and known by the compiler.
 */

//final class Employee extends SealedPerson {
//}

//non-sealed class Manager extends SealedPerson {
//}

