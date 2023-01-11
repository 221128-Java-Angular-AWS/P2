import { Component, Input  } from '@angular/core';
import { Post, PostsService } from '../Services/posts.service';
import { Comment } from '../comment';
import { CommentsService } from 'app/Services/comments.service';
import { User } from 'app/model/user';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css'],
})
export class PostComponent {
  @Input()
  post!: Post;

  @Input()
  posts!: Post[]

  clicked: boolean = false;
  
  constructor(private commentService: CommentsService, private postsService: PostsService) {
  }

  createComment(post: Post, message: string) {
    let user = new User("test", 1);
    let comment = new Comment((post.postId ? post.postId : 1), (user.userId ? user.userId : 1), message, user, post);
    this.commentService.postComment((post.postId ? post.postId : 1), comment).subscribe((comment) => {
      this.post.comments.push(comment);
    });
  }

  clickMoreComments(post: Post): void {
    post.clicked = true;
    this.clicked = true;
  }

  deletePostById(postId: number): void {
    this.postsService.deletePostById(postId);
  }
}
