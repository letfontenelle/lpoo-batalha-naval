package battle;

import board.*;
import exceptions.AtributoInvalido;
import exceptions.PosicaoInvalida;

import java.util.InputMismatchException;

import application.UI;


public class BattleMatch {
	private Defense boardPlayer1;
	private Defense boardPlayer2;
	private Attack boardAtaque1;
	private Attack boardAtaque2;
	private int position1;
	private String position2;

	public BattleMatch()throws AtributoInvalido, PosicaoInvalida {
		this.boardPlayer1 = new Defense(10, 10);
		this.boardPlayer2 = new Defense(10, 10);

		this.boardAtaque1 = new Attack(10,10);
		this.boardAtaque2 = new Attack(10,10);
	}
	

	public void start() throws AtributoInvalido, PosicaoInvalida {
		System.out.println("");
		System.out.println("Navios jogador 1: ");
		this.setShipsOnBoard(this.boardPlayer1);

		System.out.println("");
		System.out.println("Navios jogador 2: ");
		this.setShipsOnBoard(this.boardPlayer2);

		String winner = "";

		while (winner == "") {
			this.boardPlayer1.printBoard();
			this.boardAtaque1.printBoard();

			System.out.println("");
			System.out.println("ATAQUE - Vez da grelha azul! Escolha os alvos:");

			boolean winner1 = this.setAttacksOnBoard(this.boardAtaque1, this.boardPlayer2);

			if (winner1) {
				winner = "Grelha azul";
				break;
			}

			this.boardPlayer2.printBoard();
			this.boardAtaque2.printBoard();

			System.out.println("");
			System.out.println("ATAQUE - Vez da grelha vermelha! Escolha os alvos:");
			
			boolean winner2 = this.setAttacksOnBoard(this.boardAtaque2, this.boardPlayer1);

			if (winner2) {
				winner = "Grelha azul";
				break;
			}
		}

		System.out.println("E o vencedor da partida é: " + winner);
	}

	private void setShipsOnBoard(Defense board) throws AtributoInvalido, PosicaoInvalida {
		System.out.println("Escolha posição para cada navio!");
		System.out.println("");

		int[][] shipTypes = Ship.getShipTypes();

		// { { 1, 5 }, { 2, 4 }, { 3, 3 }, { 4, 2 } } 
		int qtd = 0;
		
		for (int i = 0; i < shipTypes.length; i++) {
			for (int j = 0; j < shipTypes[i][0]; j++) {
				qtd += shipTypes[i][0];

				switch(shipTypes[i][1]) {
					case 5:
						System.out.printf("Digite o 1° Porta aviões (5 canos): ");
						System.out.println("");
						break;
					case 4:
						System.out.printf("Digite o %d° Navio Tanque (4 canos): ", j + 1);
						System.out.println("");
						break;
					case 3:
						System.out.printf("Digite o %d° Contra Torpedeiro (3 canos): ", j + 1);
						System.out.println("");
						break;
					case 2:
						System.out.printf("Digite a %d° Fragata (2 canos): ", j + 1);
						System.out.println("");
						break;
					case 1:
						System.out.printf("Digite o %d° Submarino (1 cano): ", j + 1);
						System.out.println("");
						break;
				}
				
				int position1 = 0;
				
				//**************************************************************************************************** 
				
				try {
					
				System.out.println("Digite a primeira posição (0-9): ");
				position1 = UI.input();
				
				} catch (InputMismatchException ex) {
					
					throw new AtributoInvalido("Atribuito invalido! Escolha um numero inteiro.");
				}
				
				
				String position2 = "x";
				
				try {
				System.out.println("Digite a segunda posição (A-J): ");
				position2 = UI.inputString();
				
				
				} catch(InputMismatchException ex) {
					throw new AtributoInvalido("Atributo Invalido: Escolha uma letra de A a J!");
				}
				
				//******************************************************************************************************
				
				
				String direction = "";

				if (shipTypes[i][1] != 1) {
					
					
					
					System.out.println("Digite a direção da construção do navio (cima, baixo, direita, esquerda): ");
					direction = UI.inputString();	
				}

				String validationText = board.setShip(position1, position2, direction, shipTypes[i][1]);

				if (validationText.equals("valido")) {
					board.printBoard();
					continue;
				}

				System.out.println("\n Erro: " + validationText);
				System.out.println("");
				j--;
			}
		}
		
		board.setPositionsWithShips(qtd);
	}
	
	
	
	private boolean setAttacksOnBoard(Attack boardAttack, Defense boardDefense) throws AtributoInvalido, PosicaoInvalida {
		int qtdAttacks = 3;

        for (int j = 0; j < qtdAttacks; j++) {
			System.out.printf("Digite o %d° ataque: ",j+1);
			System.out.println("");

            System.out.println("Digite a primeira posição (0-9): ");
            int positionX = UI.input();
            System.out.println("Digite a segunda posição (A-J): ");
            String positionY = UI.inputString();

            String validationText = boardAttack.setAttack(positionX, positionY, boardDefense);

			if (validationText.equals("valido")) {
				boardAttack.printBoard();
				continue;
			} else if (validationText.equals("ganhador")) {
				return true;
			}

			System.out.println("\n Erro: " + validationText);
			System.out.println("");
			j--;
        }

		return false;
	}
}
