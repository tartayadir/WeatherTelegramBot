package com.example.demo.bots;

import com.example.demo.procssors.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class TelegramWeatherBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.token}")
    private String token;
    @Value("${telegram.bot.username}")
    private String userName;
    private Processor processor;

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public void onUpdateReceived(Update update) {
        processor.process(update);
    }

    @Autowired
    public void setProcessor(Processor processor) {
        this.processor = processor;
    }
}
