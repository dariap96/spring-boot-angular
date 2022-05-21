package com.web.springbootangular.websocket;

public class ResponseMessage {
    private String response;

    public ResponseMessage() {
    }

    public ResponseMessage(String content) {
        this.response = content;
    }

    public String getContent() {
        return response;
    }
}
