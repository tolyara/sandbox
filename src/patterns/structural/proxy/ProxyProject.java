package patterns.structural.proxy;

public class ProxyProject implements Project {
	
	private String url;
	private RealProject realProject;
	
	public ProxyProject(String url) {
		this.url = url;
	}

	@Override
	public void launch() {
		if (realProject == null) {
			realProject = new RealProject(url);
		}
		realProject.launch();
	}
	
}
