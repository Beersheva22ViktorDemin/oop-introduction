package telran.shapes;

public class Rectangle extends Shape {
	
	public Rectangle(int width, int height) {
		super(width, height);
	}

	@Override
	public String[] presentation(int offset) {
		int height = getHeight();
		String result[] = new String[height];
		String line = getLine(offset);
		result[0] = line;
		int lastLine = height - 1;
		result[lastLine] = line;
		for (int i = 1; i < lastLine; i++) {
			result[i] = this.getMiddleLine(offset);
		}
		return result;
	}

	private String getMiddleLine(int offset) {
		String symbol = getSymbol();
		return getOffset(offset) + symbol + getOffset(getWidth() - 2) + symbol;
	}

	protected String getLine(int offset) {
		String symbol = getSymbol();
		return getOffset(offset) + symbol.repeat(getWidth());
	}

	protected String getOffset(int offset) {
		return " ".repeat(offset);
	}

}