package patterns.structural.proxy;

public class ProxyRunner {

	public static void main(String[] args) {
		Project project = new ProxyProject("https://github.com/tolyara/sandbox"); // no loading
		project.launch(); // loading and launch
		project.launch(); // loading was made, only launch
	}
	
}
