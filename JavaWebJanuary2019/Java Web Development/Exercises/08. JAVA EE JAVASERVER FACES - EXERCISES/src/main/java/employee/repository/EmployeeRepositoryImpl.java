package employee.repository;

import employee.domain.entities.Employee;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Nino Bonev - 12.2.2019 г., 13:39
 */
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EntityManager entityManager;

    @Inject
    public EmployeeRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Employee save(Employee entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.persist(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public Employee remove(Employee entity) {
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(entity);
        this.entityManager.getTransaction().commit();

        return entity;
    }

    @Override
    public List<Employee> findAll() {
        this.entityManager.getTransaction().begin();
        List<Employee> employees = this.entityManager
                .createQuery("SELECT e FROM Employee e", Employee.class)
                .getResultList();
        this.entityManager.getTransaction().commit();

        return employees;
    }

    @Override
    public Employee findById(String id) {
        this.entityManager.getTransaction().begin();
        Employee employee = this.entityManager
                .createQuery("SELECT e FROM Employee e WHERE e.id = :id", Employee.class)
                .setParameter("id", id)
                .getSingleResult();
        this.entityManager.getTransaction().commit();

        return employee;
    }
}
