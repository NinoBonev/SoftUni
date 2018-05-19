import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class EuroTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Double quantity = scanner.nextDouble();
        BigDecimal priceInBGN = new BigDecimal(quantity * 1.2);
        BigDecimal exchangeRate = new BigDecimal("4210500000000");
        BigDecimal priceInDM = exchangeRate.multiply(priceInBGN);

        System.out.printf("%.2f marks", priceInDM);
    }
}
