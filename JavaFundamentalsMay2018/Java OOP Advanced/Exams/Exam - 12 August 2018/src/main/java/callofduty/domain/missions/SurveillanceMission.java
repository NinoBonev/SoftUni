package callofduty.domain.missions;

import callofduty.constants.EngineConstants;

/**
 * Created by Nino Bonev - 17.8.2018 г., 15:08
 */
public class SurveillanceMission extends BaseMission {
    public SurveillanceMission(String id, Double rating, Double bounty) {
        super(id, rating, bounty);
    }

    @Override
    protected Double getRatingModifier() {
        return EngineConstants.SUR_RATING_MODIFIER;
    }

    @Override
    protected Double getBountyModifier() {
        return EngineConstants.SUR_BOUNTY_MODIFIER;
    }
}
