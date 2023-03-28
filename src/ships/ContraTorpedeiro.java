package ships;

public class ContraTorpedeiro implements Ship {
    int spaces = 3;
    final String name = "Contra torpedeiro";
    boolean isDestroyed = false;

    @Override
    public int getAttacked() {
        spaces -= 1;

        if (spaces == 0) {
            isDestroyed = true;
            System.out.println("DESTRUIDO O CONTRA TORPEDEIRO");
            return 0;
        }

        return spaces;
    }

    @Override
    public String getTypeShip() {
        return this.name;
    }
}
