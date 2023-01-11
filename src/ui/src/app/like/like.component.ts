import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { RequestUser, RequestPost, RequestLike, LikeService } from 'app/Services/likes.service';
import { Post, PostsService } from 'app/Services/posts.service';
import { PostComponent } from 'app/post/post.component';
import { CookieService } from 'app/Services/cookie-service.service';
import { User } from 'app/model/user';


@Component({
  selector: 'app-like',
  templateUrl: './like.component.html',
  styleUrls: ['./like.component.css']
})



export class LikeComponent {
  remote: LikeService;
  cookie: CookieService
  likeCount: number | undefined;
  hasLiked: boolean | undefined;
  currentUser: User | undefined;

  @Input()
  postItem!: Post;

  constructor(remote: LikeService, private postsService: PostsService, cookie: CookieService) {
    this.remote = remote;
    this.cookie = cookie;
  }

  ngOnInit(): void {
    this.doGetLikeCount();
    this.doGetUserLikePost();
    this.getActiveUser()
  }

  userId: number =1;
  postId: number = 7; // same
  likeId: number = 0;
  


  // this object structure is still spaghetti, all of this is really to test end to end atm
 
  user: RequestUser = new RequestUser(this.userId);
  post: RequestPost = new RequestPost(this.postId);
  like: RequestLike = new RequestLike(this.user, this.post);

  getActiveUser() {
    this.currentUser = this.cookie.getCurrentUser();
    console.log(this.currentUser);
  }

  
  doPostRequest() {
    this.remote.doPostLikePostAsUser(this.like).subscribe(() =>
      this.doGetLikeCount()
    );
    // breadcrumbs
    console.log("liked");
  }

  doGetLikeCount() {
    console.log(this.like);
    this.remote.doGetLikeCountForPost(this.like).subscribe(
      (likeCount: number | undefined) => 
      this.likeCount = likeCount
    );
  }

  doGetUserLikePost() {
    this.remote.doGetLikeForPostUser(this.like).subscribe(
      (hasLiked: boolean | undefined) => this.hasLiked = hasLiked
    );
  }

  // delete is a bit wierd, return will be assigned to hasLiked changing it 
  // back to false if a like has been deleted
  doDeleteUserLikePost() {
    this.remote.doDeleteLikeForPostUser(this.like).subscribe(() =>
      this.doGetLikeCount()
    );
    // breadcrumbs
    console.log("unliked");
  }

  // TODO: 
  // this works now, I shouyld clean up some of the mess in here but ill just finish 
  // plugging in functionality and move on to helping or doing something else
  handleButtonClick(postId: any) {
    console.log("Like clicked. userId: " + this.currentUser?.userId + " postId: " + postId);
    console.log(this.hasLiked);
    this.postId = postId * 1;
    if (this.currentUser?.userId != null) {
      this.userId = this.currentUser?.userId
    }
    this.user = new RequestUser(this.userId);
    this.post = new RequestPost(this.postId);
    this.like = new RequestLike(this.user, this.post);
    console.log(this.like);
    if (this.hasLiked == false) {
      this.doPostRequest();
      this.hasLiked = true;
    } else {
      this.doDeleteUserLikePost();
      this.hasLiked = false;
    }
  }
}


