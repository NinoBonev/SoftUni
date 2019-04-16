package myexam.service.problem;

import myexam.domain.entities.Problem;
import myexam.domain.models.view.ProblemServiceModel;
import myexam.repository.problem.ProblemRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 16.4.2019 г., 17:13
 */
public class ProblemServiceModelImpl implements ProblemService {

    private final ProblemRepository problemRepository;

    private final ModelMapper modelMapper;

    @Inject
    public ProblemServiceModelImpl(ProblemRepository problemRepository, ModelMapper modelMapper) {
        this.problemRepository = problemRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProblemServiceModel getProblemByName(String name) {
        return this.modelMapper.map(this.problemRepository.findByName(name), ProblemServiceModel.class);
    }

    @Override
    public List<ProblemServiceModel> getAllProblems() {
        return this.problemRepository
                .findAll()
                .stream()
                .map(c -> this.modelMapper.map(c, ProblemServiceModel.class))
                .collect(Collectors.toList());}

    @Override
    public ProblemServiceModel createProblem(ProblemServiceModel problemServiceModel) {
        return this.modelMapper.map(
                this.problemRepository
                        .save(this.modelMapper.map(problemServiceModel, Problem.class)),
                ProblemServiceModel.class);
    }
}
