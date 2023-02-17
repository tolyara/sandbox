package patterns.behavioral.interpreter;

public class InterpreterRunner {
	
	public static void main(String[] args) {
		Expression isJava = getJavaExpression();
		Expression isJavaEE = getJavaEEExpression();

		System.out.println("Does developer know Java Core: " + isJava.interpret("Java")); // true
		System.out.println("Does developer know Java Core: " + isJava.interpret("Core")); // true
		System.out.println();

		System.out.println("Does developer know Java EE: " + isJavaEE.interpret("Java Maven SQL")); // false
		System.out.println("Does developer know Java EE: " + isJavaEE.interpret("Spring Hibernate Mongo")); // false
		System.out.println("Does developer know Java EE: " + isJavaEE.interpret("Java Kafka Spring")); // true
	}
	
	public static Expression getJavaExpression() {
		Expression java = new TerminalExpression("Java");
		Expression javaCore = new TerminalExpression("Core");
		return new OrExpression(java, javaCore);
	}
	
	public static Expression getJavaEEExpression() {
		Expression java = new TerminalExpression("Java");
		Expression spring = new TerminalExpression("Spring");
		return new AndExpression(java, spring);
	}

}
