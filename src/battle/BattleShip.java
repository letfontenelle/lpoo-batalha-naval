package battle;

import board.Board;
import board.Ship;

public class BattleShip extends Ship{
	private Color color;

	public BattleShip(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}
		
}
