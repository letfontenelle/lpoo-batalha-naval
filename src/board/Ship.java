package board;

public class Ship {
	protected Position position;
	private Board board;
	
	
	public Ship(Board board) {
		
		this.board = board;
		position = null;
	}


	protected Board getBoard() {
		return board;
	}
	
	
	
	
}
