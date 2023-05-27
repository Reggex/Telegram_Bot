package ru.rut.telegram.Service;

import lombok.ToString;
import org.springframework.stereotype.Service;
import ru.rut.telegram.Model.Employee;
import ru.rut.telegram.Model.Work;

import java.util.List;


@Service
public class WorkServiceImpl implements WorkService{

    @Override
    public List<Work> getEmployeeWork(String login) {
        return null;
    }

    @Override
    public void startWork(String login) {

    }
}
