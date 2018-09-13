import factories.HeroFactory;
import interfaces.IHeroFactory;
import interfaces.InputReader;
import interfaces.OutputWriter;
import io.ConsoleReader;
import io.ConsoleWriter;
import manager.Engine;
import manager.ManagerImpl;


/**
 * Created by Nino Bonev - 29.8.2018 г., 8:43
 */
public class Main {
    public static void main(String[] args) {

        OutputWriter outputWriter = new ConsoleWriter();
        InputReader inputReader = new ConsoleReader();

        IHeroFactory heroFactory = new HeroFactory();
        ManagerImpl manager = new ManagerImpl(heroFactory);
        Engine engine = new Engine(outputWriter, inputReader, manager);

        engine.run();

    }
}
