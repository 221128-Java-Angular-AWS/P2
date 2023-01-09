import { Component, OnInit } from '@angular/core';
import { Post, PostsService } from '../Services/posts.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent {

  posts: Post[] = [];

  imageLink: string = "";
  constructor(private postsService: PostsService) {
  }

  createPost(text: string): void{
    if(text != "" || this.imageLink != ""){
      // NOTE: I added "The Riddler" to satisfy the method signature due to the expanded Post class constructor. -Travis M.
      this.postsService.createPost(text, this.imageLink, "The Riddler").subscribe(post => {
        console.log("Returned Post: ", post);
      });

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

  ngOnInit(): void {
    this.postsService.getPosts()
    .subscribe((posts) => {
      this.posts = posts;
    });
  }
}
