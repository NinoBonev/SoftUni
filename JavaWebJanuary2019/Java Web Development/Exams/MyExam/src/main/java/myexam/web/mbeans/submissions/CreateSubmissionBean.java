package myexam.web.mbeans.submissions;

import myexam.domain.models.binding.SubmissionCreateBindingModel;
import myexam.domain.models.view.SubmissionServiceModel;
import myexam.service.submission.SubmissionService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

/**
 * Created by Nino Bonev - 16.4.2019 г., 19:43
 */

@Named("submissionCreateBean")
@RequestScoped
public class CreateSubmissionBean {

    private SubmissionCreateBindingModel submissionCreateBindingModel;
    private SubmissionService submissionService;
    private ModelMapper modelMapper;

    public CreateSubmissionBean() {
    }

    @Inject
    public CreateSubmissionBean(SubmissionService submissionService, ModelMapper modelMapper) {
        this.submissionCreateBindingModel = new SubmissionCreateBindingModel();
        this.submissionService = submissionService;
        this.modelMapper = modelMapper;
    }

    public SubmissionCreateBindingModel getSubmissionCreateBindingModel() {
        return submissionCreateBindingModel;
    }

    public void setSubmissionCreateBindingModel(SubmissionCreateBindingModel submissionCreateBindingModel) {
        this.submissionCreateBindingModel = submissionCreateBindingModel;
    }

    public void createSubmission() throws IOException {
        this.submissionService.createSubmission(
                this.modelMapper
                        .map(this.submissionCreateBindingModel, SubmissionServiceModel.class));

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("home.xhtml");
    }
}
