package com.example.demo.messagesenders;

import com.example.demo.bots.TelegramWeatherBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class MessageSenderImpl implements MessageSender {
    private TelegramWeatherBot telegramWeatherBot;

    @Override
    public void sendMessage(SendMessage sendMessage) {
        try {
            telegramWeatherBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Autowired
    public void setHelloWorldBot(@Lazy TelegramWeatherBot telegramWeatherBot) {
        this.telegramWeatherBot = telegramWeatherBot;
    }

}
