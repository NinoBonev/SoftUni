import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;

public class Raindrops {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        int regions = Integer.parseInt(console.readLine());
        BigDecimal density = new BigDecimal(console.readLine());

        BigDecimal regionalCoefficientsSum = new BigDecimal(0);

        for (int i = 0; i < regions; i++)
        {
            String[] data = console.readLine().split(" ");
            BigDecimal raindropsCount = new BigDecimal(data[0]);
            BigDecimal squareMeters = new BigDecimal(data[1]);

            regionalCoefficientsSum = regionalCoefficientsSum.add(raindropsCount.divide(squareMeters, MathContext.DECIMAL64));
        }

        if (!density.equals(BigDecimal.ZERO))
        {
            BigDecimal result = regionalCoefficientsSum.divide(density, MathContext.DECIMAL64);
            System.out.printf("%.3f", result);
        }
        else
        {
            System.out.printf("%.3f", regionalCoefficientsSum);
        }
    }
}
