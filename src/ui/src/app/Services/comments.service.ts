import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, of, retry } from 'rxjs';
import { Comment } from '../comment';
import { Reply } from 'app/reply';

@Injectable({
  providedIn: 'root'
})
export class CommentsService {
  baseUrl: string = "http://localhost:8080";

  options = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
  
  constructor(private http: HttpClient) { }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      return of(result as T);
    }
  }
  
  getComments(postId: number): Observable<Comment[]> {
    const url = `${this.baseUrl}/posts/${postId}/comments;`;
    return this.http.get<Comment[]>(url)
      .pipe(retry(1), catchError(this.handleError<Comment[]>('getComments', [])));
  }

  postComment(postId: number, comment: Comment): Observable<Comment> {
    const url = `${this.baseUrl}/posts/${postId}/comments;`;
    return this.http.post<Comment>(url, JSON.stringify(comment), this.options)
      .pipe(retry(1), catchError(this.handleError<Comment>('postComment')));
  }

  putComment(postId: number, comment: Comment): Observable<Comment> {
    const url = `${this.baseUrl}/posts/${postId}/comments;`;
    return this.http.put<Comment>(url, JSON.stringify(comment), this.options)
      .pipe(retry(1), catchError(this.handleError<Comment>('putComment')));
  }

  deleteComment(postId: number, comment: Comment): Observable<Comment> {
    const url = `${this.baseUrl}/posts/${postId}/comments;`;
    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      body: JSON.stringify(comment)
    }
    return this.http.delete<Comment>(url, options)
      .pipe(retry(1), catchError(this.handleError<Comment>('deleteComment')));
  }

  getReplies(postId: number, commentId: number): Observable<Reply[]> {
    const url = `${this.baseUrl}/posts/${postId}/comments/${commentId}`;
    return this.http.get<Reply[]>(url)
      .pipe(retry(1), catchError(this.handleError<Reply[]>('getReply', [])));
  }

  postReply(postId: number, commentId: number, comment: Comment, reply: Reply): Observable<Reply> {
    const url = `${this.baseUrl}/posts/${postId}/comments/${comment.commentId}`;
    console.log('postId: ', postId);
    console.log('commentId: ', commentId);
    console.log('reply: ', reply);
    reply.comment = comment;
    return this.http.post<Reply>(url, JSON.stringify(reply), this.options)
      .pipe(retry(1), catchError(this.handleError<Reply>('postReply')));
  }

  putReply(postId: number, commentId: number, reply: Reply): Observable<Reply> {
    const url = `${this.baseUrl}/posts/${postId}/comments/${commentId}`;
    return this.http.put<Reply>(url, JSON.stringify(reply), this.options)
      .pipe(retry(1), catchError(this.handleError<Reply>('putReply')));
  }

  deleteReply(postId: number, commentId: number, reply: Reply) {
    const url = `${this.baseUrl}/posts/${postId}/comments/${commentId}`;
    let options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      }),
      body: JSON.stringify(reply)
    }
    return this.http.delete<Reply>(url, options)
      .pipe(retry(1), catchError(this.handleError<Reply>('deleteReplies')));
  }


}
