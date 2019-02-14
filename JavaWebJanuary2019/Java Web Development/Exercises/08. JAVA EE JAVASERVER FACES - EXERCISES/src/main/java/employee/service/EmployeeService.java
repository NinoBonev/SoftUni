package employee.service;

import employee.domain.models.service.EmployeeServiceModel;

import java.util.List;

/**
 * Created by Nino Bonev - 12.2.2019 г., 13:47
 */
public interface EmployeeService {

    boolean saveEmployee(EmployeeServiceModel employeeServiceModel);

    List<EmployeeServiceModel> findAllEmployees();

    boolean removeEmployee(String id);
}
