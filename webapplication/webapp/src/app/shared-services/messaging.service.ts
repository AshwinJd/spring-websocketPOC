import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
 
import Stomp from 'stompjs';
import SockJS from 'sockjs-client';

@Injectable({
  providedIn: 'root'
})
export class MessagingService {
  private serverUrl = 'http://localhost:8080/profile/socket'
  private stompClient;
  public realtimeSubject = new Subject();

  constructor() {
    // this.initializeWebSocketConnection();
  }
  
  initializeWebSocketConnection(){
    let ws = new SockJS(this.serverUrl, null, { 'protocols_whitelist': ['websocket']});
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, (frame) => {
      that.stompClient.subscribe("/topic/server-broadcaster", (message) => {
        if(message.body) {
          this.realtimeSubject.next(message.body);
        }
      });
    });
  }
}