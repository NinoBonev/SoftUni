import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.*;
import java.util.stream.Collectors;


public class SoftUniKaraoke {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<String> participants = Arrays.stream(console.readLine().split(",\\s+")).collect(Collectors.toList());
        List<String> songs = Arrays.stream(console.readLine().split(",\\s+")).collect(Collectors.toList());

        Map<String, List<String>> awarded = new TreeMap<>();

        String line;
        while (!"dawn".equals(line = console.readLine()))
        {
            String participant = line.split(",\\s+")[0];
            String song = line.split(",\\s+")[1];
            String award = line.split(",\\s+")[2];

            if (participants.contains(participant) && songs.contains(song))
            {
                awarded.putIfAbsent(participant, new ArrayList<>());
                if (!awarded.get(participant).contains(award))
                {
                    awarded.get(participant).add(award);
                }
            }
        }

        awarded.entrySet().stream()
                .sorted((x, y) -> Integer.compare(y.getValue().size(), x.getValue().size()))
                .forEachOrdered(z -> {

                    System.out.printf("%s: %d awards%n", z.getKey(), z.getValue().size());
                    z.getValue().stream()
                            .sorted(Comparator.naturalOrder())
                            .forEach(w -> System.out.printf("--%s%n", w));

                });

        if (awarded.size() == 0)
        {
            System.out.println("No awards");
        }
    }
}
