package employee.repository;

import java.util.List;

/**
 * Created by Nino Bonev - 12.2.2019 г., 13:37
 */
public interface GenericRepository<E, ID> {

    E save(E entity);

    E remove(E entity);

    List<E> findAll();

    E findById(ID id);
}
