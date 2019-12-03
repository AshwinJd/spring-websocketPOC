import { Injectable } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
 
import { StompService, StompConfig, StompState } from "@stomp/ng2-stompjs";
import { Message } from "@stomp/stompjs";

@Injectable({
  providedIn: 'root'
})
export class MessagingService {
  private messages: Observable<Message>;
  private stompService: StompService;

  constructor(socketUrl: string, streamUrl: string) { 
    let stompConfig: StompConfig = {
      url: socketUrl,
      headers: {
        
      },
      heartbeat_in: 0,
      heartbeat_out: 20000,
      reconnect_delay: 5000,
      debug: true
    };

    // Create Stomp Service
    this.stompService = new StompService(stompConfig);
    console.log("CHECK", this.stompService);
    // Connect to a Stream
    this.messages = this.stompService.subscribe(streamUrl);
    console.log("messages::---0", this.messages);
  }

  public stream(): Observable<Message> {
    return this.messages;
  }

  public send(url: string, message: any) {
    return this.stompService.publish(url, JSON.stringify(message));
  }

  public state(): BehaviorSubject<StompState> {
    return this.stompService.state;
  }
}
