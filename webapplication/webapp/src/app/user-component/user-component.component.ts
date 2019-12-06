import { MessagingService } from './../shared-services/messaging.service';
import { UserComponentService } from './user-component.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { HttpClient } from '@angular/common/http';

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
    this.userProfileSubmitForm = this.formBuilder.group({
      name: "",
      age: 0
    });

  }

  ngOnInit() {
    // this.http.get('/userservice/api/v1/users/').subscribe(data => {
    //   this.usersList = data;
    // });
  }

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
