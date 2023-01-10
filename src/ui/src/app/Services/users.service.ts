import { Injectable } from '@angular/core';
import { first } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor() { }
}

export class User{
  private userId: number;
  private firstName?: string;
  private lastName?: string;
  private username: string;
  private password?: string;
  private email?: string;
  private bio?: string;

  constructor(userId: number, username: string, password?: string, firstName?: string, lastName?: string, email?: string, bio?: string) {
    this.userId = userId;
    this.username = username;
    this.password = password;
    this.firstName = firstName; 
    this.lastName = lastName;
    this.email = email;
    this.bio = bio;
  }
}