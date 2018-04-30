import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class RoliTheCoder {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, String> events = new TreeMap<>();
        Map<String, List<String>> result = new TreeMap<>();

        while (true)
        {
            String line = console.readLine();
            if (line.equals("Time for Code"))
            {
                break;
            }
            else
            {
                Pattern eventPattern = Pattern.compile("^(?<id>\\d+)\\s*#(?<eventName>\\w+)\\s*(?<participants>(?:@[a-zA-Z\\d'-]+\\s*)*)$");
                Matcher eventMatcher = eventPattern.matcher(line);

                while (eventMatcher.find()) {

                    int eventNumber = Integer.parseInt(eventMatcher.group("id"));
                    String eventName = eventMatcher.group("eventName");

                    if (!events.keySet().contains(eventNumber))
                    {
                        events.put(eventNumber, eventName);
                        result.put(eventName, new ArrayList<>());

                    } else if (events.containsKey(eventNumber) && !events.get(eventNumber).equals(eventName)) {
                        continue;
                    }

                    String[] guestName = Arrays.stream(eventMatcher.group("participants")
                            .split("\\s+"))
                            .filter(e -> !e.equals(""))
                            .toArray(w -> new String[w]);

                    for (int i = 0; i < guestName.length; i++) {
                        if (events.get(eventNumber).equals(eventName)) {
                            if (!result.get(eventName).contains(guestName[i])) {
                                result.get(eventName).add(guestName[i]);
                            }
                        }
                    }
                }
            }
        }


        result.entrySet().stream().sorted((x, y) -> Integer.compare(
                y.getValue().size(), x.getValue().size()
        )).forEachOrdered(z -> {
            Collections.sort(z.getValue(), String.CASE_INSENSITIVE_ORDER);
            System.out.printf("%s - %d%n", z.getKey(), z.getValue().size());
            for (String name:
                    z.getValue()) {
                System.out.printf("%s%n", name);
            };
        });

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String regex = "^(?<id>\\d+)\\s*#(?<eventName>\\w+)\\s*(?<participants>(?:@[a-zA-Z\\d'-]+\\s*)*)$";
//        Pattern pattern = Pattern.compile(regex);
//        LinkedHashMap<String, LinkedHashSet<String>> eventData = new LinkedHashMap<>();
//        LinkedHashMap<String, String> idData = new LinkedHashMap<>();
//
//        String input = reader.readLine();
//        while (!"Time for Code".equals(input)) {
//            Matcher matcher = pattern.matcher(input);
//
//            if (matcher.find()) {
//                String id = matcher.group("id");
//                String eventName = matcher.group("eventName");
//                LinkedHashSet<String> people = Arrays.stream(matcher.group("participants").trim().split("\\s+"))
//                        .filter(e -> !e.equals(""))
//                        .collect(Collectors.toCollection(LinkedHashSet::new));
//
//                if (idData.containsKey(id) && !idData.get(id).equals(eventName)) {
//                    input = reader.readLine();
//                    continue;
//                } else {
//                    idData.put(id, eventName);
//                }
//
//                eventData.putIfAbsent(eventName, new LinkedHashSet<>());
//                eventData.get(eventName).addAll(people);
//            }
//            input = reader.readLine();
//        }
//
//        Comparator<String> lowerBeforeUpperCaseSort = new Comparator<String>() {
//            Collator myCollator = Collator.getInstance();
//
//            @Override
//            public int compare(String o1, String o2) {
//                return myCollator.compare(o1, o2);
//            }
//        };
//
//
//        eventData.entrySet().stream()
//                .sorted((a, b) -> {
//                    int index = Integer.compare(b.getValue().size(), a.getValue().size());
//                    if (index == 0) {
//                        index = lowerBeforeUpperCaseSort.compare(a.getKey(),b.getKey());
//                    }
//                    return index;
//                })
//                .forEach(event -> {
//                    System.out.println(String.format("%s - %d", event.getKey(), event.getValue().size()));
//                    event.getValue().stream()
//                            .sorted(lowerBeforeUpperCaseSort)
//                            .forEach(s -> {
//                                System.out.println(String.format("%s", s));
//                            });
//                });
    }
}