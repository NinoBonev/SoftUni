import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MemoryView {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        boolean first = false;
        boolean second = false;
        boolean third = false;
        Integer numberLength = 0;
        Integer count = 1;
        StringBuilder name = new StringBuilder();
        String lookingFor = "first";

        String line;
        while (!"Visual Studio crash".equals(line = console.readLine())) {
            int[] input = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < input.length; i++) {
                if (lookingFor.equals("first") && input[i] == 32656) {
                    first = true;
                    lookingFor = "second";

                } else if (lookingFor.equals("second") && input[i] == 19759)
                {
                    second = true;
                    lookingFor = "third";

                } else if (lookingFor.equals("third") && input[i] == 32763)
                {
                    third = true;
                    lookingFor = "firstZero";

                } else if (lookingFor.equals("firstZero") && first && second && third)
                {
                    lookingFor = "numberLength";
                } else if (lookingFor.equals("numberLength"))
                {
                    numberLength = input[i];
                    lookingFor = "secondZero";
                } else if (lookingFor.equals("secondZero") && input[i] == 0)
                {
                    lookingFor = "name";
                } else if (lookingFor.equals("name"))
                {
                    if (count <= numberLength)
                    {
                        name.append((char) input[i]);
                        count++;
                    } else {
                        System.out.println(name);
                        count = 1;
                        name.delete(0, name.length());
                        lookingFor = "first";
                        first = false;
                        second = false;
                        third = false;
                    }
                }
            }
        }
    }
}
