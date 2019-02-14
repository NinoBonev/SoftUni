package employee.web.mbeans;

import employee.domain.models.binding.EmployeeRegisterBindingModel;
import employee.domain.models.service.EmployeeServiceModel;
import employee.service.EmployeeService;
import org.modelmapper.ModelMapper;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;

/**
 * Created by Nino Bonev - 12.2.2019 г., 13:53
 */

@Named
@javax.enterprise.context.RequestScoped
public class EmployeeRegisterBean {

    private EmployeeRegisterBindingModel employeeRegisterBindingModel;

    private EmployeeService employeeService;
    private ModelMapper modelMapper;

    public EmployeeRegisterBean() {
        this.employeeRegisterBindingModel = new EmployeeRegisterBindingModel();
    }

    @Inject
    public EmployeeRegisterBean(EmployeeService employeeService, ModelMapper modelMapper) {
        this();
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
    }

    public EmployeeRegisterBindingModel getEmployeeRegisterBindingModel() {
        return employeeRegisterBindingModel;
    }

    public void setEmployeeRegisterBindingModel(EmployeeRegisterBindingModel employeeRegisterBindingModel) {
        this.employeeRegisterBindingModel = employeeRegisterBindingModel;
    }

    public void register() throws IOException {
        try {
            this.employeeService
                    .saveEmployee(this.modelMapper.map(this.employeeRegisterBindingModel, EmployeeServiceModel.class));

            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect("/");
        } catch (Exception e){
            e.getMessage();
        }
    }
}
