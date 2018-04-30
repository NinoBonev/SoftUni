import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HornetWings {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int wingFlaps = Integer.parseInt(console.readLine());
        double distancePerThousand = Double.parseDouble(console.readLine());
        int endurance = Integer.parseInt(console.readLine());

        double distance = wingFlaps / 1000 * distancePerThousand;
        double enduranceTime = wingFlaps / endurance * 5;
        double totalTime = wingFlaps / 100 + enduranceTime;

        System.out.printf("%.2f m.%n", distance);
        System.out.printf("%.0f s.%n", totalTime);

    }
}
