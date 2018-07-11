package p08_Military_Elite;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Nino Bonev - 30.6.2018 г., 10:14
 */
public class Engineer extends SpecialisedSoldier implements IEngineer {
    private Set<Repair> repairs;

    public Engineer(String id, String firstName, String lastName, Double salary, String corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new LinkedHashSet<>();
    }

    public void setRepairs(Set<Repair> repairs) {
        this.repairs = repairs;
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
    public String getCorps() {
        return super.getCorps();
    }

    @Override
    public Set<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public void addRepair(Repair newRepair) {
        this.getRepairs().add(newRepair);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s Salary: %.2f", this.getFirstName(), this.getLastName(), this.getId(), this.getSalary())
                .replace(",", "."))
                .append(System.lineSeparator())
                .append(String.format("Corps: %s", this.getCorps()))
                .append(System.lineSeparator())
                .append("Repairs:")
                .append(System.lineSeparator());
        for (Repair repair:
             this.getRepairs()) {
            sb.append(repair.toString()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
