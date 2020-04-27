package patterns.creational.builder;

public class BuilderRunner {
	
	public static void main(String[] args) {
		Director director = new Director();
		
		director.setBuilder(new VisitCardWebsiteBuilder());
		Website website1 = director.buildWebsite();
		System.out.println(website1);
		
		director.setBuilder(new EnterpriseWebsiteBuilder());
		Website website2 = director.buildWebsite();
		System.out.println(website2);		
	}

}
