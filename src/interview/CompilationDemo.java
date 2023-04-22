package interview;

public class CompilationDemo {

    public static void main(String[] args) {

    }

    private static void testConstructorWorkaround() {
        Child1 child1 = new Child1();
    }

}

class Parent2 {

    protected Integer getSome() {
        return 1;
    }

}

class Child2 extends Parent2 {

    @Override
    protected Integer getSome() {
//    protected int getSome() {     // Compilation error: ...; attempting to use incompatible return type
        return 2;
    }

}

/* ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------- */

class Parent1 {

    private String name;

    public Parent1(String name) {
        this.name = name;
    }
}

class Child1 extends Parent1 {

    public Child1() {
        // workaround for parent constructor, otherwise it will be a compilation error : There is no default constructor available in 'interview.Parent1'
        super(null);
    }
}