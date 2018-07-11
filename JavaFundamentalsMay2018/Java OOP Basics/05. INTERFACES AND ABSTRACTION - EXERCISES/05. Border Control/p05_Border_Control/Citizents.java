package p05_Border_Control;

/**
 * Created by Nino Bonev - 29.6.2018 г., 13:40
 */
public class Citizents implements p05_Border_Control.ID {
    private String name;
    private int age;
    private String ID;

    public Citizents(String name, int age, String ID) {
        this.name = name;
        this.age = age;
        this.ID = ID;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return this.ID;
    }

    @Override
    public String idToCkeck() {
        return this.getID();
    }
}
