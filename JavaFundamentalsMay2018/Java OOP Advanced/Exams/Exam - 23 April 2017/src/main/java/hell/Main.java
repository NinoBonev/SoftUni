package hell;

import hell.factories.CommonItemFactory;
import hell.factories.HeroFactory;
import hell.factories.RecipeItemFactory;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.io.ConsoleReader;
import hell.io.ConsoleWriter;
import hell.manager.Engine;
import hell.manager.Manager;

public class Main {
    public static void main(String[] args) {

        InputReader inputReader = new ConsoleReader();
        OutputWriter outputWriter = new ConsoleWriter();
        HeroFactory heroFactory = new HeroFactory();
        RecipeItemFactory recipeItemFactory = new RecipeItemFactory();
        CommonItemFactory commonItemFactory = new CommonItemFactory();

        Manager manager = new Manager(commonItemFactory, recipeItemFactory, heroFactory);
        Engine engine = new Engine(outputWriter, inputReader, manager);

        engine.run();

    }
}