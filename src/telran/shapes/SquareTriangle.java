package telran.shapes;

public class SquareTriangle extends Square {
	
	private boolean isLeftDiagonal = false;

	protected SquareTriangle(int width, boolean isLeftDiagonal) {
		super(width);
		this.isLeftDiagonal = isLeftDiagonal;
	}
	
	public String[] presentation(int offset) {
		int height = getHeight();
		String result[] = new String[height];
		String line = getLine(offset);
		result[0] = getFirstLine(offset);
		int lastLine = height - 1;
		result[lastLine] = line;
		for (int i = 1; i < lastLine; i++) {
			result[i] = this.getMiddleLine(offset, i-1);
		}
		return result;
	}
	
	private String getFirstLine(int offset) {
		String symbol = getSymbol();
		int width = getWidth();
		String line = isLeftDiagonal
				? symbol + getOffset(width - 1)
				: getOffset(width - 1) + symbol;
		return getOffset(offset) + line;
	}
	
	private String getMiddleLine(int offset, int gap) {
		String symbol = getSymbol();
		int width = getWidth();
		String line = isLeftDiagonal
				? symbol + getOffset(gap) + symbol + getOffset(width - gap - 2)
				: getOffset(width - gap - 2) + symbol + getOffset(gap) + symbol;
		return getOffset(offset) + line;
	}
	
}
