package myexam.service.submission;

import myexam.domain.entities.Submission;
import myexam.domain.models.view.SubmissionServiceModel;
import myexam.repository.submission.SubmissionRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 16.4.2019 г., 19:38
 */
public class SubmissionServiceImpl implements SubmissionService {

    private final SubmissionRepository submissionRepository;

    private final ModelMapper modelMapper;

    @Inject
    public SubmissionServiceImpl(SubmissionRepository submissionRepository, ModelMapper modelMapper) {
        this.submissionRepository = submissionRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public SubmissionServiceModel getSubmissionById(String id) {
        return this.modelMapper.map(this.submissionRepository.findById(id), SubmissionServiceModel.class);
    }

    @Override
    public List<SubmissionServiceModel> getAllSubmissions() {
        return this.submissionRepository
                .findAll()
                .stream()
                .map(sub -> this.modelMapper.map(sub, SubmissionServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public SubmissionServiceModel createSubmission(SubmissionServiceModel submissionServiceModel) {
        return this.modelMapper.map(
                this.submissionRepository
                        .save(this.modelMapper.map(submissionServiceModel, Submission.class)),
                SubmissionServiceModel.class);
    }
}
