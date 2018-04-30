import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompareCharArrays2 {
    public static void main(String[] args) throws IOException{

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));


        char [] firstArray = console.readLine().replaceAll(" ", "").toCharArray();
        char [] secondArray = console.readLine().replaceAll(" ", "").toCharArray();
        int firstOrder = 0;
        int secondOrder = 0;

        int minLength = Math.min(firstArray.length, secondArray.length);

        for (int i = 0; i < minLength; i++)
        {
            if (firstArray[i] == secondArray[i])
            {
                continue;
            }
            else if (firstArray[i] > secondArray[i])
            {
                firstOrder++;
                break;
            }
            else if (firstArray[i] < secondArray[i])
            {
                secondOrder++;
                break;
            }
        }

        if (firstOrder > 0)
        {
            for (char ch:
                    secondArray) {
                System.out.print(ch);
            }

            System.out.println();

            for (char ch:
                    firstArray) {
                System.out.print(ch);
            }
        }
        else if (secondOrder > 0)
        {
            for (char ch:
                    firstArray) {
                System.out.print(ch);
            }

            System.out.println();

            for (char ch:
                    secondArray) {
                System.out.print(ch);
            }
        }
        else
        {
            if (firstArray.length >= secondArray.length )
            {
                for (char ch:
                        secondArray) {
                    System.out.print(ch);
                }

                System.out.println();

                for (char ch:
                        firstArray) {
                    System.out.print(ch);
                }
            }
            else
            {
                for (char ch:
                        firstArray) {
                    System.out.print(ch);
                }

                System.out.println();

                for (char ch:
                        secondArray) {
                    System.out.print(ch);
                }
            }
        }
    }
}
