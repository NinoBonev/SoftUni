package callofduty.domain.agents;

import callofduty.interfaces.Agent;
import callofduty.interfaces.Mission;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Nino Bonev - 17.8.2018 г., 15:06
 */
public abstract class BaseAgent implements Agent {
    private String id;
    private String name;
    private Double rating;
    private List<Mission> missions;
    private List<Mission> completedMissions;

    BaseAgent(String id, String name, Double rating) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.missions = new LinkedList<>();
        this.completedMissions = new LinkedList<>();
    }

    @Override
    public void acceptMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public void completeMissions() {
        this.completedMissions.addAll(this.missions);

        for (Mission mission : missions) {
            this.rating += mission.getRating();
            earnBounty(mission.getBounty());
        }

        this.missions.clear();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    protected abstract void earnBounty(Double bounty);
}
