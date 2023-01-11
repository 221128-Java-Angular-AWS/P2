import { Component, OnInit, Output } from '@angular/core';
import { Post, PostsService } from '../Services/posts.service';
import { User } from 'app/model/user';
import { CookieService } from 'app/Services/cookie-service.service';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent {

  posts: Post[] = [];
  currentUser: User | undefined;

  imageLink: string = "";
  constructor(private postsService: PostsService, private cookieService: CookieService) {
  }

  createPost(text: string): void{
    //temporary measure until login is in its own page
    this.currentUser = this.cookieService.getCurrentUser()

    //we'll want to do this instead
    //if(this.currentUser == undefined){
    //  this.currentUser = this.cookieService.getCurrentUser()
    //}
    if(this.currentUser == undefined){
      alert("Must be signed in to create posts");
    }
    else if(text != "" || this.imageLink != ""){
      // NOTE: I added "The Riddler" to satisfy the method signature due to the expanded Post class constructor. -Travis M.
      this.postsService.createPost(text, this.imageLink, this.currentUser).subscribe(post => {
        console.log("Returned Post: ", post);
        this.posts.push(post);
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

  removeImageLink(): void{
    this.imageLink = "";
  }

  ngOnInit(): void {
    this.postsService.getPosts()
    .subscribe((posts) => {
      this.posts = posts;
    });
    this.currentUser = this.cookieService.getCurrentUser();
  }

  removePost(post: Post): void {
    this.posts.splice(this.posts.indexOf(post), 1);
  }

  @Output() removePostFromFeed = this.removePost.bind(this);


}
