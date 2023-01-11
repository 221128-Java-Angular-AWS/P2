import { Component, Input  } from '@angular/core';
import { Post, PostsService } from '../Services/posts.service';
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

  constructor(private postsService: PostsService) {

  }

  clickMoreComments(post: Post): void {
    post.clicked = true;
  }

  deletePostById(postId: number): void {
    this.postsService.deletePostById(postId);
  }
}
