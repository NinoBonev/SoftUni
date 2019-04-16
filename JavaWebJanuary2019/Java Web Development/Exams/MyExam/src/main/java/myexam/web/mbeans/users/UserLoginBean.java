package myexam.web.mbeans.users;

import myexam.domain.models.binding.UserLoginBindingModel;
import myexam.domain.models.view.UserServiceModel;
import myexam.service.user.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Named("userLoginBean")
@RequestScoped
public class UserLoginBean {
    private UserLoginBindingModel userLoginBindingModel;
    private UserService userService;
    private ModelMapper modelMapper;

    public UserLoginBean() {
    }

    @Inject
    public UserLoginBean(UserService userService, ModelMapper modelMapper) {
        this.userLoginBindingModel = new UserLoginBindingModel();
        this.userService = userService;
        this.modelMapper = modelMapper;

    }

    public UserLoginBindingModel getUserLoginBindingModel() {
        return this.userLoginBindingModel;
    }

    public void setUserLoginBindingModel(UserLoginBindingModel userLoginBindingModel) {
        this.userLoginBindingModel = userLoginBindingModel;
    }

    public void login() throws IOException {

        UserServiceModel user = this.userService.getUserByUsername(this.userLoginBindingModel.getUsername());

        if (user == null || !user.getPassword().equals(DigestUtils.sha256Hex(this.userLoginBindingModel.getPassword()))) {
            FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
            return;
        }

        HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);

        session.setAttribute("username", user.getUsername());
        session.setAttribute("user-id", user.getId());

        FacesContext.getCurrentInstance().getExternalContext().redirect("home.xhtml");

    }
}
