package fdmc.web.mbeans;

import fdmc.domain.models.service.CatListModel;
import fdmc.services.CatService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 14.2.2019 г., 15:01
 */

@Named
@RequestScoped
public class CatAllBean {

    private List<CatListModel> cats;

    private CatService catService;
    private ModelMapper modelMapper;

    public CatAllBean() {
    }

    @Inject
    public CatAllBean(CatService catService, ModelMapper modelMapper) {
        this.catService = catService;
        this.modelMapper = modelMapper;
        this.cats = this.catService
                .findAllCats()
                .stream()
                .map(c -> this.modelMapper.map(c, CatListModel.class))
                .collect(Collectors.toList());
    }

    public List<CatListModel> getCats() {
        return cats;
    }

    public void setCats(List<CatListModel> cats) {
        this.cats = cats;
    }
}
