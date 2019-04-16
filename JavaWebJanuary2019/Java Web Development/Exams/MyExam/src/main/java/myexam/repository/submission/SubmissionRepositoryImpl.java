package myexam.repository.submission;

import myexam.domain.entities.Submission;
import myexam.repository.BaseRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Nino Bonev - 16.4.2019 г., 19:28
 */
public class SubmissionRepositoryImpl extends BaseRepository implements SubmissionRepository {
    @Inject
    protected SubmissionRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Submission save(Submission submission) {
        return this.executeTransaction((em) -> {
            em.persist(submission);
            return submission;
        });
    }

    @Override
    public List<Submission> findAll() {
        return this.executeTransaction((em) -> {
            return em.createNativeQuery("SELECT * FROM submissions", Submission.class)
                    .getResultList();
        });
    }

    @Override
    public Submission findById(String id) {
        return this.executeTransaction((em) -> {
            return (Submission) em
                    .createNativeQuery("SELECT * FROM submissions WHERE id = '" + id + "'", Submission.class)
                    .getSingleResult();
        });
    }
}
