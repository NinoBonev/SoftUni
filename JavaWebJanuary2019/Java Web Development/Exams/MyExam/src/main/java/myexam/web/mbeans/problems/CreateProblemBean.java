package myexam.web.mbeans.problems;

import myexam.domain.models.binding.ProblemCreateBindingModel;
import myexam.domain.models.view.ProblemServiceModel;
import myexam.service.problem.ProblemService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

/**
 * Created by Nino Bonev - 16.4.2019 г., 17:17
 */

@Named("problemCreateBean")
@RequestScoped
public class CreateProblemBean {

    private ProblemCreateBindingModel problemCreateBindingModel;
    private ProblemService problemService;
    private ModelMapper modelMapper;

    public CreateProblemBean() {
    }

    @Inject
    public CreateProblemBean(ProblemService problemService, ModelMapper modelMapper) {
        this.problemCreateBindingModel = new ProblemCreateBindingModel();
        this.problemService = problemService;
        this.modelMapper = modelMapper;
    }

    public ProblemCreateBindingModel getProblemCreateBindingModel() {
        return problemCreateBindingModel;
    }

    public void setProblemCreateBindingModel(ProblemCreateBindingModel problemCreateBindingModel) {
        this.problemCreateBindingModel = problemCreateBindingModel;
    }

    public void createProblem() throws IOException {
        this.problemService.createProblem(
                this.modelMapper
                        .map(this.problemCreateBindingModel, ProblemServiceModel.class));

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("home.xhtml");
    }
}
