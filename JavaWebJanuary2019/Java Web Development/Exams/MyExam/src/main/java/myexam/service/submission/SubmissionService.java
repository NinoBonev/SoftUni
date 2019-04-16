package myexam.service.submission;

import myexam.domain.models.view.SubmissionServiceModel;

import java.util.List;

/**
 * Created by Nino Bonev - 16.4.2019 г., 19:30
 */
public interface SubmissionService {

    SubmissionServiceModel getSubmissionById(String id);

    List<SubmissionServiceModel> getAllSubmissions();

    SubmissionServiceModel createSubmission(SubmissionServiceModel submissionServiceModel);
}
