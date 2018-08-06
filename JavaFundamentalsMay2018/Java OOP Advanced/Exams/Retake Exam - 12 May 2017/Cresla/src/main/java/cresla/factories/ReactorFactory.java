package cresla.factories;

import cresla.entities.reactors.CryoReactor;
import cresla.entities.reactors.HeatReactor;
import cresla.interfaces.Reactor;

/**
 * Created by Nino Bonev - 3.8.2018 г., 9:46
 */
public class ReactorFactory {

    public ReactorFactory() {
    }

    public Reactor createReactor(int Id, String type, int additionalParameter, int moduleCapacity) {
        switch (type) {
            case "Cryo":
                return new CryoReactor(Id, additionalParameter, moduleCapacity);
            case "Heat":
                return new HeatReactor(Id, additionalParameter, moduleCapacity);
            default:
                return null;
        }
    }
}
