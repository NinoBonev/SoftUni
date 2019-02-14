package employee.domain.models.binding;

import java.math.BigDecimal;

/**
 * Created by Nino Bonev - 12.2.2019 г., 13:36
 */
public class EmployeeRegisterBindingModel {

    private String firstName;
    private String lastName;
    private String position;
    private BigDecimal salary;
    private int age;

    public EmployeeRegisterBindingModel() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
