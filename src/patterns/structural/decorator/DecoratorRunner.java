package patterns.structural.decorator;

public class DecoratorRunner {
	
	public static void main(String[] args) {
		Developer senior = new SeniorJavaDeveloper(new JavaDeveloper());
		Developer teamLead = new JavaTeamLead(new SeniorJavaDeveloper(new JavaDeveloper()));
		System.out.println(senior.makeJob());
		System.out.println(teamLead.makeJob());
	}

}
