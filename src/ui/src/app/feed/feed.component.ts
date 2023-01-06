import { Component } from '@angular/core';
import { Post } from '../post';
import { Comment } from '../comment';

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css']
})
export class FeedComponent {
  //DUMMY DATA to be replaced once the backend is filled out
  posts: Post[] = [
    {
      id: 0,
      username: 'Joe Chill',
      userId: 0,
      date: Date(),
      content: 'lol just got some new pearls, pretty sweet',
      likes: 1,
      comments: 2,
      clicked: false
    },
    {
      id: 1,
      username: 'Bruce Wayne',
      userId: 1,
      date: Date(),
      content: ":'(",
      likes: 0,
      comments: 0,
      clicked: false
    }
  ];
}
