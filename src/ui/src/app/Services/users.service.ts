import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders ,HttpParams } from '@angular/common/http';
import { User } from 'app/model/user';
import { Observable } from 'rxjs';
import { first } from 'rxjs';

@Injectable({providedIn: 'root'})
export class UsersService {

  private usersUrl: string;

  httpOptions = {
    headers : new HttpHeaders({
      "Content-Type" : "application/json"})
    }

  constructor(private http : HttpClient) {
    this.usersUrl = "http://localhost:8080/users";
  }

  public getUser(id : number) : Observable<User> {

    let queryParams = new HttpParams();
    queryParams = queryParams.append("userId", id);
    
    return this.http.get<User>(this.usersUrl, {params:queryParams});
  }

  public updateUser(user : User) : Observable<User> {

    console.log(user.userId);
    console.log(user.username);

    return this.http.put<User>(this.usersUrl, user, this.httpOptions);
  }
}