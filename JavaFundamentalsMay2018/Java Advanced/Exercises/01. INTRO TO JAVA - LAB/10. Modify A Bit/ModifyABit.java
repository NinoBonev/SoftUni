import java.util.Scanner;

public class ModifyABit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int index = scanner.nextInt();
        int value = scanner.nextInt();

        if (value == 0){
            int mask = ~(1 << index);
            int bit = num & mask;

            System.out.println(bit);
        } else if (value == 1){
            int mask = 1 << index;
            int bit = num | mask;

            System.out.println(bit);
        }
    }
}
