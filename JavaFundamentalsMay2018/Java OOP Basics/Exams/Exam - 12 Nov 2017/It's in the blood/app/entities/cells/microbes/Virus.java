package app.entities.cells.microbes;

/**
 * Created by Nino Bonev - 11.7.2018 г., 18:53
 */
public class Virus extends Microbe{
    public Virus(String id, int health, int positionRow, int positionCol, int virulence) {
        super(id, health, positionRow, positionCol, virulence);
    }

    @Override
    public int getEnergy() {
        return super.getHealth() + super.getVirulence();
    }

    @Override
    public String toString() {
        return String.format("%s--------Health: %d | Virulence: %d | Energy: %d%n",
                super.toString(), super.getHealth(), super.getVirulence(), this.getEnergy());
    }
}
