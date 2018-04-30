import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ladybugs {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int fieldSiez = Integer.parseInt(console.readLine());
        long[] indexes = Arrays.stream(console.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        int[] field = new int[fieldSiez];
        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] <= fieldSiez - 1) {
                field[(int)indexes[i]] = 1;
            }
        }

        String line;
        while (!"end".equals(line = console.readLine())) {
            int ladybugIndex = Integer.parseInt(line.split(" ")[0]);
            String direction = line.split(" ")[1];
            long flyLength = Long.parseLong(line.split(" ")[2]);

            if (direction.equals("right")) {
                if (ladybugIndex <= fieldSiez - 1){
                    if (ladybugIndex + flyLength <= fieldSiez - 1) {
                        if (field[(int)(ladybugIndex + flyLength)] == 0) {
                            field[ladybugIndex] = 0;
                            field[(int)(ladybugIndex + flyLength)] = 1;
                        } else if (field[(int)(ladybugIndex + flyLength)] == 1) {
                            field[ladybugIndex] = 0;

                            for (int i = (int)(ladybugIndex + flyLength); i < field.length; i += flyLength) {
                                if (field[i] == 0) {
                                    field[i] = 1;
                                }
                            }
                        }
                    } else {
                        field[ladybugIndex] = 0;
                    }
                }
            } else if (direction.equals("left")) {
                if (ladybugIndex <= fieldSiez - 1){
                    if (ladybugIndex - flyLength >= 0) {
                        if (field[(int)(ladybugIndex - flyLength)] == 0) {
                            field[ladybugIndex] = 0;
                            field[(int)(ladybugIndex - flyLength)] = 1;
                        } else if (field[(int)(ladybugIndex - flyLength)] == 1) {
                            field[ladybugIndex] = 0;

                            for (int i = (int)(ladybugIndex - flyLength); i >= 0; i -= flyLength) {
                                if (field[i] == 0) {
                                    field[i] = 1;
                                }
                            }
                        }
                    } else {
                        field[ladybugIndex] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < field.length; i++) {
            System.out.print(field[i] + " ");

        }
    }
}
