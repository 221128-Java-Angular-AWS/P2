import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, retry, throwError, Observable, of } from 'rxjs';
import { Comment } from '../comment';
import { Like } from '../like';
import { User } from './users.service';

@Injectable({
  providedIn: 'root'
})
export class PostsService {

  constructor(private http: HttpClient) {}

  baseUrl: string = "http://localhost:8080";

  postsUrl: string = "/posts/feed";

  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }


  createPost(postText: string, imageLink: string, username: string){
    //make the post
    //NOTE: I added the username and empty arrays to satisfy the expanded constructor. -Travis M.
    let user: User = new User(1, "braydensn")
    let newPost = new Post(postText, imageLink, [], [], username, user);
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



  getPosts(): Observable<Post[]> {
    return this.http.get<Post[]>(this.baseUrl + this.postsUrl)
    .pipe(
      catchError(this.handleError<Post[]>('getPosts', []))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    }
  }
}

export class Post{
  postId?: number;
  message: string;
  imageLink: string;
  datePosted?: string;
  user?: User;
  username?: string;
  clicked?: boolean;
  comments: Comment[];
  likes: Like[];

  constructor(message: string, imageLink: string, likes: Like[], comments: Comment[], username?: string, user?: User, datePosted?: string, postId?: number, clicked?: boolean){
    this.postId = postId;
    this.message = message;
    this.imageLink = imageLink;
    this.datePosted = datePosted;
    this.user = user;
    this.clicked = clicked;
    this.likes = likes;
    this.comments = comments;
    this.username = username;
  }
}
