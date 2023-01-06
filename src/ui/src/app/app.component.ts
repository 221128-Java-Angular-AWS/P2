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
    username : "ZaWorldo1867",
    firstName : "Dio",
    lastName : "Brando",
    desc: "MudaMudaMudaMudaMudaMudaMudaMudaMudaMudaMudaMuda",
    pic: "assets/DioImg.jpg"
  }

  active = true;

  updateUser(user: any) {
    this.user = user;
    console.log("Updated: " + this.user.username);
  }
}
