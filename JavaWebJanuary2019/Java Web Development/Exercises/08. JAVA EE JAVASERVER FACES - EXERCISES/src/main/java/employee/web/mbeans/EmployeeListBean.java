package employee.web.mbeans;

import employee.domain.entities.Employee;
import employee.domain.models.service.EmployeeListModel;
import employee.service.EmployeeService;
import org.modelmapper.ModelMapper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Nino Bonev - 12.2.2019 г., 20:35
 */

@Named
@RequestScoped
public class EmployeeListBean {

    private List<EmployeeListModel> employees;

    private EmployeeService employeeService;
    private ModelMapper modelMapper;

    public EmployeeListBean() {
    }

    @Inject
    public EmployeeListBean(EmployeeService employeeService, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.modelMapper = modelMapper;
        this.employees = this.employeeService.findAllEmployees()
                .stream()
                .map(e -> this.modelMapper.map(e, EmployeeListModel.class))
                .collect(Collectors.toList());
    }

    public List<EmployeeListModel> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeListModel> employees) {
        this.employees = employees;
    }

    public BigDecimal getTotalSalary(){
        BigDecimal total = new BigDecimal(BigInteger.ZERO);

        for (EmployeeListModel employee : employees) {
            total = total.add(employee.getSalary());
        }

        return total;
    }

    public BigDecimal getAverageSalary(){
        BigDecimal average = this.getTotalSalary();
        Integer employeesCount = 0;

        for (EmployeeListModel employee : employees) {
            employeesCount++;
        }

        if (employeesCount == 0){
            average = BigDecimal.ZERO;
        } else {
            average = average.divide(new BigDecimal(employeesCount), RoundingMode.FLOOR);
        }

        return average;
    }
}
