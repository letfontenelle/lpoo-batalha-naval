package board;

public class Ship {
	// { 1 -> quantidade de peças no tabuleiro, 5 -> quantidade de espaços no
	// tabuleiro }
	// { 1, 5 }, - 1 navio de 5 canos
	// { 2, 4 } - 1 navio de 4 canos
	// { 2, 3 } - 2 navios de 3 canos
	// { 3, 2 } - 3 navios de 2 canos
	// { 4, 1 } - 4 navios de 1 cano
	final static int[][] shipTypes = { { 1, 5 }, { 1, 1 } };
	static int shipTotals;
	private Board board;

	public Ship(Board board) {
		this.board = board;
	}

	protected Board getBoard() {
		return board;
	}

	public static int getShipTotals() {
		int cont = 0;

		for (int i = 0; i < shipTypes.length; i++) {
			for (int j = 0; j < shipTypes[i][0]; j++) {
				cont += 1;
			}
		}

		return cont;
	}

	public static int[][] getShipTypes() {
		return shipTypes;
	}
}