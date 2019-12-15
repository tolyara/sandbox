package patterns.creational.builder;

public class Website {
	
	private String name;
	private CMS cms;
	private int price;	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public CMS getCms() {
		return cms;
	}
	
	public void setCms(CMS cms) {
		this.cms = cms;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Website [name=" + name + ", cms=" + cms + ", price=" + price + "]";
	}

}
