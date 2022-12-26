package application;

import battle.BattleMatch;

public class Menu {
    public Menu() {
		this.print();
	}

	public void print() {
		UI.printMenu();
		int option = UI.input();

		switch(option) {
			case 1:
                BattleMatch battleMatch = new BattleMatch();
				break;
			case 2:
				System.exit(1);
				break;
		}
	}
}
