package ru.rut.telegram.Bot.Command;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.rut.telegram.Model.Work;
import ru.rut.telegram.Repo.WorkRegionRepo;
import ru.rut.telegram.Repo.WorkRepo;
import ru.rut.telegram.Service.EmployeeService;
import ru.rut.telegram.Service.WorkRegionService;
import ru.rut.telegram.Service.WorkService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MyWorkCommand implements BotCommand {
    private final WorkService workService;
    private final EmployeeService employeeService;
    private final WorkRepo workRepo;
    private final WorkRegionService workRegionService;
    private final WorkRegionRepo workRegionRepo;

    public MyWorkCommand(WorkService workService, EmployeeService employeeService,
                         WorkRepo workRepo, WorkRegionService workRegionService, WorkRegionRepo workRegionRepo) {
        this.workService = workService;
        this.employeeService = employeeService;
        this.workRepo = workRepo;
        this.workRegionService = workRegionService;
        this.workRegionRepo = workRegionRepo;
    }


    @Override
    public List<SendMessage> runCommand(Message message) {
        List<SendMessage> messageList = new ArrayList<>();
        Work work = new Work();
        int emploee_id = employeeService.get_emploee_id_by_login(message.getChat().getUserName());
        boolean exists = workService.checkEmployee(emploee_id);
        work.setEmployee(employeeService.getEmployee(emploee_id));
        Date date = new Date();
        work.setWorkDate(date);
        workRepo.save(work);
        if (exists) {
            messageList.add(new SendMessage(message.getChat().getId().toString(),workRegionRepo.findByWork(work).toString()));
        }
        else {
            messageList.add(new SendMessage(message.getChat().getId().toString(),
                    "Назначьте смену для пользователя"+ message.getChat().getUserName()));

        };
        return messageList;
    }

    @Override
    public String supportedCommand() {
        return "/my_work";
    }
}
