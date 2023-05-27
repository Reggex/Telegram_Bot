package ru.rut.telegram.Service;

import org.springframework.stereotype.Service;
import ru.rut.telegram.Model.Work;
import ru.rut.telegram.Repo.WorkRepo;

import java.util.List;


@Service
public class WorkServiceImpl implements WorkService{

    private final WorkRepo workRepo;

    public WorkServiceImpl(WorkRepo workRepo) {
        this.workRepo = workRepo;
    }

    @Override
    public List<Work> getEmployeeWork(String login) {
        return workRepo.findAllByEmployeeLogin(login);
    }

    @Override
    public void startWork(String login) {

    }
}
