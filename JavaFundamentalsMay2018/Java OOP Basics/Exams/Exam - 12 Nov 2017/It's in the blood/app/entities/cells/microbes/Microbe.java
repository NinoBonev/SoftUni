package app.entities.cells.microbes;

import app.entities.cells.Cell;

/**
 * Created by Nino Bonev - 11.7.2018 г., 18:50
 */
public abstract class Microbe extends Cell {
    private int virulence;

    public Microbe(String id, int health, int positionRow,
                   int positionCol, int virulence) {
        super(id, health, positionRow, positionCol);
        this.virulence = virulence;
    }

    public int getVirulence() {
        return this.virulence;
    }

}
