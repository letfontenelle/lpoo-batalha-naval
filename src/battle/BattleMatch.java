package battle;

import board.Board;
import board.Ship;

import application.UI;
public class BattleMatch {
	private Board boardPlayer1;
	private Board boardPlayer2;

	public BattleMatch() {
		boardPlayer1 = new Board(10, 10);

		System.out.println("");
		System.out.println("Navios jogador 1: ");
		this.setShipsOnBoard(boardPlayer1);

		boardPlayer2 = new Board(10, 10);

		System.out.println("");
		System.out.println("Navios jogador 2: ");
		this.setShipsOnBoard(boardPlayer2);

	}

	public void setShipsOnBoard(Board board) {
		System.out.println("Escolha posição para cada návio!");
		System.out.println("");

		int[][] shipTypes = Ship.getShipTypes();

		// { { 1, 5 }, { 2, 4 }, { 3, 3 }, { 4, 2 } }
		for (int i = 0; i < shipTypes.length; i++) {
			for (int j = 0; j < shipTypes[i][0]; j++) {
				board.printBoard();
				System.out.println("");

				switch(shipTypes[i][1]) {
					case 5:
						System.out.printf("Digite o 1˚ Porta aviões: ");
						System.out.println("");
						break;
					case 4:
						System.out.printf("Digite o %d˚ Navio Tanque: ", j + 1);
						System.out.println("");
						break;
					case 3:
						System.out.printf("Digite o %d˚ Contra Torpedeiro: ", j + 1);
						System.out.println("");
						break;
					case 2:
						System.out.printf("Digite o %d˚ Submarino: ", j + 1);
						System.out.println("");
						break;
				}

				System.out.println("Digite a primeira posição (0-9): ");
				int position1 = UI.input();

				System.out.println("Digite a segunda posição (A-J): ");
				String position2 = UI.inputString();

				System.out.println("Digite a direção da construção do návio (cima, baixo, direita, esquerda): ");
				String direction = UI.inputString();

				String validationText = board.setShip(position1, position2, direction, shipTypes[i][1]);

				if (validationText.equals("valido")) {
					continue;
				}

				System.out.println("\n Erro: " + validationText);
				System.out.println("");
				j--;
			}
		}
	}

	// public BattleShip[][] getShips() {
	// 	BattleShip[][] mat = new BattleShip[board.getRows()][board.getColumns()];

	// 	for (int i = 0; i < board.getRows(); i++) {
	// 		for (int j = 0; j < board.getColumns(); j++) {
	// 			mat[i][j] = (BattleShip) board.ship(i, j);
	// 		}
	// 	}
	// 	return mat;
	// }

}
