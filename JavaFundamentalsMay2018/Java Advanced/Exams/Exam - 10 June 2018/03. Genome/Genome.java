import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Nino Bonev - 22.6.2018 г., 23:43
 */
public class Genome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> organisms = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("(?<name>[!@#$?a-z]+)=(?<length>\\d+)--(?<genes>\\d+)<<(?<organism>[a-z]+)");
        String line;
        while (!"Stop!".equals(line = scanner.nextLine())){
            Matcher matcher = pattern.matcher(line);
            while (matcher.find()){
                String name = matcher.group("name");
                Integer nameLength = Integer.parseInt(matcher.group("length"));
                Integer genesCount = Integer.parseInt(matcher.group("genes"));
                String organism = matcher.group("organism");

                name = name.replaceAll("[!@#$?]", "");
                if (name.length() == nameLength){
                    organisms.putIfAbsent(organism, 0);
                    organisms.replace(organism, organisms.get(organism) + genesCount);
                }
            }
        }

        organisms.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(x -> {
                    System.out.printf("%s has genome size of %d%n", x.getKey(), x.getValue());
                });
    }
}
