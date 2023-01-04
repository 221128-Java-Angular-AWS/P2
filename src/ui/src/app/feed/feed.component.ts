import { Component } from '@angular/core';
import { PostsService } from '../Services/posts.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent {
  imageLink: string = "";
  constructor(private postsService: PostsService) {
  }

  createPost(text: string): void{
    if(text != "" || this.imageLink != ""){
      this.postsService.createPost(text, this.imageLink);
      (<HTMLInputElement>document.getElementById("newPostText")).value = "";
      this.imageLink = "";
    }
  }

  addImageLink(): void{
    let link = prompt("add a link to an image");
    if(link != null){
      this.imageLink = link;
    }
  }
}
