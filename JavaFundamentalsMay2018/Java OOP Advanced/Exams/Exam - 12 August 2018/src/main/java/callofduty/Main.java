package callofduty;

import callofduty.core.MissionControlImpl;
import callofduty.interfaces.InputReader;
import callofduty.interfaces.MissionControl;
import callofduty.interfaces.MissionManager;
import callofduty.interfaces.OutputWriter;
import callofduty.io.ConsoleReader;
import callofduty.io.ConsoleWriter;
import callofduty.manager.Engine;
import callofduty.manager.ManagerImpl;

public class Main {
    public static void main(String[] args)  {
        MissionControl missionControl = new MissionControlImpl();

        OutputWriter writer = new ConsoleWriter();
        InputReader reader = new ConsoleReader();
        MissionManager manager = new ManagerImpl(missionControl);

        Engine engine = new Engine(writer, reader, manager);

        engine.run();
    }
}