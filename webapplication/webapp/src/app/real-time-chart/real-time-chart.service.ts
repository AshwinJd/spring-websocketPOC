import { Injectable } from '@angular/core';
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class RealTimeChartService {
  private serverUrl = 'http://localhost:8080/profile/socket'
  private stompClient;

  constructor() { }

  initializeWebSocketConnection(){
    let ws = new SockJS(this.serverUrl, null, { 'protocols_whitelist': ['websocket']});
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/topic/server-broadcaster", (message) => {
        if(message.body) {
          console.log(message.body);
        }
      });
    });
  }

}
