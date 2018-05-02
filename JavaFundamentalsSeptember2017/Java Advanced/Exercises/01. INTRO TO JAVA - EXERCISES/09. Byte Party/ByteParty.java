import java.util.Scanner;

/**
 * Created by Nino Bonev - 1.5.2018 г., 15:11
 */
public class ByteParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = scanner.nextInt();
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = scanner.nextInt();
        }

        String line;
        while (!"party over".equals(line = scanner.nextLine()))
        {
            //ToDo ...
        }
    }
}
