import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ForceBook {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<String>> result = new TreeMap<>();


        while (true)
        {
            String line = console.readLine();
            if (line.equals("Lumpawaroo"))
            {
                break;
            }
            else
            {
                String stringPattern = "(.+)\\s+([(\\|)|(->)]+)\\s+(.+)";
                Pattern pattern = Pattern.compile(stringPattern);
                Matcher matcher = pattern.matcher(line);

                while (matcher.find())
                {
                    String seperator = matcher.group(2);

                    if (seperator.equals("|"))
                    {
                        String forceSide = matcher.group(1).trim();
                        String forceUser = matcher.group(3).trim();
                        boolean hasName = false;

                        for (Map.Entry<String, List<String>> entry:
                                result.entrySet()) {
                            if (entry.getValue().contains(forceUser))
                            {
                                hasName = true;
                            }
                        }

                        if (hasName)
                        {
                            continue;
                        }
                        else
                        {
                            result.putIfAbsent(forceSide, new ArrayList<>());
                            if (!result.get(forceSide).contains(forceUser))
                            {
                                result.get(forceSide).add(forceUser);
                            }
                        }
                    }

                    else if (seperator.equals("->"))
                    {
                        String forceSide = matcher.group(3).trim();
                        String forceUser = matcher.group(1).trim();

                        if (!result.keySet().contains(forceSide)) {
                            boolean hasName = false;

                            for (Map.Entry<String, List<String>> entry :
                                    result.entrySet()) {
                                if (entry.getValue().contains(forceUser)) {
                                    hasName = true;
                                    break;
                                }
                            }

                            if (hasName) {
                                continue;
                            } else {
                                result.put(forceSide, new ArrayList<>());
                                result.get(forceSide).add(forceUser);
                                System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                            }
                        }

                        else if (!result.get(forceSide).contains(forceUser))
                        {
                            Map<String, List<String>> temp = new TreeMap<>(result);

                            for (Map.Entry<String, List<String>> entry:
                                    temp.entrySet()) {
                                if (entry.getValue().contains(forceUser))
                                {
                                    temp.get(entry.getKey()).remove(forceUser);
                                }
                            }
                            result = temp;
                            result.get(forceSide).add(forceUser);
                            System.out.printf("%s joins the %s side!%n", forceUser, forceSide);
                        }
                    }
                }
            }
        }


        result.entrySet().stream()
                .sorted((x, y) -> Integer.compare(y.getValue().size(), x.getValue().size()))
                .forEachOrdered(z -> {

                    z.getValue().sort(Comparator.naturalOrder());
                    if (z.getValue().size() > 0)
                    {
                        System.out.printf("Side: %s, Members: %d%n", z.getKey(), z.getValue().size());
                        for (String forceUser:
                                z.getValue()) {
                            System.out.printf("! %s%n", forceUser);
                        }
                    }
                });
    }
}
//
//        result.entrySet()
//                .stream()
//                .filter(s -> s.getValue().size() > 0)
//                .sorted((s1, s2) -> {
//                    int res = Integer.compare(s2.getValue().size(), s1.getValue().size());
//
//                    if (res == 0) {
//                        res = s1.getKey().compareTo(s2.getKey());
//                    }
//
//                    return res;
//                })
//                .forEach(s -> {
//                    System.out.printf("Side: %s, Members: %d%n", s.getKey(), s.getValue().size());
//
//                    s.getValue()
//                            .stream()
//                            .sorted(String::compareTo)
//                            .forEach(m -> System.out.printf("! %s%n", m));
//                });
//
//
//    }
//}








