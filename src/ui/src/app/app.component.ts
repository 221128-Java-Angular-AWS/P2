import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'ui';

  //This will compare if the logged in user is the same as the current user profile
  active = true;

  //This value will be grabbed from the session cookie
  userId = 1;

  constructor () {

  }
}
