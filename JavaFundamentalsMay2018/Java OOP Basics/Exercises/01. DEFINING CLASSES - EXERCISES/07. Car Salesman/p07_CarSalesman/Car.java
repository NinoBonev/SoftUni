package p07_CarSalesman;

/**
 * Created by Nino Bonev - 16.6.2018 г., 10:26
 */
public class Car {
    //model, engine, weight and color
    private static final String DEFAULT_WEIGHT = "n/a";
    private static final String DEFAULT_COLOR = "n/a";

    private String model;
    private Engine engine;
    private String weight = DEFAULT_WEIGHT;
    private String color = DEFAULT_COLOR;

    public Car() {
    }

    public Car(String model, Engine engine, String...optional) {
        this.model = model;
        this.engine = engine;

        switch (optional.length) {
            case 2:
                this.color = optional[1];
            case 1:
                if (optional[0].matches("\\d+")) {
                    this.weight = optional[0];
                } else {
                    this.color = optional[0];
                }
            default:
                break;
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s:%n", this.model))
                .append(this.engine.getEngineInfo()).append(System.lineSeparator())
                .append(String.format("  Weight: %s%n", this.weight))
                .append(String.format("  Color: %s", this.color));

        return sb.toString();
    }
}
