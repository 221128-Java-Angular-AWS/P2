import { Post } from "app/Services/posts.service";

export class User{
  userId ?: number | null;
  username ?: string;
  password?: string;
  email?: string;
  firstName?: string;
  lastName?: string;
  bio?: string;
  posts?: Post[];
  securityQuestion?: string;
  securityAnswer?: string;

  constructor(username: string, userId?:  number|null, password?: string, email?: string, 
    firstName?: string, lastName?: string, bio?: string, securityQuestion?: string, securityAnswer?: string) {
      this.userId = userId;
      this.username = username;
      this.password = password;
      this.email = email;
      this.firstName = firstName;
      this.lastName = lastName;
      this.bio = bio;
      this.securityQuestion = securityQuestion;
      this.securityAnswer = securityAnswer;
    }
}

export class RecoverUser {
  username?: string;
  email?: string

  constructor(username: string, email: string) {
    this.username = username;
    this.email = email;
  }
}