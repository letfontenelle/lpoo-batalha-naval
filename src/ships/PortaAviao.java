package ships;

public class PortaAviao implements Ship {
    int spaces = 5;
    final String name = "Porta Avião";
    boolean isDestroyed = false;

    @Override
    public int getAttacked() {
        spaces -= 1;

        if (spaces == 0) {
            isDestroyed = true;
            System.out.println("DESTRUIDA O PORTA AVIÃO");
            return 0;
        }

        return spaces;
    }

    @Override
    public String getTypeShip() {
        return this.name;
    }
}