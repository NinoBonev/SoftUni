package fdmc.web.mbeans;

import fdmc.domain.models.binding.CatCreateModel;
import fdmc.domain.models.service.CatServiceModel;
import fdmc.services.CatService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by Nino Bonev - 14.2.2019 г., 10:49
 */

@Named
@RequestScoped
public class CreateCatBean {
    private CatCreateModel catCreateModel;

    private CatService catService;
    private ModelMapper modelMapper;

    public CreateCatBean() {
        this.catCreateModel = new CatCreateModel();
    }

    @Inject
    public CreateCatBean(CatService catService, ModelMapper modelMapper) {
        this();
        this.catService = catService;
        this.modelMapper = modelMapper;
    }

    public CatCreateModel getCatCreateModel() {
        return catCreateModel;
    }

    public void setCatCreateModel(CatCreateModel catCreateModel) {
        this.catCreateModel = catCreateModel;
    }

    public void create(){
        try {
            this.catService.saveCat(this.modelMapper.map(this.catCreateModel, CatServiceModel.class));

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect("/");
        } catch (Exception e){
            e.getMessage();
        }
    }
}
