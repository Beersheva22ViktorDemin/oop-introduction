package telran.shapes;

public class Square extends Rectangle {

	public Square(int width) {
		super(width, width);
	}
	
	public void setWidth(int width) {
		setSize(width);
	}

	public void setHeight(int height) {
		setSize(height);
	}
	
	private void setSize(int size) {
		super.setWidth(size);
		super.setHeight(size);
	}

}