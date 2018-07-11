package p02_MultilevelInheritance;

/**
 * Created by Nino Bonev - 23.6.2018 г., 10:30
 */
public class Main {
    public static void main(String[] args) {

        Dog dog = new Dog();
        dog.eat();
        dog.bark();

        Cat cat = new Cat();
        cat.eat();
        cat.meow();
    }
}
