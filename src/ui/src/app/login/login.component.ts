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
    this.checkUsernamePassword();
  }

  checkUsernamePassword(): User | void {
   /*
    this.authService.authenticateUser(this.username, this.password).subscribe(users => {
      this.user = users[0];
      this.cookieService.setCurrentUser(this.user);
      this.goToUserPage(this.user.userId);
*/
    this.authService.authenticateUser(this.username, this.password).subscribe(user => {
      this.printNotification(user);
      console.log(user);
      this.cookieService.setCurrentUser(user);

    });
    if (this.cookieService.getCurrentUser() != undefined) {
      this.router.navigate(['/home']);
    }
  }

  goToUserPage() {
    this.router.navigate(['/home'])
  }


  resetUserPassword(): void {
    this.username="";
    this.password="";
  }

  printNotification(user: User) {
    this.strout = user.username + " just signed in";
    this.goToUserPage();
}


}