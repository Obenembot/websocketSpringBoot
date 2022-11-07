package com.example.websockerproject.web;

import com.example.websockerproject.entities.HelloMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    SimpMessagingTemplate simpMessagingTemplate;


    @GetMapping("/send/{text}")
    void sendTo(@PathVariable String text){
        HelloMessage message = new HelloMessage(text);
        simpMessagingTemplate.convertAndSend( "/topic/greetings", message);
    }
}
