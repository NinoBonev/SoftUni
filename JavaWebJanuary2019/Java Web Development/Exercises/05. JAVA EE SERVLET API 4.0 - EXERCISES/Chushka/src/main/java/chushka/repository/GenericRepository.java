package chushka.repository;

import java.util.List;

/**
 * Created by Nino Bonev - 2.2.2019 г., 11:44
 */
public interface GenericRepository<E, K> {

    E save(E entity);

    E findById(K id);

    List<E> findAll();
}
