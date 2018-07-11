package p03_Mankind;

import java.util.Scanner;

/**
 * Created by Nino Bonev - 23.6.2018 г., 12:11
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            String[] studentData = scanner.nextLine().split(" ");
            String[] workerData = scanner.nextLine().split(" ");

            Student student = new Student(studentData[0], studentData[1], studentData[2]);
            Worker worker = new Worker(workerData[0], workerData[1], Double.parseDouble(workerData[2]), Double.parseDouble(workerData[3]));

            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException exp){
            System.out.println(exp.getMessage());
        }



    }
}
