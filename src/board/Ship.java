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

	public static int[][] getShipTypes() {
		// { 1 -> quantidade de peças no tabuleiro, 5 -> quantidade de espaços no tabuleiro }
		// { 1, 5 }, { 2, 4 }, { 3, 3 }, { 4, 2 }
		int[][] shipTypes = { { 2, 4 } };
		return shipTypes;
	}
}
