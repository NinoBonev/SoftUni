import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HornetArmada {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Integer dataSize = Integer.parseInt(console.readLine());

        LinkedHashMap<String, Long> legionActivity = new LinkedHashMap<>();
        LinkedHashMap<String, LinkedHashMap<String, Long>> data = new LinkedHashMap<>();

        for (int i = 0; i < dataSize; i++) {

            String line = console.readLine();

            Pattern pattern = Pattern.compile("(?<activity>[0-9]+)\\s=\\s(?<legion>[^=->:\\s]+)\\s->\\s(?<soldier>[^=->:\\s]+):(?<count>[0-9]+)");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {

                Long activity = Long.parseLong(matcher.group("activity"));
                String legion = matcher.group("legion");
                String soldier = matcher.group("soldier");
                Integer count = Integer.parseInt(matcher.group("count"));

                data.putIfAbsent(legion, new LinkedHashMap<>());
                data.get(legion).putIfAbsent(soldier, 0L);
                Long currentSoldierCount = data.get(legion).get(soldier);
                data.get(legion).replace(soldier, currentSoldierCount + count);

                legionActivity.putIfAbsent(legion, activity);
                boolean isHigher = false;

                if (activity > legionActivity.get(legion)) {
                    isHigher = true;
                }
                if (isHigher) {
                    legionActivity.replace(legion, activity);
                }
            }
        }

        String command = console.readLine();

        if (command.contains("\\")) {

            Integer activity = Integer.parseInt(command.split("\\\\")[0]);
            String soldier = command.split("\\\\")[1];

            LinkedHashMap<String, Long> filteredLegions = new LinkedHashMap<>();

            legionActivity.entrySet()
                    .stream()
                    .filter(l -> l.getValue() < activity)
                    .forEach(l -> filteredLegions.put(l.getKey(), 0L));

            for (String legionName : data.keySet()) {
                if (!filteredLegions.containsKey(legionName))
                    continue;

                data.get(legionName)
                        .entrySet()
                        .stream()
                        .forEach(st -> {
                            if (st.getKey().equals(soldier)) {
                                long count = st.getValue();
                                filteredLegions.put(legionName, count);
                            }
                        });
            }

            filteredLegions.entrySet()
                    .stream()
                    .filter(l -> l.getValue() > 0)
                    .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                    .forEach(l -> System.out.printf("%s -> %d%n", l.getKey(), l.getValue()));
        } else {
            LinkedHashMap<String, Long> result = new LinkedHashMap<>();

            for (String legionName : data.keySet()) {
                data.get(legionName)
                        .forEach((key, value) -> {
                            if (key.equals(command))
                                result.put(legionName, -1L);
                        });
            }

            legionActivity.entrySet()
                    .stream()
                    .filter(l -> result.containsKey(l.getKey()))
                    .forEach(l -> result.put(l.getKey(), l.getValue()));

            result.entrySet()
                    .stream()
                    .filter(l -> l.getValue() > -1)
                    .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue()))
                    .forEach(l -> System.out.printf("%d : %s%n", l.getValue(), l.getKey()));
        }
    }
}
