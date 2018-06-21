package p04_ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 21.6.2018 г., 16:07
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new LinkedHashMap<>();

        List<String> _people = Arrays.stream(scanner.nextLine().split(";")).collect(Collectors.toList());
        _people.forEach(x -> {
            String[] personData = x.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);
            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException exp){
                System.out.println(exp.getMessage());
            }
        });
        List<String> _products = Arrays.stream(scanner.nextLine().split(";")).collect(Collectors.toList());
        _products.forEach(x -> {
            String[] productData = x.split("=");
            String name = productData[0];
            double cost = Double.parseDouble(productData[1]);
            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            } catch (IllegalArgumentException exp){
                System.out.println(exp.getMessage());
            }
        });

        String line;
        while (!"END".equals(line = scanner.nextLine())) {
            String name = line.split("\\s+")[0];
            String product = line.split("\\s+")[1];

            if (people.containsKey(name) && products.containsKey(product)){
                people.get(name).buyProduct(products.get(product));
            }
        }

        people.entrySet().forEach(x -> System.out.println(x.getValue()));
    }
}
