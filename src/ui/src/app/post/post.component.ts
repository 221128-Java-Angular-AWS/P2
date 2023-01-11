import { Component, Input } from '@angular/core';
import { DomSanitizer, SafeResourceUrl } from "@angular/platform-browser";
import { Post, PostsService } from '../Services/posts.service';
import { Comment } from '../comment';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent {
  @Input() post!: Post;
  @Input() removePostFromFeed!: Function;
  comments: Comment[] = [];

  constructor(private postsService: PostsService, public _sanitizer: DomSanitizer) {

  }

  embedYoutube: Boolean = false;
  youtubeLink!: string;
  safeYoutubeLink!: SafeResourceUrl;

  ngOnInit(): void {
    this.youtubeLink = this.parseForYoutube(this.post.message) || this.youtubeLink;
    this.safeYoutubeLink = this._sanitizer.bypassSecurityTrustResourceUrl(this.youtubeLink);
  }

  clickMoreComments(post: Post): void {
    post.clicked = true;
  }

  deletePost(post: Post): void {
    this.postsService.deletePostById(post.postId!);
    this.removePostFromFeed(post);
  }

   parseForYoutube(message: String) {
    if (message.includes("youtube.com/watch?v=")) {
      this.embedYoutube = true;
      let cutoff = message.lastIndexOf("youtube.com/watch?v=") + 20;
      let valid = /^[a-zA-Z0-9_]*$/;
      for (let i = cutoff; i < message.length; i++) {
        if (!message[i].match(valid)) {
          return "https://youtube.com/embed/" + message.slice(cutoff, i);
        }
      } return "https://youtube.com/embed/" + message.slice(cutoff);
    }
    return '';
  }
}
