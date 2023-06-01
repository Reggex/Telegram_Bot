package ru.rut.telegram.Service;

import org.springframework.stereotype.Service;
import ru.rut.telegram.Repo.EmployeeRepo;
import ru.rut.telegram.Model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeDao;

    public EmployeeServiceImpl(EmployeeRepo employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public Employee getEmployee(Integer id) {
        return employeeDao.getReferenceById(id);
    }

    @Override
    public boolean checkEmployee(String login) {
        Employee employee = employeeDao.findByLogin(login);
        if (employee == null){
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void create(Employee employee) {
        employeeDao.save(employee);
    }
    @Override
    public int get_emploee_id_by_login(String login){
        Employee employee = employeeDao.findByLogin(login);
        return employee.getId();
    }
}