package telran.shapes.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.shapes.*;

class ShapeTests {

	@Test
	void rectangleTest() {
		Rectangle rectangle = new Rectangle(10, 5);
		assertEquals(10, rectangle.getWidth());
		assertEquals(5, rectangle.getHeight());
		displayStrings(rectangle.presentation(20));
		Rectangle.setSymbol("#");
		displayStrings(rectangle.presentation(20));
	}
	
	@Test
	void squareTest() {
		Rectangle square = new Square(10);
		assertEquals(10, square.getWidth());
		assertEquals(10, square.getHeight());
		displayStrings(square.presentation(20));
	}
	
	@Test
	void squareLeftTriangleTest() {
		Rectangle square = new SquareLeftTriangle(10);
		assertEquals(10, square.getWidth());
		assertEquals(10, square.getHeight());
		displayStrings(square.presentation(20));
	}
	
	@Test
	void squareRightTriangleTest() {
		Rectangle square = new SquareRightTriangle(10);
		assertEquals(10, square.getWidth());
		assertEquals(10, square.getHeight());
		displayStrings(square.presentation(20));
	}
	
	
	private void displayStrings(String strings[]) {
		for(String str: strings) {
			System.out.println(str);
		}
	}

}