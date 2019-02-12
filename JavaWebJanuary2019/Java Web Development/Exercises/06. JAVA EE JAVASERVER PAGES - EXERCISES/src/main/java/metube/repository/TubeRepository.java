package metube.repository;

import metube.domain.entities.Tube;

import java.util.Optional;

/**
 * Created by Nino Bonev - 7.2.2019 г., 18:11
 */
public interface TubeRepository extends GeneticRepository<Tube, String>{

    Optional<Tube> findByName(String name);
}
