import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PostsService {

  constructor() { }

  createPost(postText: string, imageLink: string): void{
    //make the post
    console.log(postText, imageLink);
  }
}
