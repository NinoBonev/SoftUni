import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Trainlands {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        LinkedHashMap<String, LinkedHashMap<String, Long>> trains = new LinkedHashMap<>();

        String line;
        while (!"It's Training Men!".equals(line = console.readLine())) {

            if (line.contains(":")) {
                String trainName = line.split(" [->:]+ ")[0];
                String wagonName = line.split(" [->:]+ ")[1];
                Long wagonPower = Long.parseLong(line.split(" [->:]+ ")[2]);

                trains.putIfAbsent(trainName, new LinkedHashMap<>());
                trains.get(trainName).put(wagonName, wagonPower);
            } else if (line.contains("->")) {
                String trainName = line.split(" -> ")[0];
                String otherTrainName = line.split(" -> ")[1];

                trains.putIfAbsent(trainName, new LinkedHashMap<>());
                LinkedHashMap<String, Long> otherTrainWagons = trains.get(otherTrainName);
                trains.remove(otherTrainName);

                for (String key : otherTrainWagons.keySet()) {
                    Long value = otherTrainWagons.get(key);

                    trains.get(trainName).put(key, value);
                }
            } else if (line.contains("=")) {
                String trainName = line.split(" = ")[0];
                String otherTrainName = line.split(" = ")[1];

                LinkedHashMap<String, Long> otherTrainWagons = trains.get(otherTrainName);
                trains.putIfAbsent(trainName, new LinkedHashMap<>());
                trains.get(trainName).clear();

                for (String key : otherTrainWagons.keySet()) {
                    Long value = otherTrainWagons.get(key);

                    trains.get(trainName).put(key, value);}
            }
        }

        trains.entrySet().stream().sorted((x, y) -> {
            int result = Long.compare(y.getValue().values().stream().mapToLong(Long::longValue).sum(),
                    x.getValue().values().stream().mapToLong(Long::longValue).sum());

            if (result == 0)
            {
                result = Long.compare(y.getValue().values().size(),
                        x.getValue().values().size());
            }

            return result;
        })
                .forEach(z -> {
                    System.out.printf("Train: %s%n", z.getKey());
                    z.getValue().entrySet().stream()
                            .sorted((a, b) -> Long.compare(b.getValue(), a.getValue()))
                            .forEach(w -> System.out.printf("###%s - %d%n", w.getKey(), w.getValue()));
                });

//        Map<String, Map<Long, String>> sortedByValueSum = trains.entrySet().stream()
//                .sorted((x, y) ->
//                        Long.compare(y.getValue().keySet().stream().reduce(0L ,(a, b) -> a + b),
//                                x.getValue().keySet().stream().reduce(0L, (t, r) -> t + r)))
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
//
//        System.out.println(sortedByValueSum);
//
//        sortedByValueSum.entrySet().stream().sorted((x, y) -> Integer.compare(y.getValue().size(), x.getValue().size())).forEach(z ->
//        {
//            System.out.printf("Train: %s%n", z.getKey());
//            z.getValue().entrySet().stream().forEach(w -> System.out.printf("###%s - %d%n", w.getValue(), w.getKey()));
//        });
    }
}