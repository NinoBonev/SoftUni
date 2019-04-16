package myexam.domain.models.binding;

/**
 * Created by Nino Bonev - 16.4.2019 г., 16:59
 */
public class ProblemCreateBindingModel {

    private String name;
    private Integer points;

    public ProblemCreateBindingModel() {
    }

    public ProblemCreateBindingModel(String name, Integer points) {
        this.name = name;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
