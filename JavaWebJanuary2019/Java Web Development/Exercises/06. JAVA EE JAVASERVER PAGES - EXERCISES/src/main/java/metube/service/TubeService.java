package metube.service;

import metube.domain.models.service.TubeServiceModel;
import metube.domain.models.view.AllTubesViewModel;

import java.util.List;

/**
 * Created by Nino Bonev - 7.2.2019 г., 18:24
 */
public interface TubeService {

    void saveTube (TubeServiceModel tubeServiceModel);

    TubeServiceModel findTubeByName(String name);

    List<TubeServiceModel> findAllTubes();
}
