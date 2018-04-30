import javafx.util.Pair;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Snowwhite {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<Pair<String, String>, Integer> dwarfs = new LinkedHashMap<>(); //<<dwarfName, dwarfHatColor>, dwarfPhysics>
        Map<String, Integer> hatColorCount = new HashMap<>();

        String line;
        while (!"Once upon a time".equals(line = console.readLine())) {
            String dwarfName = line.split(" <:> ")[0];
            String dwarfHatColor = line.split(" <:> ")[1];
            Integer dwarfPhysics = Integer.parseInt(line.split(" <:> ")[2]);

            Pair<String, String> thisDwarf = new Pair<>(dwarfName, dwarfHatColor);

            if (!dwarfs.containsKey(thisDwarf)) {
                dwarfs.putIfAbsent(thisDwarf, dwarfPhysics);
                hatColorCount.putIfAbsent(dwarfHatColor, 0);
                hatColorCount.replace(dwarfHatColor, hatColorCount.get(dwarfHatColor) + 1);
            }

            if (dwarfs.get(thisDwarf) < dwarfPhysics) {
                dwarfs.replace(thisDwarf, dwarfPhysics);
            }
        }

        dwarfs.entrySet().stream().sorted((a, b) -> {
            int result = b.getValue().compareTo(a.getValue());

            if (result == 0) {
                result = Integer.compare(
                        hatColorCount.get(b.getKey().getValue()),
                        hatColorCount.get(a.getKey().getValue()));
            }

            return result;
        })
                .forEachOrdered(x -> System.out.printf("(%s) %s <-> %d%n"
                        , x.getKey().getValue()
                        , x.getKey().getKey()
                        , x.getValue()));
    }
}
