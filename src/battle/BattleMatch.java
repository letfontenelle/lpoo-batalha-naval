package battle;
import board.Board;

public class BattleMatch {
	
	private Board board;
	
	public BattleMatch() {
		board = new Board(10,10);
	}
	
	public BattleShip[][] getShips() {
		
		BattleShip[][] mat = new BattleShip[board.getRows()][board.getColumns()];
		
		for(int i =0; i< board.getRows(); i++) {
			for (int j=0;j<board.getColumns();j++) {
				mat[i][j]= (BattleShip) board.ship(i,j);
			}
		}
		return mat;
	}
	
}
