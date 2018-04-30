import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class PokemonEvolution {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Map<String, ArrayList<String>> pokemons = new LinkedHashMap<>();

        String line;
        while (!"wubbalubbadubdub".equals(line = console.readLine()))
        {
            String[] command = line.split(" -> ");
            if (command.length > 1)
            {
                String pokemon = command[0];
                String evolution = command[1] + " <-> " + command[2];
                pokemons.putIfAbsent(pokemon, new ArrayList<>());
                pokemons.get(pokemon).add(evolution);


            } else
            {
                if (pokemons.keySet().contains(command[0]))
                {
                    ArrayList<String> thisPokemon = pokemons.get(command[0]);
                    System.out.printf("# %s%n", command[0]);
                    thisPokemon.forEach(System.out::println);
                }
            }
        }

        pokemons.entrySet().stream().forEach(x ->
        {   System.out.printf("# %s%n", x.getKey());
            x.getValue().stream().sorted((a, b) -> {
                int result = Integer.compare(
                        Integer.parseInt(b.split(" <-> ")[1]),
                        Integer.parseInt(a.split(" <-> ")[1]));

                return result;
            }).forEach(System.out::println);
        });
    }
}