import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class MOBAChallenger {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Integer>> players = new LinkedHashMap<>(); //<player, <position, skill>>

        String line;
        while (!"Season end".equals(line = console.readLine()))
        {
            String [] input = line.split(" ");
            if (input[1].equals("->"))
            {
                String player = input[0];
                String position = input[2];
                Integer skill = Integer.parseInt(input[4]);

                players.putIfAbsent(player, new LinkedHashMap<>());
                players.get(player).putIfAbsent(position, skill);
                Integer currentSkill = players.get(player).get(position);
                if (currentSkill < skill)
                {
                    players.get(player).replace(position, skill);
                }

            } else if (input[1].equals("vs"))
            {
                String player1 = input[0];
                String player2 = input[2];

                if (players.containsKey(player1) && players.containsKey(player2))
                {
                    for (String position:
                            players.get(player1).keySet()) {
                        if (players.get(player2).containsKey(position))
                        {
                            Long player_1_Skill = players.get(player1).values().stream().mapToLong(Integer::intValue).sum();
                            Long player_2_Skill = players.get(player2).values().stream().mapToLong(Integer::intValue).sum();

                            if (player_1_Skill > player_2_Skill)
                            {
                                players.remove(player2);
                                break;
                            } else if (player_2_Skill > player_1_Skill)
                            {
                                players.remove(player1);
                                break;
                            }
                        }
                    }
                } else {
                    break;
                }
            }
        }

        players.entrySet().stream().sorted((x, y) -> {
            int result = Long.compare(y.getValue().values().stream().mapToLong(Integer::intValue).sum(),
                    x.getValue().values().stream().mapToLong(Integer::intValue).sum());

            if (result == 0)
            {
                result = x.getKey().compareTo(y.getKey());
            }

            return result;
        })
                .forEach(z -> {
                    System.out.printf("%s: %d skill%n", z.getKey(), z.getValue().values().stream().mapToLong(Integer::intValue).sum());
                    z.getValue().entrySet().stream()
                            .sorted((a, b) -> {
                                int result = Integer.compare(b.getValue(), a.getValue());

                                if (result == 0)
                                {
                                    result = a.getKey().compareTo(b.getKey());
                                }

                                return result;
                            })
                            .forEach(w -> System.out.printf("- %s <::> %d%n", w.getKey(), w.getValue()));
                });
    }
}
