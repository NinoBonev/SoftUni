public class Lottery {
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            for (int j = 2; j <= 10; j++) {
                for (int k = 3; k <= 10; k++) {
                    if (i == j || i == k || j == k) {
                        continue;
                    } else if (k < j || j < i) {
                        continue;
                    } else {
                        System.out.println(i + " " + j + " " + k);
                    }
                }
            }
        }
    }
}
