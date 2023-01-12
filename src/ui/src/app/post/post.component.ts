import { Component, Input } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from "@angular/platform-browser";
import { Post, PostsService } from '../Services/posts.service';
import { Comment } from '../comment';
import { CommentsService } from 'app/Services/comments.service';
import { CookieService } from 'app/Services/cookie-service.service';
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

  @Input()
  removePostFromFeed!: Function;

  comments: Comment[] = [];
  canDelete: boolean = false;

  clicked: boolean = false;

  constructor(
    private postsService: PostsService,
    private commentService: CommentsService,
    public _sanitizer: DomSanitizer,
    private cookieService: CookieService
  ) { }

  createComment(post: Post, message: string) {
    let user: User | undefined = this.cookieService.getCurrentUser();
    if (user == undefined) {
      alert('Must be signed in to create comments');
    } else if (user) {
      let comment = new Comment((post.postId ? post.postId : 1), (user.userId ? user.userId : 1), message, user, post);
      this.commentService.postComment((post.postId ? post.postId : 1), comment).subscribe((comment) => {
        this.post.comments.push(comment);
        this.commentService.getComments(this.post.postId ? this.post.postId : 1);
      });
    }

  }

  embedYoutube: Boolean = false;
  youtubeLink!: string;
  safeYoutubeLink!: SafeResourceUrl;

  ngOnInit(): void {
    this.canDelete = (this.cookieService.getCurrentUser()?.userId == this.post.userId);
    this.youtubeLink = this.parseForYoutube(this.post.message) || this.youtubeLink;
    this.safeYoutubeLink = this._sanitizer.bypassSecurityTrustResourceUrl(this.youtubeLink);
  }

  clickMoreComments(post: Post): void {
    post.clicked = true;
    this.clicked = true;
  }

  deletePost(post: Post): void {
    this.postsService.deletePostById(post.postId!);
    this.removePostFromFeed(post);
  }

  parseForYoutube(message: String) {
    if (message.includes("youtube.com/watch?v=")) {
      this.embedYoutube = true;
      let cutoff = message.lastIndexOf("youtube.com/watch?v=") + 20;
      let valid = /^[-a-zA-Z0-9_]*$/;
      for (let i = cutoff; i < message.length; i++) {
        if (!message[i].match(valid)) {
          return "https://youtube.com/embed/" + message.slice(cutoff, i);
        }
      } return "https://youtube.com/embed/" + message.slice(cutoff);
    }
    return '';
  }
}
