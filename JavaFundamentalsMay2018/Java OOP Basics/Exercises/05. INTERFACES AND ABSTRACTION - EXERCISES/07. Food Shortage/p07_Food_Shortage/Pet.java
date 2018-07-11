package p07_Food_Shortage;

/**
 * Created by Nino Bonev - 29.6.2018 г., 14:20
 */
public class Pet implements ID, Birthday {
    private String name;
    private String birthday;

    public Pet(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String getID() {
        return null;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }
}
