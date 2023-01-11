import { Injectable } from '@angular/core';
import { User } from 'app/user';

@Injectable({
  providedIn: 'root'
})
export class CookieService {
  user?: User;
  constructor() { }

  setCurrentUser(u: User): void {
    this.user = u;
  }

  getCurrentUser(): User | undefined {
    return this.user;
  }
  
}
