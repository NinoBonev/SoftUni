package hell;

import hell.factories.*;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.io.ConsoleReader;
import hell.io.ConsoleWriter;
import hell.manager.Engine;
import hell.manager.Manager;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        InputReader inputReader = new ConsoleReader(bufferedReader);
        OutputWriter outputWriter = new ConsoleWriter();
        HeroFactory heroFactory = new HeroFactory();
        RecipeItemFactory recipeItemFactory = new RecipeItemFactory();
        CommonItemFactory commonItemFactory = new CommonItemFactory();
        HeroesRepository heroesRepository = new HeroesRepository();

        Manager manager = new Manager(heroesRepository, commonItemFactory, recipeItemFactory, heroFactory);
        Engine engine = new Engine(outputWriter, inputReader, manager);

        engine.run();

    }
}