package myexam.domain.entities;

import javax.persistence.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nino Bonev - 16.4.2019 г., 15:09
 */

@Entity
@Table(name = "submissions")
public class Submission extends BaseEntity {

    private List<String> code;
    private Integer achievedResult;
    private Instant createdOn = Instant.now();
    private Problem problem;
    private User user;

    public Submission() {
    }

    public Submission(List<String> code, Integer achievedResult, Instant createdOn, Problem problem, User user) {
        this.code = code;
        this.achievedResult = achievedResult;
        this.createdOn = createdOn;
        this.problem = problem;
        this.user = user;
    }

    @ElementCollection
    @CollectionTable(name="codes", joinColumns=@JoinColumn(name="submission_id"))
    @Column(name = "code", nullable = false)
    public List<String> getCode() {
        return code;
    }

    public void setCode(List<String> code) {
        this.code = code;
    }

    @Column(name = "result", nullable = false)
    public Integer getAchievedResult() {
        return achievedResult;
    }

    public void setAchievedResult(Integer achievedResult) {
        this.achievedResult = achievedResult;
    }

    @Column(name = "created_on", nullable = false)
    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    @ManyToOne
    @JoinTable(name = "problem_submissions",
            joinColumns = @JoinColumn(name = "problem", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "submission", referencedColumnName = "id"))
    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    @ManyToOne
    @JoinTable(name = "user_submissions",
            joinColumns = @JoinColumn(name = "user", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "submission", referencedColumnName = "id"))
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
