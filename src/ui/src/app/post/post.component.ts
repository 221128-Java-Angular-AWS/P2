import { Component, Input } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from "@angular/platform-browser";
import { Post, PostsService } from '../Services/posts.service';
import { Comment } from '../comment';
import { CookieService } from 'app/Services/cookie-service.service';
import { User } from 'app/model/user';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent {
  @Input() post!: Post;
  @Input() removePostFromFeed!: Function;
  comments: Comment[] = [];
  canDelete: boolean = false;

  constructor(private postsService: PostsService, public _sanitizer: DomSanitizer, private cookieService: CookieService) {

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
  }

  deletePost(post: Post): void {
    try {
      this.postsService.deletePostById(post.postId!);
    }
    catch (err: any) {
      console.log(err);
    }
    finally {
      this.removePostFromFeed(post);
    }
  }

   parseForYoutube(message: String) {
    if (message.includes("youtube.com/watch?v=")) {
      let cutoff = message.lastIndexOf("youtube.com/watch?v=") + 20;
      let valid = /^[a-zA-Z0-9_]*$/;
      try {
        for (let i = cutoff; i < message.length; i++) {
          if (!message[i].match(valid)) {
            this.embedYoutube = true;
            return "https://youtube.com/embed/" + message.slice(cutoff, i);
          }
        }
        this.embedYoutube = true;
        return "https://youtube.com/embed/" + message.slice(cutoff);
      }
      catch (err: any) {
        console.log(err);
        return '';
      }
    }
      return '';
  }
}
