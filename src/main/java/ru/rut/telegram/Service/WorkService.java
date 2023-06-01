package ru.rut.telegram.Service;

import ru.rut.telegram.Model.Employee;
import ru.rut.telegram.Model.Work;

import java.util.List;

public interface WorkService {

    List<Work> getEmployeeWork(String login);

    void startWork(String login);

    boolean checkEmployee(int userName);
}
