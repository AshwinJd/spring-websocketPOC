import { MessagingService } from './../shared-services/messaging.service';
import { UserComponentService } from './user-component.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { Message } from "@stomp/stompjs";
import { StompState } from "@stomp/ng2-stompjs";

const WEBSOCKET_URL = "ws://localhost:8080/profile/socket";
const EXAMPLE_URL = "/topic/server-broadcaster";
@Component({
  selector: 'app-user-component',
  templateUrl: './user-component.component.html',
  styleUrls: ['./user-component.component.css']
})
export class UserComponentComponent implements OnInit {
  userProfileSubmitForm;
  messageHistory = [];
  private messagingService: MessagingService;
  state: string = "NOT CONNECTED";
  usersList: any = [];
  constructor(private formBuilder: FormBuilder,
    private http: HttpClient,
    private userComponentService: UserComponentService,
    ) {
    // this.messagingService = new MessagingService(WEBSOCKET_URL, EXAMPLE_URL)
    this.userProfileSubmitForm = this.formBuilder.group({
      name: "",
      age: 0
    });

    // this.messagingService.stream().subscribe((message: Message) => {
    //   this.messageHistory.unshift(message.body);
    //   console.log("Message:--", message);
    // });

    // // Subscribe to its state (to know its connected or not)
    // this.messagingService.state().subscribe((state: StompState) => {
    //   this.state = StompState[state];
    // });
  }

  ngOnInit() {
    // this.http.get('/userservice/api/v1/users/').subscribe(data => {
    //   this.usersList = data;
    // });
  }

  realTimeCommunication() {
    this.userComponentService.initializeWebSocketConnection();
  }

  // // Use this methods to send message back to server
  // sendAction() {
  //   console.log("Sending message");
  //   this.messagingService.send("/server-receiver", {
  //     text: "This is cool",
  //     text2: "I'm so happy!"
  //   });
  // }

  onSubmit(userData) {
    // Process checkout data here
    // const url = "/userservice/api/v1/users";
    console.warn('User data that is getting saved::-', userData);
    this.http.post('/userservice/api/v1/users', userData).subscribe(data => {
      this.usersList.push(data);
    });
    return;
  }
}
