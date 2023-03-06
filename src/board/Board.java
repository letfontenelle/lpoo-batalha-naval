package board;

import application.UI;

public class Board {
	
	
	protected int[][] matriz;
	private int rows;
	private int columns;

	public Board(int rows, int columns) {
		
		
		this.rows = rows;
		this.columns = columns;

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

	public void printBoard() {
		UI.printBoard(this.matriz);
	}

	
	public String setAttack(int positionY, String positionX) {
		String[] positionsX = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
		int intPositionY = -1;

		for (int i = 0; i < positionsX.length; i++) {
			if (positionsX[i].toLowerCase().equals(positionX.toLowerCase())) {
				intPositionY = i;
			}
		}

		if (intPositionY == -1) {
			return "Posição 2 não existe!";
		}

		if (this.matriz[positionY][intPositionY] != 0) {
			return "Já existe uma peça nesse lugar";
		}

		this.matriz[positionY][intPositionY] = 2;
		

		return "valido";
	}
	
	
	public String validPosition(int positionY, String positionX ) {
		if (positionY > 9 || positionY < 0) {
            return "A primeira posição não existe!";
        }
		
		String[] positions2 = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
		int intPosition2 = -1;

		for (int i = 0; i < positions2.length; i++) {
			if (positions2[i].toLowerCase().equals(positionX.toLowerCase())) {
				intPosition2 = i;
			}
		}

		if (intPosition2 == -1) {
			return "A segunda posição não existe!";
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
