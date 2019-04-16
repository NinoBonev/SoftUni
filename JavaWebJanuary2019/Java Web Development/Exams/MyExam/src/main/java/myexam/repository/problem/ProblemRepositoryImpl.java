package myexam.repository.problem;

import myexam.domain.entities.Problem;
import myexam.repository.BaseRepository;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Nino Bonev - 16.4.2019 г., 17:00
 */
public class ProblemRepositoryImpl extends BaseRepository implements ProblemRepository {
    @Inject
    protected ProblemRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Problem findByName(String name) {
        return this.executeTransaction((em) -> {
                return (Problem) em.createNativeQuery("SELECT * FROM problems WHERE name = '" + name + "'", Problem.class)
                        .getSingleResult();
        });
    }

    @Override
    public Problem save(Problem problem) {
        return this.executeTransaction((em) -> {
            em.persist(problem);
            return problem;
        });
    }

    @Override
    public List<Problem> findAll() {
        return this.executeTransaction((em) -> {
            return em.createNativeQuery("SELECT * FROM problems", Problem.class)
                    .getResultList();
        });
    }

    @Override
    public Problem findById(String id) {
        return this.executeTransaction((em) -> {
            return (Problem) em.createNativeQuery("SELECT * FROM problems WHERE id = '" + id + "'", Problem.class)
                    .getSingleResult();
        });
    }
}
