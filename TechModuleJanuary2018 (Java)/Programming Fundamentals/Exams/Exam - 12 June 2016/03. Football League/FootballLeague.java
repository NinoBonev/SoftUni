import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FootballLeague {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, String> teams = new TreeMap<>();

        String key = console.readLine();

        String line;
        while (!"final".equals(line = console.readLine()))
        {
            String teamA = line.split(" ")[0].replace(key, "%key%").toUpperCase();
            String finalTeamA = "";
            String teamB = line.split(" ")[1].replace(key, "%key%").toUpperCase();
            String finalTeamB = "";
            String score = line.split(" ")[2];
            Long scoreA = Long.parseLong(score.split(":")[0]);
            Long scoreB = Long.parseLong(score.split(":")[1]);

            Pattern pattern = Pattern.compile("(\\%KEY\\%)+(?<team>[^\\%]*)(\\%KEY\\%)+");
            Matcher matcherTeamA = pattern.matcher(teamA);
            Matcher matcherTeamB = pattern.matcher(teamB);


            while (matcherTeamA.find())
            {
                StringBuilder thisTeam = new StringBuilder();
                for (int i = matcherTeamA.group("team").length() - 1; i >= 0; i--) {
                    thisTeam.append(matcherTeamA.group("team").charAt(i));
                }
                finalTeamA = thisTeam.toString();

                teams.putIfAbsent(finalTeamA, "0 0");
            }
            while (matcherTeamB.find())
            {
                StringBuilder thisTeam = new StringBuilder();
                for (int i = matcherTeamB.group("team").length() - 1; i >= 0; i--) {
                    thisTeam.append(matcherTeamB.group("team").charAt(i));
                }
                finalTeamB = thisTeam.toString();

                teams.putIfAbsent(finalTeamB, "0 0");
            }
            if (scoreA > scoreB){
                Integer newPointsA = Integer.parseInt(teams.get(finalTeamA).split(" ")[0]) + 3;
                Long newGoalsA = Long.parseLong(teams.get(finalTeamA).split(" ")[1]) + scoreA;
                Integer newPointsB = Integer.parseInt(teams.get(finalTeamB).split(" ")[0]);
                Long newGoalsB = Long.parseLong(teams.get(finalTeamB).split(" ")[1]) + scoreB;

                teams.replace(finalTeamA, newPointsA + " " + newGoalsA);
                teams.replace(finalTeamB, newPointsB + " " + newGoalsB);

            } else if (scoreA == scoreB){
                Integer newPointsA = Integer.parseInt(teams.get(finalTeamA).split(" ")[0]) + 1;
                Integer newPointsB = Integer.parseInt(teams.get(finalTeamB).split(" ")[0]) + 1;
                Long newGoalsA = Long.parseLong(teams.get(finalTeamA).split(" ")[1]) + scoreA;
                Long newGoalsB = Long.parseLong(teams.get(finalTeamB).split(" ")[1]) + scoreB;

                teams.replace(finalTeamA, newPointsA + " " + newGoalsA);
                teams.replace(finalTeamB, newPointsB + " " + newGoalsB);
            } else if (scoreA < scoreB){
                Integer newPointsA = Integer.parseInt(teams.get(finalTeamA).split(" ")[0]);
                Integer newPointsB = Integer.parseInt(teams.get(finalTeamB).split(" ")[0]) + 3;
                Long newGoalsA = Long.parseLong(teams.get(finalTeamA).split(" ")[1]) + scoreA;
                Long newGoalsB = Long.parseLong(teams.get(finalTeamB).split(" ")[1]) + scoreB;

                teams.replace(finalTeamA, newPointsA + " " + newGoalsA);
                teams.replace(finalTeamB, newPointsB + " " + newGoalsB);
            }
        }

        final int[] position = {1};

        System.out.printf("League standings:%n");
        teams.entrySet().stream().sorted((a, b) -> {
            int result = Long.compare(Long.parseLong(b.getValue().split(" ")[0]),
                    Long.parseLong(a.getValue().split(" ")[0]));

            return result;
        }).forEach(x -> {
            System.out.printf("%d. %s %s%n",position[0], x.getKey(), x.getValue().split(" ")[0]);
            position[0]++;
        });
        System.out.printf("Top 3 scored goals:%n");
        teams.entrySet().stream().sorted((a, b) -> {
            int result = Long.compare(Long.parseLong(b.getValue().split(" ")[1]),
                    Long.parseLong(a.getValue().split(" ")[1]));

            return result;
        }).limit(3).forEach(x -> {
            System.out.printf("- %s -> %s%n", x.getKey(), x.getValue().split(" ")[1]);
        });
    }
}
