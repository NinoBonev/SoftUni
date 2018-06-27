package p03_Mankind;

/**
 * Created by Nino Bonev - 23.6.2018 г., 12:11
 */
public class Human {
    private String firstName;
    private String lastName;

    public Human() {
    }

    public Human(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (!Character.isUpperCase(firstName.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: firstName");
        }
        if (firstName.length() < 4){
            throw new IllegalArgumentException("Expected length at least 4 symbols!Argument: firstName");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (!Character.isUpperCase(lastName.charAt(0))){
            throw new IllegalArgumentException("Expected upper case letter!Argument: lastName");
        }
        if (lastName.length() < 3){
            throw new IllegalArgumentException("Expected length at least 3 symbols!Argument: lastName");
        }
        this.lastName = lastName;
    }
}
