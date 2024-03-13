package com.example.springwebsocket.controller;

import com.example.springwebsocket.dto.Greeting;
import com.example.springwebsocket.dto.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }

    /**
     * Another way to send messages is using:
     *
     * @Autowired
     * SimpMessagingTemplate socketTemplate;
     *
     * socketTemplate.convertAndSend("/topic/greetings", dto);
     */
}
