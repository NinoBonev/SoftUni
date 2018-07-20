package animals;


/**
 * Created by Nino Bonev - 18.7.2018 г., 21:27
 */
public class Dog extends Animal {
    private int commandsAmount;

    public Dog(String name, int age, int commandsAmount) {
        super(name, age);
        this.commandsAmount = commandsAmount;
    }

    public int getCommandsAmount() {
        return commandsAmount;
    }
}
