package p08_Military_Elite;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Nino Bonev - 30.6.2018 г., 10:16
 */
public class Commando extends SpecialisedSoldier implements ICommando, IMission {
    private Set<Mission> missions;

    public Commando(String id, String firstName, String lastName, Double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new LinkedHashSet<>();
    }

    public void setMissions(Set<Mission> missions) {
        this.missions = missions;
    }

    @Override
    public Set<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public void addMission(Mission mission) {
        this.getMissions().add(mission);
    }

    @Override
    public void CompleteMission(String mission) {
        this.getMissions().stream().filter(x -> x.getCodeName().equals(mission)).forEach(y -> y.setState("Finished"));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s Salary: %.2f", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary())
                .replace(",", "."))
                .append(System.lineSeparator())
                .append("Corps: ").append(this.getCorps())
                .append(System.lineSeparator())
                .append("Missions:")
                .append(System.lineSeparator());
        if (!this.getMissions().isEmpty()) {
            for (Mission mission :
                    this.getMissions()) {
                sb.append(mission.toString()).append(System.lineSeparator());
            }
        }
        return sb.toString();
    }
}
