package telran.shapes;

import java.util.Arrays;

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
	
	public void setMargin(int margin) {
		this.margin = margin;
	}
	
	@Override
	public int getHeight() {
		return direction.equals("row") ? super.getHeight() : countHeight(shapes);
	}
	
	@Override
	public String[] presentation(int offset) {
		setSameDirections();
		switch (direction) {
		case "row":
			return rowPresentation(offset);
		case "column":
			return columnPresentation(offset);
		}
		return null;
	}
	
	private void setSameDirections() {
		for (Shape shape : shapes) {
			if (shape instanceof Canvas) {
				((Canvas) shape).setDirection(direction);
			}
		}
	}

	private String[] rowPresentation(int offset) {
		int height = getHeight();

		String[] result = new String[height];
		Arrays.fill(result, "");

		writeRowShape(result, shapes[0], offset);		
		for (int i = 1; i < shapes.length; i++) {
			writeRowShape(result, shapes[i], margin);
		}

		return result;
	}
	
	private void writeRowShape(String[] result, Shape shape, int offset) {
		shape.setHeight(getHeight());
		String[] shapeStrings = shape.presentation(offset);
		for (int row = 0; row < result.length; row++) {
			result[row] += shapeStrings[row];
		}
	}
	
	private String[] columnPresentation(int offset) {
		int height = countHeight(shapes);
		
		String[] result = new String[height];
		Integer resultRowIterator = 0;
		
		for (int i = 0; i < shapes.length - 1; i++) {
			resultRowIterator = writeColumnShape(result, shapes[i], resultRowIterator, offset);
			resultRowIterator = writeEmptyRows(result, resultRowIterator, offset);
		}
		writeColumnShape(result, shapes[shapes.length - 1], resultRowIterator, offset);

		return result;
	}

	private int countHeight(Shape[] shapes) {
		int result = 0;
		for (int i = 0; i < shapes.length; i++) {
			result += shapes[i].getHeight() + margin;
		}
		result -= margin;
		
		return result;
	}

	private int writeColumnShape(String[] result, Shape shape, int resultRowIterator, int columnOffset) {
		shape.setWidth(getWidth());
		String[] shapeStrings = shape.presentation(columnOffset);
		for (int row = 0; row < shapeStrings.length; row++) {
			result[resultRowIterator] = shapeStrings[row];
			resultRowIterator++;
		}
		
		return resultRowIterator;
	}
	
	private int writeEmptyRows(String[] result, int resultRowIterator, int offset) {
		for (int i = 0; i < margin; i++) {
			result[resultRowIterator] = getEmptyLine(offset);
			resultRowIterator++;
		}
		
		return resultRowIterator;
	}
	
	protected String getEmptyLine(int offset) {
		return getOffset(offset) + getOffset(getWidth());
	}
}
