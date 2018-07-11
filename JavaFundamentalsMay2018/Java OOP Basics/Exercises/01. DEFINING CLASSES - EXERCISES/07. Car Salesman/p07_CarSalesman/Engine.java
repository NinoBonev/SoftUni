package p07_CarSalesman;

/**
 * Created by Nino Bonev - 16.6.2018 г., 10:27
 */
public class Engine {
    //model, power, displacement and efficiency
    private static final String DEFAULT_DISPLACEMENT = "n/a";
    private static final String DEFAULT_EFFICIENCY = "n/a";

    private String model;
    private int power;
    private String displacement;
    private String efficiency;

    public Engine() {
    }

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = DEFAULT_DISPLACEMENT;
        this.efficiency = DEFAULT_EFFICIENCY;
    }

    public Engine(String model, int power, String...optional) {
        this(model, power);

        switch (optional.length) {
            case 2:
                this.efficiency = optional[1];
            case 1:
                if (optional[0].matches("\\d+")) {
                    this.displacement = optional[0];
                } else {
                    this.efficiency = optional[0];
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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getDisplacement() {
        return displacement;
    }

    public void setDisplacement(String displacement) {
        this.displacement = displacement;
    }

    public String getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(String efficiency) {
        this.efficiency = efficiency;
    }

    String getEngineInfo() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  %s:%n", this.model))
                .append(String.format("    Power: %d%n", this.power))
                .append(String.format("    Displacement: %s%n", this.displacement))
                .append(String.format("    Efficiency: %s", this.efficiency));

        return sb.toString();
    }
}
