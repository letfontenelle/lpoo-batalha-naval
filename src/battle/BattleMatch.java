package battle;

import board.Board;
import board.Ship;

import application.UI;
public class BattleMatch {

	private Board boardPlayer1;
	private Board boardPlayer2;
	private Board boardAtaque1;
	;

	public BattleMatch() {
		
		
		boardPlayer1 = new Board(10, 10);

		System.out.println("");
		System.out.println("Navios jogador 1: ");
		this.setShipsOnBoard(boardPlayer1);
<<<<<<< HEAD
		System.out.println("GRELHA AZUL");
		boardPlayer1.printBoard();
		
		
=======

>>>>>>> 6dad724b29277b83c99afad02b38f4da3d9200dd
		boardPlayer2 = new Board(10, 10);

		System.out.println("");
		System.out.println("Navios jogador 2: ");
		this.setShipsOnBoard(boardPlayer2);
<<<<<<< HEAD
		System.out.println("GRELHA VERMELHA");
		boardPlayer2.printBoard();
		
		
		//Ataque grelha azul
		
		boardAtaque1 = new Board(10,10);
		
		System.out.println("");
		System.out.println("ATAQUE - Vez da grelha azul! Escolha os alvos:");
		this.setAttack(boardAtaque1);
		boardAtaque1.printBoard();
		
		
=======
>>>>>>> 6dad724b29277b83c99afad02b38f4da3d9200dd

	}

	public void setShipsOnBoard(Board board) {
		System.out.println("Escolha posição para cada navio!");
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

				System.out.println("Digite a direção da construção do navio (cima, baixo, direita, esquerda): ");
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
	
	
	
	public void setAttack(Board board) {
		
		int [][] attackPosition = Ship.getAttackShip();
		
		for (int i = 0; i < attackPosition.length; i++) {
			for (int j = 0; j < attackPosition[i][0]; j++) {
				switch(attackPosition[i][1]) {
					case 1:
						System.out.printf("Digite o %d˚ ataque: ",j+1);
						System.out.println("");
						break;
				}
				
				System.out.println("Digite a posição Y (0-9): ");
				int positionY = UI.input();
				System.out.println("Digite a posição X (A-J): ");
				String positionX = UI.inputString();
		
				String validationText = board.setAttack(positionY, positionX);
			}
		
		}

	}
	

	
}
