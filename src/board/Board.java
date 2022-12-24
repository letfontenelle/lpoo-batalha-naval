package board;

public class Board {
	private int rows;
	private int columns;
	private  Ship[][] ships;
	
	
	public Board(int rows, int columns) {
		
		this.rows = rows;
		this.columns = columns;
		ships = new Ship[rows][columns];
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public int getColumns() {
		return columns;
	}


	public void setColumns(int columns) {
		this.columns = columns;
	}
	
	public Ship ship(int row, int column) {
		return ships[row][column];
	}
	public Ship ship(Position position) {
		return ships[position.getRow()][position.getColumn()];
	}
}
