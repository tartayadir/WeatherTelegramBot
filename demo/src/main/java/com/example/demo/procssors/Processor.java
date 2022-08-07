package com.example.demo.procssors;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public interface Processor {

    void executeMessage(Message message);

    default void process(Update update){
        if (update.hasMessage()){
            executeMessage(update.getMessage());
        }
    }
}