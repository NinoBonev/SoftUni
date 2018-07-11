package p06_BirthdayCelebrations;

/**
 * Created by Nino Bonev - 29.6.2018 г., 14:20
 */
public class Robot implements ID, Birthday{
    private String model;
    private String ID;

    public Robot(String model, String ID) {
        this.model = model;
        this.ID = ID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String getID() {
        return this.ID;
    }

    @Override
    public String getBirthday() {
        return null;
    }
}
