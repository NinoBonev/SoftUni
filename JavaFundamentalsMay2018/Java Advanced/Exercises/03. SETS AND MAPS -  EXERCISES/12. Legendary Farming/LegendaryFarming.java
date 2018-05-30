import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 29.5.2018 г., 9:44
 */
public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer shards = 0;
        Integer fragments = 0;
        Integer motes = 0;
        Map<String, Integer> items = new HashMap<>();
        items.put("fragments", 0);
        items.put("shards", 0);
        items.put("motes", 0);

        Map<String, Integer> junk = new HashMap<>();

        while (shards < 250 && fragments < 250 && motes < 250) {
            String[] data = scanner.nextLine().split(" ");
            for (int i = 0; i < data.length - 1; i += 2) {
                String material = data[i + 1].toLowerCase();
                Integer quantity = Integer.parseInt(data[i]);

                if (material.equals("shards")) {
                    shards += quantity;
                    items.replace(material, items.get(material) + quantity);
                    if (shards >= 250){
                        break;
                    }
                } else if (material.equals("fragments")) {
                    fragments += quantity;
                    items.replace(material, items.get(material) + quantity);
                    if (fragments >= 250){
                        break;
                    }
                } else if (material.equals("motes")) {
                    motes += quantity;
                    items.replace(material, items.get(material) + quantity);
                    if (motes >= 250){
                        break;
                    }
                } else {
                    junk.putIfAbsent(material, 0);
                    junk.replace(material, junk.get(material) + quantity);
                }
            }
        }


        if (shards >= 250) {
            System.out.printf("Shadowmourne obtained!%n");
            items.replace("shards", items.get("shards") - 250);
            items.entrySet().stream().sorted((a, b) -> {
                int result = Integer.compare(b.getValue(), a.getValue());

                if (result == 0) {
                    result = a.getKey().compareTo(b.getKey());
                }

                return result;

            }).forEach(c -> System.out.printf("%s: %d%n", c.getKey(), c.getValue()));

            junk.entrySet().stream()
                    .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                    .forEach(c -> System.out.printf("%s: %d%n", c.getKey(), c.getValue()));
        } else if (fragments >= 250) {
            System.out.printf("Valanyr obtained!%n");
            items.replace("fragments", items.get("fragments") - 250);
            items.entrySet().stream().sorted((a, b) -> {
                int result = Integer.compare(b.getValue(), a.getValue());

                if (result == 0) {
                    result = a.getKey().compareTo(b.getKey());
                }

                return result;

            }).forEach(c -> System.out.printf("%s: %d%n", c.getKey(), c.getValue()));

            junk.entrySet().stream()
                    .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                    .forEach(c -> System.out.printf("%s: %d%n", c.getKey(), c.getValue()));
        } else if (motes >= 250) {
            System.out.printf("Dragonwrath obtained!%n");
            items.replace("motes", items.get("motes") - 250);
            items.entrySet().stream().sorted((a, b) -> {
                int result = Integer.compare(b.getValue(), a.getValue());

                if (result == 0) {
                    result = a.getKey().compareTo(b.getKey());
                }

                return result;

            }).forEach(c -> System.out.printf("%s: %d%n", c.getKey(), c.getValue()));

            junk.entrySet().stream()
                    .sorted((a, b) -> a.getKey().compareTo(b.getKey()))
                    .forEach(c -> System.out.printf("%s: %d%n", c.getKey(), c.getValue()));
        }
    }
}
