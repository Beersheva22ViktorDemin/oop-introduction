package telran.shapes;

public class Canvas extends Shape {
	
	private Shape[] shapes;
	private String direction = "row"; // column
	private int margin = 5;
	
	public Canvas(int width, int height, Shape[] shapes) {
		super(width, height);
		this.shapes = shapes;
	}
	
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	public void setMargin(int margining) {
		this.margin = margin;
	}
	
	@Override
	public String[] presentation(int offset) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
