package p01_SingleInheritance;

import java.util.Scanner;

/**
 * Created by Nino Bonev - 23.6.2018 г., 10:25
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Dog dog = new Dog();
        dog.eat();
        dog.bark();
    }
}
