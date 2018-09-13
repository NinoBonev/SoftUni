package onehitdungeon;

import onehitdungeon.core.HeroTrainerImpl;
import onehitdungeon.factories.HeroFactoryImpl;
import onehitdungeon.interfaces.*;
import onehitdungeon.io.ConsoleReader;
import onehitdungeon.io.ConsoleWriter;
import onehitdungeon.manager.Engine;
import onehitdungeon.manager.ManagerImpl;
import onehitdungeon.myinterfaces.HeroFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Nino Bonev - 31.8.2018 г., 9:05
 */
public class Main {
    public static void main(String[] args) {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        OutputWriter outputWriter = new ConsoleWriter();
        InputReader inputReader = new ConsoleReader(bufferedReader);

        HeroTrainer heroTrainer = new HeroTrainerImpl();
        HeroFactory heroFactory = new HeroFactoryImpl();
        DungeonManager dungeonManager = new ManagerImpl(heroTrainer, heroFactory);

        Engine engine = new Engine(outputWriter, inputReader, dungeonManager);
        engine.run();

    }
}
