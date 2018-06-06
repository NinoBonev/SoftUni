import java.util.Scanner;

/**
 * Created by Nino Bonev - 2.6.2018 г., 19:08
 */
public class CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine().toLowerCase();
        String substring = scanner.nextLine().toLowerCase();

        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = input.indexOf(substring, lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += 1;
            }
        }
        System.out.println(count);
    }
}
