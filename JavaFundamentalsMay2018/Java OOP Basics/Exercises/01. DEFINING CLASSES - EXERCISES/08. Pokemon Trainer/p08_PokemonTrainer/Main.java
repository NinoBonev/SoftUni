package p08_PokemonTrainer;

import java.util.*;

/**
 * Created by Nino Bonev - 17.6.2018 г., 10:17
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Trainer> trainerList = new LinkedList<>();

        String line;
        while (!"Tournament".equals(line = scanner.nextLine())) {
            String[] input = line.split(" ");
            String trainer = input[0];
            String pokemon = input[1];
            String element = input[2];
            Integer health = Integer.parseInt(input[3]);

            if (trainerList.stream().noneMatch(x -> x.getName().equals(trainer))) {
                Trainer trainer1 = new Trainer(trainer);
                trainerList.add(trainer1);
            }
            Pokemon pokemon1 = new Pokemon(pokemon, element, health);
            trainerList.stream().filter(x -> x.getName().equals(trainer)).forEach(y -> y.getPokemons().add(pokemon1));
        }

        String command;

        while (!"End".equals(command = scanner.nextLine())) {
            switch (command) {
                case "Fire":
                    for (Trainer trainer :
                            trainerList) {
                        if (trainer.getPokemons().stream().anyMatch(x -> x.getElement().equals("Fire"))) {
                            trainer.setBadges(trainer.getBadges() + 1);
                        } else {
                            for (Pokemon pokemon :
                                    trainer.getPokemons()) {
                                pokemon.takeHealth(10);
                            }
                        }
                    }
                    break;
                case "Water":
                    for (Trainer trainer :
                            trainerList) {
                        if (trainer.getPokemons().stream().anyMatch(x -> x.getElement().equals("Water"))) {
                            trainer.setBadges(trainer.getBadges() + 1);
                        } else {
                            for (Pokemon pokemon :
                                    trainer.getPokemons()) {
                                pokemon.takeHealth(10);
                            }
                        }
                    }
                    break;
                case "Electricity":
                    for (Trainer trainer :
                            trainerList) {
                        if (trainer.getPokemons().stream().anyMatch(x -> x.getElement().equals("Electricity"))) {
                            trainer.setBadges(trainer.getBadges() + 1);
                        } else {
                            for (Pokemon pokemon :
                                    trainer.getPokemons()) {
                                pokemon.takeHealth(10);
                            }
                        }
                    }
                    break;
            }
        }

        trainerList.stream().sorted((a, b) -> b.getBadges().compareTo(a.getBadges())).forEach(x -> System.out.printf("%s %d %d%n",
                x.getName(),
                x.getBadges(),
                x.getPokemons().stream().filter(p -> p.getHealth() > 0).count()));
    }
}
