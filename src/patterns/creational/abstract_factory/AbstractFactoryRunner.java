package patterns.creational.abstract_factory;

import patterns.creational.abstract_factory.banking.BankingTeamFactory;
import patterns.creational.abstract_factory.website.WebsiteTeamFactory;

public class AbstractFactoryRunner {
	
	public static void main(String[] args) {
		createBankSystem();
		System.out.println();
		createWebsite();
	}
	
	private static void createBankSystem() {
		
		ProjectTeamFactory projectTeamFactory = new BankingTeamFactory();
		Developer developer = projectTeamFactory.getDeveloper();
		Tester tester = projectTeamFactory.getTester();
		ProjectManager projectManager = projectTeamFactory.getProjectManager();
		
		System.out.println("Creating bank system... ");
		developer.writeCode();
		tester.testCode();
		projectManager.manageProject(); 
		
	}
	
	private static void createWebsite() {
		
		ProjectTeamFactory projectTeamFactory = new WebsiteTeamFactory();
		Developer developer = projectTeamFactory.getDeveloper();
		Tester tester = projectTeamFactory.getTester();
		ProjectManager projectManager = projectTeamFactory.getProjectManager();
		
		System.out.println("Creating website... ");
		developer.writeCode();
		tester.testCode();
		projectManager.manageProject(); 
		
	}
	
}
