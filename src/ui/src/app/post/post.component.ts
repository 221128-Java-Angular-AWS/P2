import { Component, Input, OnInit } from '@angular/core';
import { Post } from '../post';
import { Comment } from '../comment';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})
export class PostComponent implements OnInit {
  @Input()
  post!: Post;
  postComments: Comment[] = [];

  ngOnInit(): void {
    for (let i = 1; i < this.comments.length; i++) {
      if (this.comments[i].postId === this.post.id) {
        this.postComments.push(this.comments[i]);
      }
    }
  }

  clickMoreComments(): void {
    console.log('User requested more comments');
    this.post.clicked = true;
    for (let i = 0; i < this.postComments.length; i++) {
      console.log(this.postComments[i].content);
    }
  }

  comments: Comment[] = [
    {
      id: 0,
      userId: 1,
      postId: 0,
      username: "Bruce Wayne",
      date: Date(),
      content: "wtf dude"
    },
    {
      id: 1,
      userId: 2,
      postId: 0,
      username: 'The Joker',
      date: Date(),
      content: "lol XD gottem"
    },
    {
      id: 2,
      userId: 2,
      postId: 1,
      username: 'The Joker',
      date: Date(),
      content: "cry more kid lmao"
    }
  ]
}
