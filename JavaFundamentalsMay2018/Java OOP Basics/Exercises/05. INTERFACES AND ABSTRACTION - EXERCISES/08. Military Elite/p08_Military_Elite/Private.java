package p08_Military_Elite;

/**
 * Created by Nino Bonev - 30.6.2018 г., 10:11
 */
public class Private extends Soldier implements IPrivate{
    private double salary;

    public Private(String id, String firstName, String lastName, Double salary) {
        super(id, firstName, lastName);
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String getId() {
        return super.getId();
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public Double getSalary() {
        return this.salary;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s Salary: %.2f", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary())
                .replace(",", "."))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
