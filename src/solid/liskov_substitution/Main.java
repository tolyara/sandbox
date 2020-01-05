package solid.liskov_substitution;

public class Main {
	
	public static void main(String[] args) {
		
		Rectangle rectangle = new Rectangle();
		rectangle.setWidth(5);
		rectangle.setHeight(10);
		System.out.println(rectangle.calculateSquare());
		
		Square square = new Square();
		square.setWidth(5);
		System.out.println(square.calculateSquare());
		
	}

}

interface Shape {
	
	public int calculateSquare();
	
}

class Rectangle implements Shape {
	
	int width;
	int height;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	
	@Override
	public int calculateSquare() {
		return width * height;
	}
	
}

class Square implements Shape {
	
	int width;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	@Override
	public int calculateSquare() {
		return width * width;
	}
	
}





















