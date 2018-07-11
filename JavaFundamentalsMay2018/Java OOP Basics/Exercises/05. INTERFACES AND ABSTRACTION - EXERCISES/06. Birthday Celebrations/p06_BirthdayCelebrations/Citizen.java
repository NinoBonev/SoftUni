package p06_BirthdayCelebrations;

/**
 * Created by Nino Bonev - 29.6.2018 г., 14:20
 */
public class Citizen implements ID, Birthday{
    private String name;
    private int age;
    private String ID;
    private String birthday;

    public Citizen(String name, int age, String ID, String birthday) {
        this.name = name;
        this.age = age;
        this.ID = ID;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    public void setBirthDdy(String birthday) {
        this.birthday = birthday;
    }
}
