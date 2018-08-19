package callofduty.domain.missions;

import callofduty.constants.EngineConstants;

/**
 * Created by Nino Bonev - 17.8.2018 г., 15:08
 */
public class HuntMission extends BaseMission {
    public HuntMission(String id, Double rating, Double bounty) {
        super(id, rating, bounty);
    }

    @Override
    protected Double getRatingModifier() {
        return EngineConstants.HUNT_RATING_MODIFIER;
    }

    @Override
    protected Double getBountyModifier() {
        return EngineConstants.HUNT_BOUNTY_MODIFIER;
    }
}
