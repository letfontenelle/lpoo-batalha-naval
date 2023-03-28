package board;


import exceptions.PosicaoInvalida;

public class Attack extends Board{

	public Attack(int row, int column) throws PosicaoInvalida {
		super(row, column);
	}

	public String setAttack(int positionX, String positionY, Defense boardDefense) throws PosicaoInvalida {
		
		String positionsString = this.validPosition(positionX, positionY);
		String[] positions = positionsString.split(";");

		if (positions.length == 1) {
			return positionsString;
		}

		int intPositionX = Integer.parseInt(positions[0]); 
		int intPositionY = Integer.parseInt(positions[1]); 

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
}
