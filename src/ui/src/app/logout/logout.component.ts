import { Component } from '@angular/core';
import { CookieService } from 'app/Services/cookie-service.service';
@Component({
  selector: 'app-logout',
  templateUrl: './logout.component.html',
  styleUrls: ['./logout.component.css']
})
export class LogoutComponent {

  constructor(public cookieService: CookieService) {}

  logout(): void { 
    this.cookieService.deleteCookie();
  }

}
