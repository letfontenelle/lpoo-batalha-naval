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
		// { 1 -> quantidade de peças, 5 -> quantidade de espaços  que a peca ocupa }
		// { 1, 5 }, - 1 porta avioes
		//	{ 2, 4 } - 2 navios de 4 canos
		//	{ 3, 2 } - 3 navios de 2 canos
		// { 4, 1 } - 4 navios de 1 cano
		int[][] shipTypes = { { 1, 5 }};
		// { 1 -> quantidade de peças no tabuleiro, 5 -> quantidade de espaços no tabuleiro }
		// { 1, 5 }, { 2, 4 }, { 3, 3 }, { 4, 2 }
		//int[][] shipTypes = { { 1, 5 }, { 2, 4 }, { 3, 3 }, { 4, 2 } };
		return shipTypes;
	}
	
	public static int[][] getAttackShip() {
		
		//  {1 - Quantidade de ataques , quantiade de espacos atingidos}
		
		int [][] attack = {{3,1}};
		return attack;
	}
}
