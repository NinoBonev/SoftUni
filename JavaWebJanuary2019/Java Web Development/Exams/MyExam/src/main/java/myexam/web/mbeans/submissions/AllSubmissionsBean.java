package myexam.web.mbeans.submissions;

import myexam.domain.models.view.SubmissionServiceModel;
import myexam.service.submission.SubmissionService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 16.4.2019 г., 19:43
 */

@Named("submissionAllBean")
@RequestScoped
public class AllSubmissionsBean {

    private SubmissionService submissionService;
    private ModelMapper modelMapper;
    private List<SubmissionServiceModel> problems = new ArrayList<>();

    public AllSubmissionsBean() {
    }

    @Inject
    public AllSubmissionsBean(SubmissionService submissionService, ModelMapper modelMapper) {
        this.submissionService = submissionService;
        this.modelMapper = modelMapper;
        this.setSubmissions();
    }

    public List<SubmissionServiceModel> getProblems() {
        return problems;
    }

    public void setSubmissions() {
        this.problems =  this.submissionService
                .getAllSubmissions()
                .stream()
                .map(c -> this.modelMapper.map(c, SubmissionServiceModel.class))
                .collect(Collectors.toList());
    }
}
