package p09_Google;

import java.text.DecimalFormatSymbols;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 19.6.2018 г., 9:58
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new LinkedList<>();

        String line;
        while (!"End".equals(line = scanner.nextLine())){
            String[] personData = line.split(" ");
            String name = personData[0];
            if (people.stream().noneMatch(x -> x.getName().equals(name))){
                Person person = new Person(name);
                people.add(person);
            }

            switch (personData[1]){
                case "company":
                    String companyName = personData[2];
                    String department = personData[3];
                    double salary = Double.parseDouble(personData[4]);
                    people.stream().filter(x -> x.getName().equals(name)).forEach(y -> y.setCompany(companyName, department, salary));
                    break;
                case "pokemon" :
                    String pokemonName = personData[2];
                    String pokemonType = personData[3];
                    people.stream().filter(x -> x.getName().equals(name)).forEach(y -> y.addPokemons(pokemonName, pokemonType));
                    break;
                case "parents" :
                    String parentName = personData[2];
                    String parentBirthday = personData[3];
                    people.stream().filter(x -> x.getName().equals(name)).forEach(y -> y.addParents(parentName, parentBirthday));
                    break;
                case "children" :
                    String childName = personData[2];
                    String childBirthday = personData[3];
                    people.stream().filter(x -> x.getName().equals(name)).forEach(y -> y.addChildren(childName, childBirthday));
                    break;
                case "car" :
                    String carModel = personData[2];
                    Integer carSpeed = Integer.parseInt(personData[3]);
                    people.stream().filter(x -> x.getName().equals(name)).forEach(y -> y.setCar(carModel, carSpeed));
                    break;
            }
        }

        String printName = scanner.nextLine();
        people.stream().filter(x -> x.getName().equals(printName)).forEach(System.out::println);
    }
}
