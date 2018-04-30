import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Wormtest {
    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int wormLengthInMeters = Integer.parseInt(console.readLine());
        double wormWidthInCentimeters = Double.parseDouble(console.readLine());

        int wormLengthInCentimeters = wormLengthInMeters * 100;

        BigDecimal divisionRemainder = new BigDecimal(0);

        if (wormLengthInCentimeters !=0 && wormWidthInCentimeters !=0)
        {
            divisionRemainder = new BigDecimal(wormLengthInCentimeters % wormWidthInCentimeters);
        }

        if (divisionRemainder.equals(BigDecimal.ZERO) || (wormLengthInMeters == 0 || wormWidthInCentimeters == 0))
        {
            BigDecimal result = new BigDecimal(wormLengthInCentimeters * wormWidthInCentimeters);
            System.out.printf("%.2f", result);
        } else {
            BigDecimal result = new BigDecimal(wormLengthInCentimeters / wormWidthInCentimeters * 100);
            System.out.printf("%.2f%%", result);
        }
    }
}
