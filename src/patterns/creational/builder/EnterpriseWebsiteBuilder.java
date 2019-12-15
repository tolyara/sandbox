package patterns.creational.builder;

public class EnterpriseWebsiteBuilder extends WebsiteBuilder {

	@Override
	void buildName() {
		website.setName("Enterprise web site");
	}

	@Override
	void buildCMS() {
		website.setCms(CMS.ALIFRESCO);
	}

	@Override
	void buildPrice() {
		website.setPrice(10000);
	}

}
