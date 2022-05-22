package com.web.springbootangular.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageExceptionHandler;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import com.google.gson.Gson;

import java.util.Map;

@Controller
public class WsController {
    private final SimpMessagingTemplate template;

    @Autowired
    public WsController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/message")
    @SendTo("/topic/reply")
    public String processMessageFromClient(@Payload String message) throws Exception {
        String name = new Gson().fromJson(message, Map.class).get("name").toString();
        return name;
    }

    @MessageExceptionHandler
    public String handleException(Throwable exception) {
       template.convertAndSend("/errors", exception.getMessage());
        return exception.getMessage();
    }
}
