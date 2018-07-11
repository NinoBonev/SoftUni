package p04_MordorsCrueltyPlan;

import java.util.Scanner;

/**
 * Created by Nino Bonev - 23.6.2018 г., 12:50
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String data = scanner.nextLine().toLowerCase();
        String[] foods = data.split(" ");
        Gandalf gandalf = new Gandalf(foods);
        System.out.println(gandalf.getHappiness());
        System.out.println(gandalf.getMood());
    }
}
