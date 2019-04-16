package myexam.domain.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Nino Bonev - 16.4.2019 г., 15:07
 */

@Entity
@Table(name = "problems")
public class Problem extends BaseEntity {

    private String name;
    private Integer points;
    private List<Submission> submissionList;

    public Problem() {
    }

    public Problem(String name, Integer points, List<Submission> submissions) {
        this.submissionList = submissions;
        this.name = name;
        this.points = points;
    }

    @OneToMany(mappedBy = "problem", targetEntity = Submission.class)
    public List<Submission> getSubmissionList() {
        return submissionList;
    }

    public void setSubmissionList(List<Submission> submissionList) {
        this.submissionList = submissionList;
    }

    @Column(name = "name", nullable = false, unique = true)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "points", nullable = false)
    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}
