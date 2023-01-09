import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, retry, throwError } from 'rxjs';
import { User } from './users.service';

@Injectable({
  providedIn: 'root'
})
export class PostsService {

  constructor(private http: HttpClient) {}

  baseUrl: string = "http://localhost:8080";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  createPost(postText: string, imageLink: string){
    //make the post
    let user: User = new User(1, 'braydensn', 'password1234', 'Brayden', 'Nordine', 'brayden018@revature.net', 'Just a coder makin this app')
    let newPost = new Post(postText, imageLink, 1);
    console.log("New Post: ", newPost);
    return this.http.post<Post>(this.baseUrl + "/posts", JSON.stringify(newPost), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.errorHand1)
      );
  }

  
  errorHand1(error: any){
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      // Get client-side error
      errorMessage = error.error.message;
    } else {
      // Get server-side error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  }

}

export class Post{
  postId?: number;
  message: string;
  imageLink: string;
  datePosted?: string;
  user: number;

  constructor(message: string, imageLink: string, user: number, datePosted?: string, postId?: number){
    this.postId = postId;
    this.message = message;
    this.imageLink = imageLink;
    this.datePosted = datePosted;
    this.user = user;
  }

}
