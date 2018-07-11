package p08_Military_Elite;

/**
 * Created by Nino Bonev - 30.6.2018 г., 10:13
 */
public class SpecialisedSoldier extends Private implements ISpecialisedSoldier{
    private String corps;

    public SpecialisedSoldier(String id, String firstName, String lastName, Double salary, String corps) {
        super(id, firstName, lastName, salary);
        this.setCorps(corps);
    }

    public void setCorps(String corps) {
        if (!(corps.equals("Airforces") || corps.equals("Marines"))){
            throw new IllegalArgumentException("");
        }
        this.corps = corps;
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
        return this.corps;
    }
}
