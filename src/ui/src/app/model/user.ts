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