package app.factories;

import app.entities.races.CasualRace;
import app.entities.races.DragRace;
import app.entities.races.Race;

/**
 * Created by Nino Bonev - 14.7.2018 г., 10:43
 */
public final class RaceFactory {

    private RaceFactory(){}

    public static Race openRace(String type, int length, String route, int prizePool){
        Race newRace = null;

        switch (type){
            case "Casual" :
                newRace = new CasualRace(length, route, prizePool);
                break;
            case "Drag" :
                newRace = new DragRace(length, route, prizePool);
                break;
            case "Drift" :
                newRace = new DragRace(length, route, prizePool);
                break;
        }

        return newRace;
    }
}
