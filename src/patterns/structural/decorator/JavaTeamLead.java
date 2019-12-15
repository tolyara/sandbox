package patterns.structural.decorator;

public class JavaTeamLead extends DeveloperDecorator {

	public JavaTeamLead(Developer developer) {
		super(developer);
	}
	
	@Override
	public String makeJob() {
		return super.makeJob() + sendWeekReport();
	}
	
	public String sendWeekReport() {
		return " Send week report to customer.";
	}

}
