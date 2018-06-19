package p09_Google;

/**
 * Created by Nino Bonev - 19.6.2018 г., 10:03
 */
public class Car {
    private String model;
    private Integer speed;

    public Car() {
    }

    public Car(String model, Integer speed) {
        this.model = model;
        this.speed = speed;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getSpeed() {
        return this.speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public String getInfo() {
        return String.format("%s %d", this.getModel(), this.getSpeed());
    }
}
