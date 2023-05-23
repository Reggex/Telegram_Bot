package ru.rut.telegram.Bot.Command;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import ru.rut.telegram.Dao.EmployeeDao;
import ru.rut.telegram.Model.Employee;
import ru.rut.telegram.Service.EmployeeService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class StartCommand implements BotCommand{

    private final EmployeeService employeeService;


    public StartCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public List<SendMessage> runCommand(Message message) {
        List<SendMessage> messageList = new ArrayList<>();
        messageList.add(new SendMessage(message.getChat().getId().toString(), "Привет"));
        messageList.add(new SendMessage(message.getChat().getId().toString(), "Ваш логин: "
                + message.getChat().getUserName()));
        messageList.add(new SendMessage(message.getChat().getId().toString(), "Ваш chatId: "
                + message.getChatId()));

        boolean exists = employeeService.checkEmployee(message.getChat().getUserName());

        if (!exists) {
            Employee employee = new Employee(message.getChat().getUserName(), message.getChatId().toString());
            employeeService.create(employee);
        }

        return messageList;
    }


    @Override
    public String supportedCommand() {
        return "/start";
    }
}
