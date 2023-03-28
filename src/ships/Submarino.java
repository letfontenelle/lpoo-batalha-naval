package ships;

public class Submarino implements Ship {
    int spaces = 1;
    final String name = "Submarino";
    boolean isDestroyed = false;

    @Override
    public int getAttacked() {
        spaces -= 1;

        if (spaces == 0) {
            isDestroyed = true;
            System.out.println("DESTRUIDO O SUBMARINO");
            return 0;
        }

        return spaces;
    }

    @Override
    public String getTypeShip() {
        return this.name;
    }
}