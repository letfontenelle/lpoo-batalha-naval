package board;

import exceptions.PosicaoInvalida;

abstract class Board {
	public int[][] matriz;
	private int rows;
	private int columns;
	public int playerNumber;

	public Board(int rows, int columns, int playerNumber) throws PosicaoInvalida{
		this.rows = rows;
		this.columns = columns;
		this.playerNumber = playerNumber;

		matriz = new int[rows][columns];
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				matriz[i][j] = 0;
			}
		}
	}

	public int[][] getMatriz() {
		return matriz;
	}

	public abstract void printBoard();

	public abstract String setOnBoard(int position1, String position2, String direction, int qntd, Defense boardDefense) throws PosicaoInvalida;

	public String validPosition(int positionY, String positionX ) throws PosicaoInvalida {
		if (positionY > 9 || positionY < 0) {
			throw new PosicaoInvalida("A primeira e segunda posição não existem!");
        }

		String[] positions2 = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
		int intPosition2 = -1;

		for (int i = 0; i < positions2.length; i++) {
			if (positions2[i].toLowerCase().equals(positionX.toLowerCase())) {
				intPosition2 = i;
			}
		}

		if (intPosition2 == -1) {
			throw new PosicaoInvalida("Segunda posição não existe!");
		}

		return positionY + ";" + intPosition2;
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

}