package ru.rut.telegram.Service;

import lombok.ToString;
import org.springframework.stereotype.Service;
import ru.rut.telegram.Dao.EmployeeDao;
import ru.rut.telegram.Model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
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
}