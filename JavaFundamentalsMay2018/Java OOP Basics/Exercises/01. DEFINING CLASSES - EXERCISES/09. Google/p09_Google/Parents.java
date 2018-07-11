package p09_Google;

/**
 * Created by Nino Bonev - 19.6.2018 г., 10:01
 */
public class Parents {
    private String name;
    private String birthday;

    public Parents() {
    }

    public Parents(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getInfo(){return String.format("%s %s", this.getName(), this.getBirthday());}
}
