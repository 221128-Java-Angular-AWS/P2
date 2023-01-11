import { ChangeDetectionStrategy, ChangeDetectorRef, Component, Input } from '@angular/core';
import { Comment } from '../comment';
import { Post } from 'app/Services/posts.service';
import { CommentsService } from 'app/Services/comments.service';
import { Reply } from 'app/reply';

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

  deleteComment(comment: Comment) {
    this.commentService.deleteComment(comment.postId, comment).subscribe();
    console.log(comment);
    this.post.comments.forEach((value, index) => {
      if (value === comment) {
        this.post.comments.splice(index, 1);
      }
    });
  }
}
