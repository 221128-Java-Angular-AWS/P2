import { Component, Input } from '@angular/core';
import { Comment } from '../comment';
import { Post, PostsService } from 'app/Services/posts.service';
import { CommentsService } from 'app/Services/comments.service';
import { ActivatedRoute } from '@angular/router';
import { Reply } from 'app/reply';
import { User } from 'app/model/user';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css']
})
export class CommentComponent {
  constructor(
    private commentService: CommentsService
  ) {}


  @Input() post?: Post | any;
  @Input() comments?: Comment[] = [];
  @Input() replies?: Reply[] = [];

  ngOnInit(): void {
  }

  createReply(post: Post, comment: Comment, postId: number, commentId: number = 1, message: string) {
    console.log(post);
    console.log(comment);
    let username = "test";
    let user = new User(1, "test");
    let reply = new Reply(commentId, user.userId, message, username, user);
    this.commentService.postReply(postId, commentId, reply).subscribe();
  }
}
