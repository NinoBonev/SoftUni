package p08_Military_Elite;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Nino Bonev - 30.6.2018 г., 10:12
 */
public class LeutenantGeneral extends Private implements ILeutenantGeneral{
    private Set<Private> privates;


    public LeutenantGeneral(String id, String firstName, String lastName, Double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new HashSet<>();
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
        return super.getSalary();
    }

    @Override
    public Set<Private> getPrivates() {
        return this.privates;
    }

    @Override
    public void addPrivate(Private newPrivate) {
        this.getPrivates().add(newPrivate);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s Salary: %.2f", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary())
                .replace(",", "."))
                .append(System.lineSeparator())
                .append("Privates:")
                .append(System.lineSeparator());
        this.getPrivates().stream()
                .sorted((a, b) -> Integer.compare(Integer.parseInt(b.getId()), Integer.parseInt(a.getId())))
                .forEach(x -> sb.append(x.toString()));
        return sb.toString();
    }
}
