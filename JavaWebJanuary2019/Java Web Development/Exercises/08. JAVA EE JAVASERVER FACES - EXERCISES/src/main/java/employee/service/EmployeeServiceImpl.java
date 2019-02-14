package employee.service;

import employee.domain.entities.Employee;
import employee.domain.models.service.EmployeeServiceModel;
import employee.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;

import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 12.2.2019 г., 13:49
 */
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    @Inject
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean saveEmployee(EmployeeServiceModel employeeServiceModel) {
        try {
            this.employeeRepository.save(this.modelMapper.map(employeeServiceModel ,Employee.class));
        } catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List<EmployeeServiceModel> findAllEmployees() {
        return this.employeeRepository
                .findAll()
                .stream()
                .map(e -> this.modelMapper.map(e, EmployeeServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean removeEmployee(String id) {
        try {
            Employee employee = this.employeeRepository.findById(id);
            this.employeeRepository.remove(employee);
        } catch (Exception e){
            return false;
        }

        return true;
    }
}
