package board;


import exceptions.AtributoInvalido;
import exceptions.PosicaoInvalida;

import java.util.InputMismatchException;

import javax.swing.table.DefaultTableModel;

public class Attack extends Board{

	public Attack(int row, int column, int playerNumber) throws PosicaoInvalida {
		super(row, column, playerNumber);
	}

	public void printBoardAtt(DefaultTableModel table) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (this.matriz[i][j] == 1) {
					table.setValueAt("N", i + 1, j + 1);
				} else if(this.matriz[i][j] == 2){
					table.setValueAt("o", i + 1, j + 1);
				} else if(this.matriz[i][j] == 3){
					table.setValueAt("x", i + 1, j + 1);
				}
			}
		}
	}

	@Override
	public String setOnBoard(int positionX, String positionY, String direction, int qntd, Defense boardDefense) throws PosicaoInvalida {
		String positionsString = this.validPosition(positionX, positionY);
		String[] positions = positionsString.split(";");

		if (positions.length == 1) {
			return positionsString;
		}

		int intPositionX = Integer.parseInt(positions[0]);
		int intPositionY = Integer.parseInt(positions[1]);
		System.out.println(this.matriz[intPositionX][intPositionY]);
		System.out.println(intPositionX);
		System.out.println(intPositionY);

		if (this.matriz[intPositionX][intPositionY] == 2 || this.matriz[intPositionX][intPositionY] == 3) {
			throw new PosicaoInvalida("Posição já atacada");
		}

		if (boardDefense.matriz[intPositionX][intPositionY] == 0) {
			System.out.println("");
			System.out.println("ERROU");
			System.out.println("");

			this.matriz[intPositionX][intPositionY] = 2;
		} else if (boardDefense.matriz[intPositionX][intPositionY] == 1) {
			System.out.println("");
			System.out.println("ACERTOU");
			System.out.println("");

			this.matriz[intPositionX][intPositionY] = 3;
		}

		boardDefense.getAttacked(intPositionX, intPositionY);

		if (boardDefense.positionsWithShips <= 0) {
			return "ganhador";
		}

		return "valido";
	}
	
	public String setAttacksOnBoard(Defense boardDefense, int positionY, String positionX) throws AtributoInvalido, PosicaoInvalida {
    	if (positionY > 9 || positionY < 0) {
			throw new PosicaoInvalida("A primeira posição não existe!");
        }

		String validationText = this.setOnBoard(positionY, positionX, "", 0, boardDefense);

		return validationText;
	}

	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		
	}
}
