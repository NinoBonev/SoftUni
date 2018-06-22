package p06_FootballTeamGenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nino Bonev - 22.6.2018 г., 0:46
 */
public class Team {
    private String name;
    private Map<String, Player> players;
    private double teamRating;

    public Team(String name) {
        this.setName(name);
        this.players = new HashMap<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, Player> getPlayers() {
        return players;
    }

    public void addPlayer(String name, Player player){
            this.getPlayers().put(name, player);
    }

    public void removePlayer(String player){
        if (!this.getPlayers().containsKey(player)){
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", player, this.getName()));
        }
        this.getPlayers().remove(player);
    }

    public double getTeamRating(){
        return this.teamRating;
    }

    public void setTeamRating() {
        if (this.getPlayers().isEmpty()){
            this.teamRating = 0;
        }
        if (getPlayers().size() > 0){
            for (Player player:
                    this.getPlayers().values()) {
                this.teamRating += player.getPlayerSkills();
            }
            this.teamRating /= this.getPlayers().size();
        }
    }
}
