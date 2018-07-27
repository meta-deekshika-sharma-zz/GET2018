package sparseMatrix;

public final class SparseMatrix {

	private final int keyValue;
	private final int rowNumber;
	private final int columnNumber;
	
	public SparseMatrix (int keyValue, int rowNumber, int columnNumber)
	{
		this.keyValue = keyValue;
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
	}

	public int getKeyValue() {
		return keyValue;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public int getColumnNumber() {
		return columnNumber;
	}	
}
