package fdmc.services;

import fdmc.domain.models.service.CatServiceModel;

import java.util.List;

/**
 * Created by Nino Bonev - 14.2.2019 г., 10:20
 */
public interface CatService {

    boolean saveCat(CatServiceModel catServiceModel);

    List<CatServiceModel> findAllCats();
}
