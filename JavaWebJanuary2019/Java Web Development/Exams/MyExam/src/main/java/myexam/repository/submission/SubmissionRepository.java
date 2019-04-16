package myexam.repository.submission;

import myexam.domain.entities.Submission;
import myexam.repository.GenericRepository;

/**
 * Created by Nino Bonev - 16.4.2019 г., 19:26
 */
public interface SubmissionRepository extends GenericRepository<Submission, String> {

    Submission findById(String id);
}
