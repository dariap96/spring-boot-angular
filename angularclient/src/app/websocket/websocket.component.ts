import { Component, OnInit } from '@angular/core';
import {WebSocketAPI} from "../wsService";

@Component({
  selector: 'ws',
  templateUrl: './websocket.component.html',
  styleUrls: ['./websocket.component.css']
})

export class WebsocketComponent implements OnInit {
  title = 'angular8-springboot-websocket';

  webSocketAPI: WebSocketAPI;
  greeting: any;
  name: string;
  ngOnInit() {
    this.webSocketAPI = new WebSocketAPI(new WebsocketComponent());
  }

  connect(){
    this.webSocketAPI._connect();
  }

  disconnect(){
    this.webSocketAPI._disconnect();
  }

  sendMessage(){
    this.webSocketAPI._send(this.name);
  }

  handleMessage(message){
    this.greeting = message;
  }
}
