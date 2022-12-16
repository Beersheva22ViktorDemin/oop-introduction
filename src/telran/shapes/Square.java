package telran.shapes;

public class Square extends Rectangle {

	public Square(int width) {
		super(width, width);
	}
	
	@Override
	public void setWidth(int width) {
		setSize(width);
	}

	@Override
	public void setHeight(int height) {
		setSize(height);
	}
	
	private void setSize(int size) {
		super.setWidth(size);
		super.setHeight(size);
	}

}