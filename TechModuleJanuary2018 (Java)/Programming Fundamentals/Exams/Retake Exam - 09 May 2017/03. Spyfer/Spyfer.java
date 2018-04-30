import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Spyfer {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> input = Arrays.stream(console.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        boolean anythingToRemove = true;

        while (anythingToRemove) {
            if (input.size() > 2) {
                for (int i = 1; i < input.size(); i++) {
                    if (i == 1 && input.get(i) == input.get(i - 1)) {
                        input.remove(i);
                        break;
                    } else if (input.get(i) == input.get(i - 1) + input.get(i + 1) && i <= input.size() - 2) {
                        input.remove(i - 1);
                        input.remove(i);
                        break;
                    } else if (i == input.size() - 2 && input.get(i) == input.get(i + 1)) {
                        input.remove(i);
                        break;
                    } else if (i==input.size() - 2 && (input.get(i) != input.get(i + 1) && input.get(i) != input.get(i - 1) + input.get(i + 1))){
                        anythingToRemove = false;
                        break;
                    }
                }
            } else if (input.size() == 2){
                for (int i = 1; i < input.size(); i++) {
                    if (input.get(i) == input.get(i - 1)) {
                        input.remove(i);
                        anythingToRemove = false;
                        break;
                    } else {
                        anythingToRemove = false;
                    }
                }
            } else {
                anythingToRemove = false;
            }
        }

        input.forEach(x -> System.out.printf("%d ", x));
    }
}
