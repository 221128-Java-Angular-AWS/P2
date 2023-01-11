import { Component, Input} from '@angular/core';
import { User } from 'app/model/user';
import { CookieService } from 'app/Services/cookie-service.service';
import { UsersService } from 'app/Services/users.service';

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent { 

  @Input() activeUser = false;

  @Input() userId = -1;

  editUser = false;

  currentUser?: User;

  constructor (private userService: UsersService, private cookieService: CookieService) {}

  ngOnInit() {
    //this.userService.getUser(this.userId).subscribe((response:User) => {
  //  this.currentUser = response;
    if(this.cookieService.getCurrentUser() != undefined){
    this.currentUser = this.cookieService.getCurrentUser()
    }
  }
  
  editMode(): void {
    this.editUser = true;
  }

  cancel(): void {
    this.editUser = false;
  }

  save(uName: string, fName: string, lName: string, newDesc: string): void {

    let newUser = new User('', -1);
    if (this.currentUser != undefined ) {
    newUser.userId = this.currentUser.userId;}

    newUser.username = uName;
    newUser.firstName = fName;
    newUser.lastName = lName;
    newUser.bio = newDesc;

    this.currentUser = newUser;
    
    this.userService.updateUser(newUser).subscribe();

    this.editUser = false;
    
  }
}