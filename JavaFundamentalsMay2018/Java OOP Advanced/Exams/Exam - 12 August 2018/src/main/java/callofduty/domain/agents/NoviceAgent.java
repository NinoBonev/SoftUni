package callofduty.domain.agents;

import callofduty.constants.EngineConstants;

/**
 * Created by Nino Bonev - 17.8.2018 г., 15:07
 */
public class NoviceAgent extends BaseAgent {
    public NoviceAgent(String id, String name) {
        super(id, name, EngineConstants.NOVICE_AGENT_RATING);
    }

    @Override
    protected void earnBounty(Double bounty) {

    }
}
