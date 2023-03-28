package ships;

public class NavioTanque implements Ship {
    int spaces = 4;
    final String name = "Navio Tanque";
    boolean isDestroyed = false;

    @Override
    public int getAttacked() {
        spaces -= 1;

        if (spaces == 0) {
            isDestroyed = true;
            System.out.println("DESTRUIDA O NAVIO TANQUE");
            return 0;
        }

        return spaces;
    }

    @Override
    public String getTypeShip() {
        return this.name;
    }
}