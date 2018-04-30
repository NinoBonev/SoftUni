import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class AnonymousCache {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, LinkedHashMap<String, Long>> result = new LinkedHashMap<>();
        Map<String, LinkedHashMap<String, Long>> cashe = new LinkedHashMap<>();
        Map<String, Long> totalValue = new LinkedHashMap<>();
        Map<String, Long> totalValueFiltered = new LinkedHashMap<>();

        while (true) {
            String line = console.readLine();

            if (line.equals("thetinggoesskrra")) {
                break;
            } else {
                String[] data = line.replace("->", "").replace("|", "").split("\\s+");

                if (data.length == 1) {
                    if (!result.keySet().contains(data[0]) && !cashe.keySet().contains(data[0])) {
                        String dataSet = data[0];
                        result.put(dataSet, new LinkedHashMap<>());
                        totalValue.put(data[0], 0L);
                    } else if (cashe.keySet().contains(data[0])) {
                        result.put(data[0], new LinkedHashMap<>());
                        result.get(data[0]).putAll(cashe.get(data[0]));
                    }

                } else if (data.length > 1) {
                    String dataSet = data[2];
                    String dataKey = data[0];
                    Long dataSize = Long.parseLong(data[1]);

                    if (result.keySet().contains(dataSet)) {
                        result.get(dataSet).put(dataKey, dataSize);

                        Long newTotalValue = totalValue.get(dataSet) + dataSize;
                        totalValue.replace(dataSet, newTotalValue);
                    } else {
                        if (!cashe.keySet().contains(dataSet)) {
                            cashe.put(dataSet, new LinkedHashMap<>());
                            cashe.get(dataSet).put(dataKey, dataSize);

                            totalValue.put(dataSet, dataSize);
                        } else {
                            cashe.get(dataSet).put(dataKey, dataSize);

                            Long newTotalValue = totalValue.get(dataSet) + dataSize;
                            totalValue.replace(dataSet, newTotalValue);
                        }
                    }
                }
            }
        }

        for (String str :
                result.keySet()) {

            if (totalValue.containsKey(str)) {
                totalValueFiltered.put(str, totalValue.get(str));
            }
        }

        Map.Entry<String, Long> max
                = totalValueFiltered
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue(Long::compareTo))
                .get();

        if (result.size() > 1) {
            System.out.printf("Data Set: %s, Total Size: %d%n", max.getKey(), max.getValue());
            result.get(max.getKey()).keySet().forEach(x -> System.out.printf("$.%s%n", x));
        }


//        result.entrySet().stream().sorted((e1, e2) -> {
//            int value = Long.compare(e2.getValue()
//                            .values()
//                            .stream()
//                            .collect(Collectors.summarizingLong(Long::valueOf))
//                            .getSum(),
//                    e1.getValue()
//                            .values()
//                            .stream()
//                            .collect(Collectors.summarizingLong(Long::valueOf))
//                            .getSum());
//
//            return value;
//        }).limit(1).forEach(ds -> {
//            long size = ds.getValue()
//                    .values()
//                    .stream()
//                    .collect(Collectors.summarizingLong(Long::valueOf))
//                    .getSum();
//
//            System.out.printf("Data Set: %s, Total Size: %d%n", ds.getKey(), size);
//            ds.getValue().entrySet().forEach(dk -> System.out.printf("$.%s%n", dk.getKey()));
//        });
    }
}
