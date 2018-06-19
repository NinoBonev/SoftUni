package p09_Google;

/**
 * Created by Nino Bonev - 19.6.2018 г., 10:05
 */
public class Company {
    private String name;
    private String department;
    private double salary;

    public Company() {
    }

    public Company(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return this.department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getInfo() {
        return String.format("%s %s %.2f", this.getName(), this.getDepartment(), this.getSalary());
    }
}
