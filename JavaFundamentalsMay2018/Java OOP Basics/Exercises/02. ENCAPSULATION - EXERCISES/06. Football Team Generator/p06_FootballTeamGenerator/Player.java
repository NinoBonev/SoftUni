package p06_FootballTeamGenerator;

/**
 * Created by Nino Bonev - 22.6.2018 г., 0:37
 */
public class Player {
    private static final String INVALID_NAME = "A name should not be empty.";

    private String name;
    private double endurance;
    private double sprint;
    private double dribble;
    private double passing;
    private double shooting;
    private double skills;

    public Player(String name, double endurance, double sprint, double dribble, double passing, double shooting) {
        this.setName(name);
        this.setEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
        this.setSkills();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    private void setEndurance(double endurance) {
        if (endurance > 100 || endurance < 0){
            throw new IllegalArgumentException("Endurance should be between 0 and 100.");
        }
        this.endurance = endurance;
    }

    private void setSprint(double sprint) {
        if (sprint > 100 || sprint < 0){
            throw new IllegalArgumentException("Sprint should be between 0 and 100.");
        }
        this.sprint = sprint;
    }

    private void setDribble(double dribble) {
        if (dribble > 100 || dribble < 0){
            throw new IllegalArgumentException("Dribble should be between 0 and 100.");
        }
        this.dribble = dribble;
    }

    private void setPassing(double passing) {
        if (passing > 100 || passing < 0){
            throw new IllegalArgumentException("Passing should be between 0 and 100.");
        }
        this.passing = passing;
    }

    private void setShooting(double shooting) {
        if (shooting > 100 || shooting < 0){
            throw new IllegalArgumentException("Shooting should be between 0 and 100.");
        }
        this.shooting = shooting;
    }

    public void setSkills() {
        this.skills = (this.dribble + this.endurance + this.passing + this.shooting + this.sprint) / 5;
    }

    public double getPlayerSkills(){
        return this.skills;
    }
}
