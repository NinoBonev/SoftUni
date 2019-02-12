package metube.repository;

import java.util.List;
import java.util.Optional;

/**
 * Created by Nino Bonev - 7.2.2019 г., 18:09
 */
public interface GeneticRepository<E, Id> {

    E save (E entity);

    List<E> findAll();

    Optional<E> findById(Id id);
}
