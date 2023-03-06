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

	public String setShip(int position1, String position2, String direction, int qntd) {
		
		if (position1 > 9 || position1 < 0) {
            return "A primeira posição não existe!";
        }
		
		String[] positions2 = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j" };
		String formatDirection = direction.toLowerCase();
		int intPosition2 = -1;

		for (int i = 0; i < positions2.length; i++) {
			if (positions2[i].toLowerCase().equals(position2.toLowerCase())) {
				intPosition2 = i;
			}
		}

		if (intPosition2 == -1) {
			return "A segunda posição não existe!";
		}

		if (this.matriz[position1][intPosition2] != 0) {
			return "Já existe uma peça nesse lugar";
		}

		int[][] cloneMatriz = new int[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				cloneMatriz[i][j] = this.matriz[i][j];
			}
		}

		cloneMatriz[position1][intPosition2] = 1;

		int addPosition1 = position1;
		int addPosition2 = intPosition2;

		for (int i = 1; i < qntd; i++) {
            switch (formatDirection) {
                case "cima":
                    addPosition1 += 1;
                    break;
                case "baixo":
                    addPosition1 -= 1;
                    break;
                case "direita":
                    addPosition2 += 1;
                    break;
                case "esquerda":
                    addPosition2 -= 1;
                    break;
                default:
                    return "Direção inválida";
            }

            if ((addPosition1 < 0  || addPosition1 > 9) || (addPosition2 < 0 || addPosition2 > 9)) {
                return "Peça fora do tabuleiro, tente novamente.";
            }
            
			if (cloneMatriz[addPosition1][addPosition2] != 0) {
				return "Já existe uma peça nesse lugar";
			}

			cloneMatriz[addPosition1][addPosition2] = 1;
		}

		this.matriz = cloneMatriz.clone();

		return "valido";
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
