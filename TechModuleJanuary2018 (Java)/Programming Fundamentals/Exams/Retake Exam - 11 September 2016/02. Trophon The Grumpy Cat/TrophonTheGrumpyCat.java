import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TrophonTheGrumpyCat {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        String input = console.readLine();
        long[] arr = Arrays.stream(input.split(" ")).mapToLong(Long::parseLong).toArray();
        int entryPoint = Integer.parseInt(console.readLine());
        long compareValue = arr[entryPoint];
        long sumLeft = 0;
        long sumRight = 0;

        String typeItems = console.readLine();

        if (typeItems.equals("cheap")) {
            String typePrice = console.readLine();

            if (typePrice.equals("positive")) {
                for (int i = entryPoint - 1; i >= 0; i--) {
                    if (arr[i] < compareValue && arr[i] > 0) {
                        sumLeft += arr[i];
                    }
                }
                for (int j = entryPoint + 1; j <= arr.length - 1; j++) {
                    if (arr[j] < compareValue && arr[j] > 0) {
                        sumRight += arr[j];
                    }
                }
            } else if (typePrice.equals("negative")) {
                for (int i = entryPoint - 1; i >= 0; i--) {
                    if (arr[i] < compareValue && arr[i] < 0) {
                        sumLeft += arr[i];
                    }
                }
                for (int j = entryPoint + 1; j <= arr.length - 1; j++) {
                    if (arr[j] < compareValue && arr[j] < 0) {
                        sumRight += arr[j];
                    }
                }
            } else if (typePrice.equals("all")) {
                for (int i = entryPoint - 1; i >= 0; i--) {
                    if (arr[i] < compareValue) {
                        sumLeft += arr[i];
                    }
                }
                for (int j = entryPoint + 1; j <= arr.length - 1; j++) {
                    if (arr[j] < compareValue) {
                        sumRight += arr[j];
                    }
                }
            }
        } else if (typeItems.equals("expensive")) {
            String typePrice = console.readLine();

            if (typePrice.equals("positive")) {
                for (int i = entryPoint - 1; i >= 0; i--) {
                    if (arr[i] >= compareValue && arr[i] > 0) {
                        sumLeft += arr[i];
                    }
                }
                for (int j = entryPoint + 1; j <= arr.length - 1; j++) {
                    if (arr[j] >= compareValue && arr[j] > 0) {
                        sumRight += arr[j];
                    }
                }
            } else if (typePrice.equals("negative")) {
                for (int i = entryPoint - 1; i >= 0; i--) {
                    if (arr[i] >= compareValue && arr[i] < 0) {
                        sumLeft += arr[i];
                    }
                }
                for (int j = entryPoint + 1; j <= arr.length - 1; j++) {
                    if (arr[j] >= compareValue && arr[j] < 0) {
                        sumRight += arr[j];
                    }
                }
            } else if (typePrice.equals("all")) {
                for (int i = entryPoint - 1; i >= 0; i--) {
                    if (arr[i] >= compareValue) {
                        sumLeft += arr[i];
                    }
                }
                for (int j = entryPoint + 1; j <= arr.length - 1; j++) {
                    if (arr[j] >= compareValue) {
                        sumRight += arr[j];
                    }
                }
            }
        }

        if (sumLeft >= sumRight) {
            System.out.printf("Left - %d%n", sumLeft);
        } else {
            System.out.printf("Right - %d%n", sumRight);
        }
    }
}