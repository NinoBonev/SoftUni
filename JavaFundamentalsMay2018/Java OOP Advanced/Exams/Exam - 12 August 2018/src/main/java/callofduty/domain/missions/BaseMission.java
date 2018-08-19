package callofduty.domain.missions;

import callofduty.constants.EngineConstants;
import callofduty.interfaces.Mission;

/**
 * Created by Nino Bonev - 17.8.2018 г., 15:07
 */
public abstract class BaseMission implements Mission {
    private String id;
    private Double rating;
    private Double bounty;


    BaseMission(String id, Double rating, Double bounty) {
        this.id = id;
        this.rating = rating;
        this.bounty = bounty;
    }

    protected Double getRatingModifier() {
        return EngineConstants.DEFAULT_RATING;
    }

    protected Double getBountyModifier() {
        return EngineConstants.DEFAULT_RATING;
    }

    @Override
    public Double getBounty() {
        return this.bounty * this.getBountyModifier();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public Double getRating() {
        return this.rating * this.getRatingModifier();
    }
}
