import { Component, Input } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { RequestUser, RequestPost, RequestLike, LikeService } from 'app/Services/likes.service';
import { Post, PostsService } from 'app/Services/posts.service';
import { PostComponent } from 'app/post/post.component';
import { User } from 'app/model/user';


@Component({
  selector: 'app-like',
  templateUrl: './like.component.html',
  styleUrls: ['./like.component.css']
})



export class LikeComponent {
  remote: LikeService;
  likeCount: number | undefined;
  hasLiked: boolean | undefined;

  @Input()
  postItem!: Post;

  constructor(remote: LikeService, private postsService: PostsService) {
    this.remote = remote;
  }

  ngOnInit(): void {
    this.doGetLikeCount();
    this.doGetUserLikePost();
  }

  userId: number = 12 // just for now
  postId: number = 7 // same
  likeId: number = 0;
  


  // this object structure is still spaghetti, all of this is really to test end to end atm
  user: RequestUser = new RequestUser(this.userId);
  post: RequestPost = new RequestPost(this.postId);
  like: RequestLike = new RequestLike(this.user, this.post);

  
  doPostRequest() {
    this.remote.doPostLikePostAsUser(this.like).subscribe(() =>
      this.doGetLikeCount()
    );
    // added to try and update like count
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
  }

  // add button handling based around if a user has liked a post or not
  //new attempt to pass in information from the template
  // TODO: this will work with some refactoring of like and delete like to take arguments
  // can just create the like structure in here and pass off the the other methods.
  handleButtonClick(postId: any, user: any) {
    console.log("userId: " + user.userId + " postId: " + postId);
    //if (this.hasLiked = false) {
    //  this.doPostRequest();
    //} else {
    //  this.doDeleteUserLikePost();
    //}
  }
}


