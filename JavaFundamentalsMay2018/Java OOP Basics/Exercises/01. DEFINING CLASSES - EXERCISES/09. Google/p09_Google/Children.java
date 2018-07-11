package p09_Google;

/**
 * Created by Nino Bonev - 19.6.2018 г., 10:02
 */
public class Children {
    private String name;
    private String birthday;

    public Children() {
    }

    public Children(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getInfo(){return String.format("%s %s", this.getName(), this.getBirthday());}
}
