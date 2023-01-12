import { Component } from '@angular/core';
import { User } from '../user';
import { userMap } from '../userMap';
import { HttpClientModule } from '@angular/common/http';
import { AuthenticationService } from 'app/Services/authentication.service';
import { CookieService } from 'app/Services/cookie-service.service';
import { Router, ActivatedRoute} from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  constructor(private authService: AuthenticationService, private cookieService: CookieService, private route: ActivatedRoute, private router: Router) {}


  submitted: boolean = false;
  username: string = "";
  password: string ="";
  strFormOutput?: string;
  user?: User;
  u?: User;
  strout?: string = "Here is the first name!";

  onSubmit() { 
    this.submitted=true; 
<<<<<<< HEAD
    // this.checkUsernamePassword();
=======
    this.checkUsernamePassword();
>>>>>>> e6c5d232728e9f0406e1df0fc000c13122123423
  }

  checkUsernamePassword(): User | void {
    this.authService.authenticateUser(this.username, this.password).subscribe(users => {
      this.user = users[0];
      this.printNotification(this.user);
      this.cookieService.setCurrentUser(this.user);
    });

    if (this.cookieService.getCurrentUser() != undefined) {
      this.router.navigate(['home']);
    }
  }

<<<<<<< HEAD
  checkUP(): User | void {
    this.authService.authenticateUser2(this.username, this.password).subscribe(users => {
      this.user = users;
      this.cookieService.setCurrentUser(this.user);
      console.log(this.user);
    });
  }
/*
  checkUP = async () =>{
    let match = await this.authService.authenticate(this.username, this.password)!
    if(match){
      console.log('logged in')
    }else{
      console.log('denied')
    }
    
    let res = await this.authService.authenticate(this.username, this.password);
    if(res! == true){
      console.log('logged in')
    }
    else{
      console.log('denied')
    }
  }*/

  goToUserPage() {}
=======
  goToUserPage(id : number) {
    this.router.navigate(['/home'])
  }
>>>>>>> e6c5d232728e9f0406e1df0fc000c13122123423

  resetUserPassword(): void {
    this.username="";
    this.password="";
  }

  printNotification(user: User) {
      this.strout = user.username + " just signed in";
      this.goToUserPage(user.userId);
  }
}