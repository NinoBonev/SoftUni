package app.entities.cells.bloodCells;

import app.entities.cells.Cell;

/**
 * Created by Nino Bonev - 11.7.2018 г., 18:47
 */
public abstract class BloodCell extends Cell {

    public BloodCell(String id, int health,
                     int positionRow, int positionCol) {
        super(id, health, positionRow, positionCol);
    }
}
