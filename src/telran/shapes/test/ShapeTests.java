package telran.shapes.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.shapes.*;

class ShapeTests {

	@Test
	@Disabled
	void rectangleTest() {
		Rectangle rectangle = new Rectangle(10, 5);
		assertEquals(10, rectangle.getWidth());
		assertEquals(5, rectangle.getHeight());
		displayStrings(rectangle.presentation(20));
		Rectangle.setSymbol("#");
		displayStrings(rectangle.presentation(20));
	}
	
	@Test
	@Disabled
	void squareTest() {
		Rectangle square = new Square(10);
		assertEquals(10, square.getWidth());
		assertEquals(10, square.getHeight());
		displayStrings(square.presentation(20));
	}
	
	@Test
	@Disabled
	void squareLeftTriangleTest() {
		Rectangle square = new SquareLeftTriangle(10);
		assertEquals(10, square.getWidth());
		assertEquals(10, square.getHeight());
		displayStrings(square.presentation(20));
	}
	
	@Test
	@Disabled
	void squareRightTriangleTest() {
		Rectangle square = new SquareRightTriangle(10);
		assertEquals(10, square.getWidth());
		assertEquals(10, square.getHeight());
		displayStrings(square.presentation(20));
	}
	
	@Test
	void canvasTest() {
		Shape[] shapes = {
				new Rectangle(10, 5),
				new Square(10),
				new SquareLeftTriangle(10),
				new SquareRightTriangle(10)
		};
		Canvas canvas = new Canvas(10, 10, shapes);
		displayStrings(canvas.presentation(5));
		
		canvas.setDirection("column");
		canvas.setMargin(1);
		displayStrings(canvas.presentation(5));
	}
	
	private void displayStrings(String strings[]) {
		for(String str: strings) {
			System.out.println(str);
		}
	}

}