import { Component, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent { 

  @Input() user = { username : '', firstName : '', lastName : '', desc : '' };

  @Input() activeUser = false;

  @Output() updateUserEvent = new EventEmitter<any>();

  editUser = false;

  currentUser = {
    username : '',
    firstName : '',
    lastName : '',
    desc : ''
  }

  ngOnInit() {
    this.currentUser.username = this.user.username;
    this.currentUser.firstName = this.user.firstName;
    this.currentUser.lastName = this.user.lastName;
    this.currentUser.desc = this.user.desc;
  }
  
  editMode(): void {
    this.editUser = true;
  }

  cancel(): void {
    this.editUser = false;
  }

  save(uName: string, fName: string, lName: string, newDesc: string): void {
    this.currentUser.username = uName;
    this.currentUser.firstName = fName;
    this.currentUser.lastName = lName;
    this.currentUser.desc = newDesc;

    this.updateUserEvent.emit(this.currentUser);
    this.editUser = false;
  }
}
