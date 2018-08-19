package callofduty.domain.agents;

import callofduty.constants.EngineConstants;
import callofduty.interfaces.BountyAgent;

/**
 * Created by Nino Bonev - 17.8.2018 г., 15:07
 */
public class MasterAgent extends BaseAgent implements BountyAgent {
    private Double bounty;

    public MasterAgent(String id, String name, Double rating) {
        super(id, name, rating);
        this.bounty = EngineConstants.MASTER_AGENT_BOUNTY;
    }

    @Override
    protected void earnBounty(Double bounty) {
        this.bounty += bounty;
    }

    @Override
    public Double getBounty() {
        return this.bounty;
    }


}
