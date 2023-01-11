import { Component, Input } from '@angular/core';
import { Comment } from '../comment';
import { Post } from 'app/Services/posts.service';
import { CommentsService } from 'app/Services/comments.service';
import { Reply } from 'app/reply';
import { User } from 'app/model/user';

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrls: ['./comment.component.css'],
})
export class CommentComponent {
  constructor(
    private commentService: CommentsService
  ) {}

  @Input() post!: Post;
  @Input() comments!: Comment[];
  @Input() commentId!: number;

  deleteComment(comment: Comment) {
    this.commentService.deleteComment(comment.postId, comment).subscribe();
    this.post.comments.forEach((value, index) => {
      if (value === comment) {
        this.post.comments.splice(index, 1);
      }
    });
  }

  createReply(post: Post, comment: Comment, message: string) {
    let user = new User("test", 1);
    let reply = new Reply((comment.commentId ? comment.commentId : 1), (user.userId ? user.userId : 1), message, (user.username ? user.username : "test"), post, comment, user, post.postId);
    this.commentService.postReply(comment.postId, (comment.commentId ? comment.commentId : 1), comment, reply).subscribe(() => {
      this.post.comments.forEach((value, index) => {
        if (value === comment) {
          this.post.comments[index].replies?.push(reply);
        }
      });
    });
  }

  deleteReply(comment: Comment, reply: Reply) {
    let i: number = 0;
    this.commentService.deleteReply((reply.postId ? reply.postId : 1), reply.commentId, reply).subscribe();
    this.post.comments.forEach((value, index) => {
      if (value === comment) {
        i = index;
        this.post.comments[index].replies?.forEach((value, index) => {
          if (value === reply) {
            this.post.comments[i].replies?.splice(index, 1);
          }
        })
      }
    });
  }
}
