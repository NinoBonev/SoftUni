package myexam.service.problem;

import myexam.domain.models.view.ProblemServiceModel;

import java.util.List;

/**
 * Created by Nino Bonev - 16.4.2019 г., 17:11
 */
public interface ProblemService {

    ProblemServiceModel getProblemByName(String name);

    List<ProblemServiceModel> getAllProblems();

    ProblemServiceModel createProblem(ProblemServiceModel problemServiceModel);
}
