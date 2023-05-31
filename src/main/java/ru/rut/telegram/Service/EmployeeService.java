package ru.rut.telegram.Service;

import ru.rut.telegram.Model.Employee;

public interface EmployeeService {

    void addEmployee(Employee employee);

    Employee getEmployee(Integer id);

    boolean checkEmployee(String login);

    void create (Employee employee);
}
