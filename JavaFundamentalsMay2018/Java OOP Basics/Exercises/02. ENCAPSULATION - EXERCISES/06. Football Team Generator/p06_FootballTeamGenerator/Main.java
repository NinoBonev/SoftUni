package p06_FootballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 22.6.2018 г., 0:35
 */
public class Main {

    private static final String INVALID_TEAM = "Team %s does not exist.";
    private static final String PRINT_RESULT = "%s - %.0f%n";


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Team> teams = new LinkedHashMap<>();

        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String[] command = line.split(";");
            String teamName = command[1];
            try {
                switch (command[0]) {
                    case "Team":
                        Team team = new Team(teamName);
                        teams.putIfAbsent(teamName, team);
                        break;
                    case "Add":
                        teamCheck(teamName, teams);
                        String playerName = command[2];
                        double endurance = Double.parseDouble(command[3]);
                        double sprint = Double.parseDouble(command[4]);
                        double dribble = Double.parseDouble(command[5]);
                        double passing = Double.parseDouble(command[6]);
                        double shooting = Double.parseDouble(command[7]);

                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        teams.get(teamName).addPlayer(playerName, player);
                        break;
                    case "Remove":
                        teamCheck(teamName, teams);
                        String player_Name = command[2];
                        teams.get(teamName).removePlayer(player_Name);
                        break;
                    case "Rating":
                        teamCheck(teamName, teams);
                        teams.get(teamName).setTeamRating();
                        double teamRating = teams.get(teamName).getTeamRating();
                        System.out.printf(PRINT_RESULT, teamName, teamRating);
                        break;
                }
            } catch (IllegalArgumentException exp) {
                System.out.println(exp.getMessage());
            }
        }
    }

    private static void teamCheck(String team, Map<String, Team> teams) {
        if (!teams.containsKey(team)) {
            throw new IllegalArgumentException(String.format(INVALID_TEAM, team));
        }
    }
}