package fdmc.repository;

import java.util.List;

/**
 * Created by Nino Bonev - 14.2.2019 г., 0:11
 */
public interface GenericRepository<E, String> {

    E save(E entity);

    List<E> findAll();

}
