package ships;

public class Fragata implements Ship {
    int spaces = 2;
    final String name = "Fragata";
    boolean isDestroyed = false;

    @Override
    public int getAttacked() {
        spaces -= 1;

        if (spaces == 0) {
            isDestroyed = true;
            System.out.println("DESTRUIDA A FRAGATA");
            return 0;
        }

        return spaces;
    }

    @Override
    public String getTypeShip() {
        return this.name;
    }
}
