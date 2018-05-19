import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer distance = scanner.nextInt();
        scanner.nextLine();
        String dayTime = scanner.nextLine();
        Double price = 0D;

        if (distance >= 100){
            price = distance * 0.06;
        } else if (distance >= 20 && distance < 100){
            price = distance * 0.09;
        } else {
            if (dayTime.equals("day")){
                price = 0.7 + distance * 0.79;
            } else if (dayTime.equals("night")){
                price = 0.7 + distance * 0.9;
            }
        }

        System.out.printf("%.2f", price);
    }
}
