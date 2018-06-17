package p04_CompanyRoster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 16.6.2018 г., 8:26
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer employeeCount = Integer.parseInt(scanner.nextLine());
        List<Employee> employeeList = new ArrayList<>();

        for (int i = 0; i < employeeCount; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];

            if (data.length == 6){
                String email = data[4];
                int age = Integer.parseInt(data[5]);

                Employee employee = new Employee(name, salary, position, department, email, age);
                employeeList.add(employee);
            } else if (data.length == 5){
                if (data[4].contains("@")){
                    String email = data[4];

                    Employee employee = new Employee(name, salary, position, department, email);
                    employeeList.add(employee);
                } else {
                    int age = Integer.parseInt(data[4]);

                    Employee employee = new Employee(name, salary, position, department, age);
                    employeeList.add(employee);
                }
            } else if (data.length == 4){
                Employee employee = new Employee(name, salary, position, department);
                employeeList.add(employee);
            }
        }

        employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment))
                .entrySet()
                .stream()
                .sorted((e1, e2) -> Double.compare(
                        e2.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble(),
                        e1.getValue().stream().mapToDouble(Employee::getSalary).average().getAsDouble()))
                .limit(1)
                .forEach(x -> {
                    System.out.printf("Highest Average Salary: %s%n", x.getKey());
                    x.getValue().stream()
                            .sorted(Comparator.comparing(Employee::getSalary, Comparator.reverseOrder()))
                            .forEach(y -> System.out.println(y.toString()));
                });
    }
}
