import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Nino Bonev - 27.6.2018 г., 19:59
 */
public class DHARMA_Sonar_Fence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> integers = new ArrayList<>();
        List<String> switchedNums = new ArrayList<>();
        String line;
        while (!"Reprogram".equals(line = scanner.nextLine())){
            Integer num = Integer.parseInt(line);
            integers.add(num);
        }

        for (Integer num:
             integers) {
            StringBuilder newNum = new StringBuilder();
            String stringNum = Integer.toBinaryString(num);
            char[] fullNum = new char[32];
            Arrays.fill(fullNum, '0');
            for (int i = 0; i < stringNum.length(); i++) {
                fullNum[i + fullNum.length - stringNum.length()] = stringNum.charAt(i);
            }
            for (int i = 0; i < fullNum.length - 1; i++) {
                if (fullNum[i] == fullNum[i + 1]) {
                    if (fullNum[i] == '0') {
                        fullNum[i] = '1';
                        fullNum[i + 1] = '1';
                    } else {
                        fullNum[i] = '0';
                        fullNum[i + 1] = '0';
                    }
                    i++;
                }
            }

            newNum.append(Long.parseLong(new String(fullNum), 2));
            switchedNums.add(newNum.toString());
        }

        switchedNums.forEach(System.out::println);
        System.out.println(Integer.toBinaryString(63633148));
    }
}
