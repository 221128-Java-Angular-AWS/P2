import { Component } from '@angular/core';
import { User } from '../user';
import { userMap } from '../userMap';
import { HttpClientModule } from '@angular/common/http';
import { AuthenticationService } from 'app/Services/authentication.service';


@Component({
  selector: 'app-login-register',
  templateUrl: './login-register.component.html',
  styleUrls: ['./login-register.component.css']
})
export class LoginRegisterComponent {
  constructor(private authService: AuthenticationService) {}

  submitted: boolean = false;
  username: string = "";
  password: string ="";
  strFormOutput?: string;
  user?: User;
  users = userMap;

  onSubmit() { 
    this.submitted=true; 
    this.checkUsernamePassword();}

  checkUsernamePassword(): User | void {
    
    this.authService.authenticateUser(this.username, this.password).subscribe(users => {
      this.strFormOutput = JSON.stringify(users);
      this.user = users;
    });
    this.strFormOutput = "OOO";

    //let keyArr = Array.from(this.users.keys() );
    //keyList.push(this.username);
    //keyList.push(this.password);
    
    //this.strFormOutput = "Checkz for user";
    /*
    let validationInput: string = this.username + " " + this.password;
    if (userMap.has(validationInput)) {this.strFormOutput="valid"}
    else { this.strFormOutput=`This username and/or password is invalid and your input was ${this.username},
        ${this.password}}`;}
    */
  }

  goToUserPage() {}

  resetUserPassword(): void {
    this.username="";
    this.password="";
  }

  printNotification() {
      this.strFormOutput
  }


}
