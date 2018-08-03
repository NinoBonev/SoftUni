package cresla.constants;

/**
 * Created by Nino Bonev - 1.8.2018 г., 20:42
 */
public class Messages {

    public static final String REACTOR_CREATED = "Created %s Reactor - %d"; // {type} - {Id}
    public static final String MODULE_CREATED = "Added %s - %d to Reactor - %d";//{moduleType} - {moduleId} - {reactorId}
    public static final String EXIT_MESSAGE = "Cryo Reactors: %d\nHeat Reactors: %d\n" +
            "Energy Modules: %d\nAbsorbing Modules: %d\nTotal Energy Output: %d\nTotal Heat Absorbing: %d";
    public static final String REACTOR_STRING = "%s - %d\nEnergy Output: %d\nHeat Absorbing: %d\nModules: %d";
    public static final String BASIC_MODULE_STRING = "%s Module - %d";

    public static final String ABSORBING_MODULE_STRING = "Heat Absorbing: %d";
    public static final String ENERGY_MODULE_STRING = "Energy Output: %d";
}
