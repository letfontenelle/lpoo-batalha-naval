package application;

import battle.BattleMatch;
import board.Board;
import board.Position;

public class Main {

	public static void main(String[] args) {
		
		BattleMatch battleMatch = new BattleMatch();
		UI.printBoard(battleMatch.getShips());

	}

}
