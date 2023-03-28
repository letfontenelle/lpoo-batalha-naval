package board;

import exceptions.PosicaoInvalida;

public class Defense extends Board {
	public int positionsWithShips;

	public Defense(int row, int column) throws PosicaoInvalida {
		super(row, column);
	}

	public void setPositionsWithShips(int qtd) {
		this.positionsWithShips = qtd;
	}

	protected void getAttacked(int positionX, int positionY) {
		int item = this.matriz[positionX][positionY];

		if (item == 0) {
			this.matriz[positionX][positionY] = 2;
		} else if (item == 1) {
			this.matriz[positionX][positionY] = 3;
			positionsWithShips--;
		}
	}

	public String setShip(int position1, String position2, String direction, int qntd) throws PosicaoInvalida {
		
		
		String positionsString = this.validPosition(position1, position2);
		String[] positions = positionsString.split(";");

		if (positions.length == 1) {
			return positionsString;
		}

		int intPosition1 = Integer.parseInt(positions[0]); 
		int intPosition2 = Integer.parseInt(positions[1]); 

		String formatDirection = direction.toLowerCase();

		if (this.matriz[intPosition1][intPosition2] != 0) {
			throw new PosicaoInvalida("Já existe uma peça nesse lugar");
		}

		int[][] cloneMatriz = new int[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				cloneMatriz[i][j] = this.matriz[i][j];
			}
		}

		cloneMatriz[intPosition1][intPosition2] = 1;

		int addPosition1 = intPosition1;
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
                throw new PosicaoInvalida("Peça fora do tabuleiro, tente novamente.");
            }
            
			if (cloneMatriz[addPosition1][addPosition2] != 0) {
				throw new PosicaoInvalida("Já existe uma peça nesse lugar.");
			}

			cloneMatriz[addPosition1][addPosition2] = 1;
		}

		this.matriz = cloneMatriz.clone();

		return "valido";
	}
}