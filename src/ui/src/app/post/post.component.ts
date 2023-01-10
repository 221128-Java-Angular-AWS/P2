import { Component, Input  } from '@angular/core';
import { Post } from '../Services/posts.service';
import { Comment } from '../comment';
import { CommentsService } from 'app/Services/comments.service';
import { User } from 'app/model/user';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent {
  @Input()
  post!: Post;
  comments: Comment[] = [];

  constructor(private commentService: CommentsService) {}

  createComment(post: Post, postId: number = 2, message: string) {
    let user = new User(1, "test");
    let comment = new Comment(postId, user.userId, message, user, post);
    this.commentService.postComment(postId, comment).subscribe();
  }


  clickMoreComments(post: Post): void {
    post.clicked = true;
  }
}
