package myexam.domain.models.view;

import myexam.domain.entities.Problem;
import myexam.domain.entities.User;

import java.time.Instant;
import java.util.List;

/**
 * Created by Nino Bonev - 16.4.2019 г., 19:31
 */
public class SubmissionServiceModel {

    private String id;
    private List<String> code;
    private Integer achievedResult;
    private Instant createdOn = Instant.now();
    private Problem problem;
    private User user;

    public SubmissionServiceModel() {
    }

    public SubmissionServiceModel(String id, List<String> code, Integer achievedResult, Instant createdOn, Problem problem, User user) {
        this.id = id;
        this.code = code;
        this.achievedResult = achievedResult;
        this.createdOn = createdOn;
        this.problem = problem;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getCode() {
        return code;
    }

    public void setCode(List<String> code) {
        this.code = code;
    }

    public Integer getAchievedResult() {
        return achievedResult;
    }

    public void setAchievedResult(Integer achievedResult) {
        this.achievedResult = achievedResult;
    }

    public Instant getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Instant createdOn) {
        this.createdOn = createdOn;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
