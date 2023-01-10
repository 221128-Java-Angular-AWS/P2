import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Post } from './posts.service';
import { first } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UsersService {

  constructor(private http: HttpClient) { }
  baseUrl: string = "http://localhost:8080";
  userUrl: string = "/users";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  createUser(username: string, password: string, email: string, firstName: string, lastName: string, bio: string){
    let newUser = new User(username, null, password, email, firstName, lastName, bio);
    return this.http.post<User>(this.baseUrl + this.userUrl, JSON.stringify(newUser), this.httpOptions);
  }
}

export class User{
  userId ?: number | null;
  username ?: string;
  password?: string;
  email?: string;
  firstName?: string;
  lastName?: string;
  bio?: string;
  posts?: Post[];
  constructor(username: string, userId?:  number|null, password?: string, email?: string, 
    firstName?: string, lastName?: string, bio?: string) {
      this.userId = userId;
      this.username = username;
      this.password = password;
      this.email = email;
      this.firstName = firstName;
      this.lastName = lastName;
      this.bio = bio;
    }
}