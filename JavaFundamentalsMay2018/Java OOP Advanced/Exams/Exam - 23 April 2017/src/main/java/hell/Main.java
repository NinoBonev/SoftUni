package hell;

import hell.factories.*;
import hell.interfaces.*;
import hell.io.ConsoleReader;
import hell.io.ConsoleWriter;
import hell.manager.Engine;
import hell.manager.ManagerImpl;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        InputReader inputReader = new ConsoleReader(bufferedReader);
        OutputWriter outputWriter = new ConsoleWriter();
        HeroFactory heroFactoryImpl = new HeroFactoryImpl();
        CommonItemFactory commonItemFactoryImpl = new CommonItemFactoryImpl();
        RecipeItemFactory recipeItemFactoryImpl = new RecipeItemFactoryImpl();

        Manager managerImpl = new ManagerImpl(heroFactoryImpl, commonItemFactoryImpl, recipeItemFactoryImpl);
        Engine engine = new Engine(outputWriter, inputReader, managerImpl);

        engine.run();

    }
}