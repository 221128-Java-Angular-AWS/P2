import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ui';

  //These 2 will be sent into the module to display the current account or the account that made a post
  user = {
    username : "joejoeMan",
    firstName : "Dio",
    lastName : "Brando",
    desc: "MudaMudaMudaMudaMudaMudaMudaMudaMudaMudaMudaMuda"
  }

  active = true;

  updateUser(user2: any) {
    this.user = user2;
    console.log("Updated: " + this.user.username);
  }
}
