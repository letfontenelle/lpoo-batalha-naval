package battle;

import board.*;
import exceptions.AtributoInvalido;
import exceptions.PosicaoInvalida;

import java.util.InputMismatchException;

public class BattleMatch {
	public Defense boardPlayer1;
	public Defense boardPlayer2;
	public Attack boardAtaque1;
	public Attack boardAtaque2;
	private int position1;
	private String position2;

	public BattleMatch()throws AtributoInvalido, PosicaoInvalida {
		this.boardPlayer1 = new Defense(10, 10, 1);
		this.boardPlayer2 = new Defense(10, 10, 2);

		this.boardAtaque1 = new Attack(10,10, 1);
		this.boardAtaque2 = new Attack(10,10, 2);
	}
}
