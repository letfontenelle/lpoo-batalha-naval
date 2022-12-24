package application;
import battle.BattleShip;

public class UI {
	public static void printBoard(BattleShip[][] ships) {
		for ( int i=0; i < ships.length; i++) {
			System.out.println((10-i)+ " ");
			for(int j=0; j < ships.length; j++) {
				printShip(ships[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println("  A B C D E F G H I J");
	}
	
	private static void printShip(BattleShip ship) {
		if (ship == null) {
			System.out.println("-");
		} else {
			System.out.println(ship);
		}
		System.out.println(" ");
	}
}
