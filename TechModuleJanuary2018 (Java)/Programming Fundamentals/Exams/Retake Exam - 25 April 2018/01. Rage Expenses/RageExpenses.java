import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RageExpenses {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Integer lostGamesCount = Integer.parseInt(console.readLine());
        Double headsetPrice = Double.parseDouble(console.readLine());
        Double mousePrice = Double.parseDouble(console.readLine());
        Double keyboardPrice = Double.parseDouble(console.readLine());
        Double displayPrice = Double.parseDouble(console.readLine());

        Integer headsetTrashed = lostGamesCount / 2;
        Integer mouseTrashed = lostGamesCount / 3;
        Integer keyboardTrashed = lostGamesCount / 6;
        Integer displayTrashed = lostGamesCount / 12;

        Double expenses = headsetPrice * headsetTrashed + mousePrice * mouseTrashed + keyboardPrice * keyboardTrashed + displayPrice * displayTrashed;

        System.out.printf("Rage expenses: %.2f lv.", expenses);

    }
}
