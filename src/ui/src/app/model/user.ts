export class User {

        userId: number;
        firstName?: string;
        lastName?: string;
        username: string;
        password?: string;
        email?: string;
        bio?: string;
              
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