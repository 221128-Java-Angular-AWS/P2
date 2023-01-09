import { Component, Input  } from '@angular/core';
import { Post } from '../Services/posts.service';
import { Comment } from '../comment';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent {
  @Input()
  post!: Post;
  comments: Comment[] = [];


  clickMoreComments(post: Post): void {
    post.clicked = true;
  }
}
