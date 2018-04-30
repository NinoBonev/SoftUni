import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class TseamAccount {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> games = Arrays.stream(console.readLine().split(" ")).collect(Collectors.toList());
        String line;
        while (!"Play!".equals(line = console.readLine())) {
            String command = line.split(" ")[0];
            String game = line.split(" ")[1];
            if ("Install".equals(command)) {
                if (!games.contains(game)) {
                    games.add(game);
                }
            } else if ("Uninstall".equals(command)) {
                if (games.contains(game)) {
                    games.remove(game);
                }
            } else if ("Update".equals(command)) {
                if (games.contains(game)) {
                    games.remove(game);
                    games.add(game);
                }
            } else if ("Expansion".equals(command)) {
                String expansion = game.split("-")[1];
                int index = 0;
                if (games.contains(game.split("-")[0])) {
                    for (int i = 0; i < games.size(); i++) {
                        if (games.get(i).equals(game.split("-")[0])) {
                            index = i;
                        }
                    }
                    games.add(index + 1, game.split("-")[0] + ":" + expansion);
                }
            }
        }

        games.forEach(x -> System.out.printf("%s ", x));
    }
}
