package com.example.demo.handlers;

import com.example.demo.elementsForResponses.WeatherDAO;
import com.example.demo.messagesenders.MessageSender;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.io.IOException;

@Component

public class MessageHandler implements Handler<Message> {

    private final MessageSender messageSender;

    public MessageHandler(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void choose(Message message) {

        if (message.hasText()) {

            String[] words = message.getText().split(" ");
            String command = words[0];
            String city = "null";

            if (words.length > 1){
                city = words[1];
            }
            String responseText;

            if ("/start".equals(command)) {
                responseText = "Hi, I am your bot ✋. I can tell the weather in any city in the world. Enter" +
                        " the format command (/weather cityName) without spaces.";

            }else {
                if (command.equals("/weather")){

                    try {
                        System.out.println(city);
                        responseText = WeatherDAO.getWhether(city);
                    }catch (IOException ioException){
                        ioException.printStackTrace();
                        responseText = "Sorry, I cannot get data from server, please try later(";
                    }

                }else {
                    responseText = "Sorry, I can not understand your message(( Check your message and try again.";
                }
            }

            SendMessage sendMessage = SendMessage.
                    builder().
                    text(responseText).
                    chatId(String.valueOf(message.getChatId())).
                    build();
            messageSender.sendMessage(sendMessage);
        }
    }
}
