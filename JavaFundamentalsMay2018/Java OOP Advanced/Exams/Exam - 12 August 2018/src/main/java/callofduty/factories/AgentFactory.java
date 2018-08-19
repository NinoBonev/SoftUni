package callofduty.factories;

import callofduty.domain.agents.NoviceAgent;
import callofduty.interfaces.Agent;

import java.util.List;

/**
 * Created by Nino Bonev - 17.8.2018 г., 15:52
 */
public class AgentFactory {

    public AgentFactory(){};

    public Agent createAgent(List<String> arguments){
        String id = arguments.get(0);
        String name = arguments.get(1);
        return new NoviceAgent(id, name);
    }
}