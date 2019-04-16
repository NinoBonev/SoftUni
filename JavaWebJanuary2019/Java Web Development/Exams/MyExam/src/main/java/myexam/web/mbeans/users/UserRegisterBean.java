package myexam.web.mbeans.users;

import myexam.domain.models.binding.UserRegisterBindingModel;
import myexam.domain.models.view.UserServiceModel;
import myexam.service.user.UserService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

@Named("userRegisterBean")
@RequestScoped
public class UserRegisterBean {

    private UserRegisterBindingModel userRegisterBindingModel;
    private UserService userService;
    private ModelMapper modelMapper;


    public UserRegisterBean() {
    }

    @Inject
    public UserRegisterBean(UserService userService, ModelMapper modelMapper) {
        this.userRegisterBindingModel = new UserRegisterBindingModel();
        this.userService = userService;
        this.modelMapper = modelMapper;

    }

    public UserRegisterBindingModel getUserRegisterBindingModel() {
        return this.userRegisterBindingModel;
    }

    public void setUserRegisterBindingModel(UserRegisterBindingModel userRegisterBindingModel) {
        this.userRegisterBindingModel = userRegisterBindingModel;
    }

    public void register() throws IOException {
        if(!this.userRegisterBindingModel.getPassword()
                .equals(this.userRegisterBindingModel.getConfirmPassword())) {
            return;
        }

        this.userService.createUser(this.modelMapper.map(this.userRegisterBindingModel, UserServiceModel.class));

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        context.redirect("login.xhtml");
    }


}
