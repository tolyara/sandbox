package patterns.creational.builder;

public abstract class WebsiteBuilder {
	
	Website website;
	
	void createWebsite() {
		website = new Website();
	}
	
	abstract void buildName();
	
	abstract void buildCMS();
	
	abstract void buildPrice();
	
	Website getWebsite() {
		return website;
	}

}
