package p08_Military_Elite;

/**
 * Created by Nino Bonev - 30.6.2018 г., 10:17
 */
public class Spy extends Soldier implements ISpy {
    private String codeNumber;

    public Spy(String id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    public void setCodeNumber(String codeNumber) {
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Name: %s %s Id: %s", this.getFirstName(), this.getLastName(), this.getId()))
                .append(System.lineSeparator())
                .append(String.format("Code Number: %s", this.getCodeNumber()))
                .append(System.lineSeparator());
        return sb.toString();
    }
}
