import { Component } from '@angular/core';
import { User } from '../user';

@Component({
  selector: 'app-reset-credentials',
  templateUrl: './reset-credentials.component.html',
  styleUrls: ['./reset-credentials.component.css']
})
export class ResetCredentialsComponent {

  username: string="";
  password: string="";
  email: string="";
  out: string = "";
  listUsernames: string[] = [];
  listEmails: string[] = [];

  /*
  validate(): void {
    this.getUsernamesAndEmails();

    if(this.listUsernames.includes(this.username)){
      this.out = "This username is already taken!"
    } else if (this.listEmails.includes(this.username)){
      this.out = "It looks like you already have an account!"
    } else{
        if (this.username.length>2 && this.password.length>2 && this.email.length>2){
          if (!this.email.includes("@")){
            this.out = "Your email is not valid"
          } else {
            this.createUser();
            this.out = "Account created!";
          }
       }
    }
  }
  */


}


