import { Component } from '@angular/core';
import { User } from '../user';
import { userMap } from '../userMap';
@Component({
  selector: 'app-login-register',
  templateUrl: './login-register.component.html',
  styleUrls: ['./login-register.component.css']
})
export class LoginRegisterComponent {
  submitted: boolean = false;
  username: string = "";
  password: string ="";
  strFormOutput?: string;
  user?: User;
  users = userMap;

  onSubmit() { this.submitted=true; this.checkUsernamePassword();}

  checkUsernamePassword(): User | void {
    //const keyList: string[] = [];
    //let keyArr = Array.from(this.users.keys() );
    //keyList.push(this.username);
    //keyList.push(this.password);
    let validationInput: string = this.username + " " + this.password;
    //this.strFormOutput = "Checkz for user";
    if (userMap.has(validationInput)) {this.strFormOutput="valid"}
    else { this.strFormOutput=`This username and/or password is invalid and your input was ${this.username},
        ${this.password} and the first key is ${Array.from(this.users.keys())}`;}
  }

  resetUserPassword(): void {
    this.username="";
    this.password="";
  }

}
