package myexam.repository.problem;

import myexam.domain.entities.Problem;
import myexam.repository.GenericRepository;

import java.util.List;

/**
 * Created by Nino Bonev - 16.4.2019 г., 17:00
 */
public interface ProblemRepository extends GenericRepository<Problem, String> {
    Problem findByName(String name);

}
