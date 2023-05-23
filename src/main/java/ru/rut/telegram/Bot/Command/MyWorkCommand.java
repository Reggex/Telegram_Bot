package ru.rut.telegram.Bot.Command;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

public class MyWorkCommand implements BotCommand {

    @Override
    public List<SendMessage> runCommand(Message message) {
        List<SendMessage> messageList = new ArrayList<>();
        messageList.add(new SendMessage(message.getChat().getId().toString(),
                "Это не работает, но мы делаем всё возможное"));

        return messageList;
    }

    @Override
    public String supportedCommand() {
        return "/my_work";
    }
}
