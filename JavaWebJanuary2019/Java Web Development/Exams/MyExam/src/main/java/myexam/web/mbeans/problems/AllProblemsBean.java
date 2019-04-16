package myexam.web.mbeans.problems;

import myexam.domain.models.view.ProblemServiceModel;
import myexam.service.problem.ProblemService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 16.4.2019 г., 18:54
 */

@Named("problemAllBean")
@RequestScoped
public class AllProblemsBean {

    private ProblemService problemService;
    private ModelMapper modelMapper;
    private List<ProblemServiceModel> problems = new ArrayList<>();

    public AllProblemsBean() {
    }

    @Inject
    public AllProblemsBean(ProblemService problemService, ModelMapper modelMapper) {
        this.problemService = problemService;
        this.modelMapper = modelMapper;
        this.setProblems();
    }

    public List<ProblemServiceModel> getAllProblems() throws IOException {
        return this.problems;
    }

    public void setProblems() {
        this.problems =  this.problemService
                .getAllProblems()
                .stream()
                .map(c -> this.modelMapper.map(c, ProblemServiceModel.class))
                .collect(Collectors.toList());
    }
}
