package board;

public class Ship {
	
	private Board board;

	public Ship(Board board) {
		this.board = board;
	}

	protected Board getBoard() {
		return board;
	}

	public static int[][] getShipTypes() {
		// { 1 -> quantidade de peças no tabuleiro, 5 -> quantidade de espaços no tabuleiro }
		// { 1, 5 }, - 1 navio de 5 canos
		// { 2, 4 } - 1 navio de 4 canos
		// { 2, 3 } - 2 navios de 3 canos
		// { 3, 2 } - 3 navios de 2 canos
		// { 4, 1 } - 4 navios de 1 cano
		int[][] shipTypes = { { 1, 5 }, { 1, 4 }, { 3, 2 }, { 4, 1 } };

		return shipTypes;
	}
}
