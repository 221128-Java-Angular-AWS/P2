export interface Post {
  id: number;
  username: string;
  userId: number;
  date: string;
  content: string;
  likes: number;
  comments: number;
  clicked: boolean;
}