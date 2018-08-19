package callofduty;

import callofduty.core.MissionControlImpl;
import callofduty.factories.AgentFactoryImpl;
import callofduty.interfaces.*;
import callofduty.io.ConsoleReader;
import callofduty.io.ConsoleWriter;
import callofduty.manager.Engine;
import callofduty.manager.ManagerImpl;

public class Main {
    public static void main(String[] args)  {
        MissionControl missionControl = new MissionControlImpl();

        OutputWriter writer = new ConsoleWriter();
        InputReader reader = new ConsoleReader();
        AgentFactory agentFactory = new AgentFactoryImpl();

        MissionManager manager = new ManagerImpl(missionControl, agentFactory);
        
        Engine engine = new Engine(writer, reader, manager);

        engine.run();
    }
}