import java.util.Scanner;

public class ReadInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstName = scanner.next("\\w+");
        String lastName = scanner.next("\\w+");
        int firstInt = scanner.nextInt();
        int secondInt = scanner.nextInt();
        int thirdInt = scanner.nextInt();
        int sum = firstInt + secondInt + thirdInt;
        scanner.nextLine();
        String anyWord = scanner.nextLine();

        System.out.println(firstName + " " + lastName + " " + anyWord + " " + sum);
    }
}
