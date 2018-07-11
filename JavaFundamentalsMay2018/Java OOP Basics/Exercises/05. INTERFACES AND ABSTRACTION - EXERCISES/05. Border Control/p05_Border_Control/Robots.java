package p05_Border_Control;

/**
 * Created by Nino Bonev - 29.6.2018 г., 13:40
 */
public class Robots implements p05_Border_Control.ID {
    private String model;
    private String ID;

    public Robots(String model, String ID) {
        this.model = model;
        this.ID = ID;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String idToCkeck() {
        return this.getID();
    }
}
