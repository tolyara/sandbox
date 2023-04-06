package interview;

public class CompilationDemo {

    public static void main(String[] args) {

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