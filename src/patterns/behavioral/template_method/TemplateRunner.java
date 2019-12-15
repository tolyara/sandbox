package patterns.behavioral.template_method;

public class TemplateRunner {
	
	public static void main(String[] args) {
		WebsitePage welcomePage = new WelcomePage();
		WebsitePage newsPage = new NewsPage();
		welcomePage.showPage();
		System.out.println("\n==============================\n");
		newsPage.showPage();
	}

}
