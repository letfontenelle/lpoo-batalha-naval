package board;

import exceptions.AtributoInvalido;
import exceptions.PosicaoInvalida;

import javax.swing.table.DefaultTableModel;

public class Defense extends Board {
	public int positionsWithShips;
	public int shipsPlaced = 0;

	public Defense(int row, int column, int playerNumber) throws PosicaoInvalida {
		super(row, column, playerNumber);
	}

	public void setPositionsWithShips(int qtd) {
		this.positionsWithShips += qtd;
	}

	public void printBoard(DefaultTableModel table) {
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

	protected void getAttacked(int positionX, int positionY) {
		int item = this.matriz[positionX][positionY];

		if (item == 0) {
			this.matriz[positionX][positionY] = 2;
		} else if (item == 1) {
			this.matriz[positionX][positionY] = 3;
			positionsWithShips--;
		}
	}

	@Override
	public String setOnBoard(int position1, String position2, String direction, int qntd, Defense boardDefense) throws PosicaoInvalida{
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
                    addPosition1 -= 1;
                    break;
                case "baixo":
                    addPosition1 += 1;
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

	@Override
	public void printBoard() {
		// TODO Auto-generated method stub
		
	}
	
	public String setShipsOnBoard(int position1, String position2, String direction) throws AtributoInvalido, PosicaoInvalida {
		System.out.println(Ship.getShipTotals());
		if (Ship.getShipTotals() == this.shipsPlaced) {
			return "";
		}
		
		int[][] shipTypes = Ship.getShipTypes();
		int shipType = 0;

		// { { 1, 5 }, { 2, 4 }, { 3, 3 }, { 4, 2 } } 
		int qtd = 0;
		int cont = 0;

		for (int i = 0; i < shipTypes.length; i++) {
			for (int j = 0; j < shipTypes[i][0]; j++) {
				if (cont == this.shipsPlaced) {
					System.out.println(shipTypes[i][0]);
					System.out.println(shipTypes[i][1]);
					qtd += shipTypes[i][1];
					shipType = shipTypes[i][1];

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
					cont = -1;
					break;
				}
				
				cont += 1;
			}
			
			if (cont == -1) {
				break;
			}
		}
				
		//********************************** 
		String validationText = this.setOnBoard(position1, position2, direction, shipType, this);

		if (validationText == "valido") {
			System.out.println(qtd);
			this.printBoard();
			this.setPositionsWithShips(qtd);
			this.shipsPlaced += 1;
		}

		return validationText;
	}
}