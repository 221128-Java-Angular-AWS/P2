import { Component } from '@angular/core';
import { UsersService } from 'app/Services/users.service';
import { User } from 'app/model/user';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent {
  users: User[] = [];
  noResults = false;

  constructor(private userService: UsersService){}

  searchForUsers(filter: string){
    this.noResults = false;
    if(filter == ""){
      this.users = [];
    }
    else{
      this.userService.searchUsers(filter)
      .subscribe((users) => {
        this.users = users;
        if(users.length == 0){
          this.noResults = true;
        }
      });
    }
  }

  resetSearch(){
    this.users = [];
    (<HTMLInputElement>document.getElementById("searchbar")).value = "";
    this.noResults = false;
  }
}
