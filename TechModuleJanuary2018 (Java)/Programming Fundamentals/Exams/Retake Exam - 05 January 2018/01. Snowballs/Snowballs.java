import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class Snowballs {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        Short snowballs = Short.parseShort(console.readLine());
        Integer snowballSnowMax = 0;
        Short snowballTimeMax = 0;
        Byte snowballQualityMax = 0;
        BigDecimal snowballValueMax = new BigDecimal(0);

        for (int i = 0; i < snowballs; i++)
        {
            Integer snowballSnow = Integer.parseInt(console.readLine());
            Short snowballTime = Short.parseShort(console.readLine());
            Byte snowballQuality = Byte.parseByte(console.readLine());

            BigDecimal snowballValue = mathPower((snowballSnow / snowballTime), snowballQuality);
            if (snowballValue.compareTo(snowballValueMax) == 1)
            {
                snowballSnowMax = snowballSnow;
                snowballTimeMax = snowballTime;
                snowballQualityMax = snowballQuality;
                snowballValueMax = snowballValue;
            }
        }

        System.out.printf("%d : %d = %.0f (%d)%n", snowballSnowMax, snowballTimeMax, snowballValueMax, snowballQualityMax);

    }

    public static BigDecimal mathPower(double a, int b)
    {
        BigDecimal result = new BigDecimal(a);

        BigDecimal pow = result.pow(b);

        return pow;
    }


}
