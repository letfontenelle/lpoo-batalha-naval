package application;

import battle.BattleMatch;

public class Menu {
	public void print() {
		UI.printMenu();
		int option = UI.input();

		switch(option) {
			case 1:
                BattleMatch battleMatch = new BattleMatch();
				battleMatch.start();

				break;
			case 2:
				System.exit(1);
				break;
		}
	}
}
