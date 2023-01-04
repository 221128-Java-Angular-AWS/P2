import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent {

  username = 'jDoe234';
  firstName = 'John';
  lastName = 'Doe';
  desc = 'Just any ol guy';

  editUser() {

  }

}
