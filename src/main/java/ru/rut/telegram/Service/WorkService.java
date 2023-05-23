package ru.rut.telegram.Service;

import ru.rut.telegram.Model.Employee;

public interface WorkService {

    void addEmployee(Employee employee);

    Employee getEmployee(Integer id);
}
