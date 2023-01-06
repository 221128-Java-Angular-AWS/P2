import { Component } from '@angular/core';
import { User } from '../user';
import { userMap } from '../userMap';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  users = userMap;
  username: string="";
  password: string="";
  email: string="";
  out: string = "";
  listUsernames: string[] = [];
  listEmails: string[] = [];

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
  createUser(): void {
    let user = new User(this.username,this.password,this.email);
    userMap.set(this.username + " "+ this.password, user);
  }


  getUsernamesAndEmails() {
    for (let user of this.users.values()) {
      this.listEmails.push(user.email);
      this.listUsernames.push(user.username);
    }
  }
}
