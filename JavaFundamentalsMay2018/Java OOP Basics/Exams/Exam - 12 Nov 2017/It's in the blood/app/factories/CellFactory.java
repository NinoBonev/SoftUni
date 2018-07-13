package app.factories;

import app.entities.cells.Cell;
import app.entities.cells.bloodCells.RedBloodCell;
import app.entities.cells.bloodCells.WhiteBloodCell;
import app.entities.cells.microbes.Bacteria;
import app.entities.cells.microbes.Fungi;
import app.entities.cells.microbes.Virus;

/**
 * Created by Nino Bonev - 12.7.2018 г., 0:58
 */
public final class CellFactory {

    private CellFactory(){}

    public static Cell createCell(String cellType, String cellId, int healt, int row, int col, int addProperty){
        switch (cellType){
            case "RedBloodCell" : return new RedBloodCell(cellId, healt, row, col, addProperty);
            case "WhiteBloodCell" : return new WhiteBloodCell(cellId, healt, row, col, addProperty);
            case "Fungi" : return new Fungi(cellId, healt, row, col, addProperty);
            case "Bacteria" : return new Bacteria(cellId, healt, row, col, addProperty);
            case "Virus" : return new Virus(cellId, healt, row, col, addProperty);
            default: return null;
        }
    }
}
