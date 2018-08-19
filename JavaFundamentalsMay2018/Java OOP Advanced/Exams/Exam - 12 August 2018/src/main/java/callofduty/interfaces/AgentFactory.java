package callofduty.interfaces;

import java.util.List;

/**
 * Created by Nino Bonev - 19.8.2018 г., 20:44
 */
public interface AgentFactory {

    public Agent createAgent(List<String> arguments);
}
