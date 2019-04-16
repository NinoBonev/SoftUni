package myexam.domain.models.view;

/**
 * Created by Nino Bonev - 16.4.2019 г., 17:12
 */
public class ProblemServiceModel {

    private String id;
    private String name;
    private Integer points;

    public ProblemServiceModel() {
    }

    public ProblemServiceModel(String id, String name, Integer points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
