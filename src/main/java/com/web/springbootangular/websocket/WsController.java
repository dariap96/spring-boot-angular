package com.web.springbootangular.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class WsController {
    private final SimpMessagingTemplate template;

    @Autowired
    public WsController(SimpMessagingTemplate template) {
        this.template = template;
    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public ResponseMessage greeting(Message message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new ResponseMessage(HtmlUtils.htmlEscape(message.getMessage()));
    }
}
