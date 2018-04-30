import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class WormsWorldParty {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Map<String, Long>> worms = new LinkedHashMap<>(); //<teamName, <wormName, wormScore>>

        String line;
        while (!"quit".equals(line = console.readLine()))
        {
            String wormName = line.split(" -> ")[0];
            String teamName = line.split(" -> ")[1];
            Long wormScore = Long.parseLong(line.split(" -> ")[2]);
            boolean checkName = true;

            for (Map.Entry<String, Map<String, Long>> worm:
                    worms.entrySet()) {
                if (worm.getValue().containsKey(wormName))
                {
                    checkName = false;
                }
            }

            if (checkName)
            {
                worms.putIfAbsent(teamName, new LinkedHashMap<>());
                worms.get(teamName).put(wormName, wormScore);
            }
        }

        int[] number = new int[]{1};
        worms.entrySet().stream().sorted((a, b) -> {
            int result = Long.compare(b.getValue().values().stream().mapToLong(Long::valueOf).sum(),
                    a.getValue().values().stream().mapToLong(Long::valueOf).sum());

            if (result == 0)
            {
                result = Long.compare((long) b.getValue().values().stream().mapToLong(Long::valueOf).average().getAsDouble(),
                        (long) a.getValue().values().stream().mapToLong(Long::valueOf).average().getAsDouble());
            }

            return result;
        }).forEachOrdered(z -> {
            System.out.printf("%d. Team: %s - %d%n", number[0], z.getKey(), z.getValue().values().stream().mapToLong(Long::valueOf).sum());
            number[0]++;
            z.getValue().entrySet().stream().sorted((x, y) -> y.getValue().compareTo(x.getValue()))
                    .forEachOrdered(w -> System.out.printf("###%s : %d%n", w.getKey(), w.getValue()));
        });
    }
}