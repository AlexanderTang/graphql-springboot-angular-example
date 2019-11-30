export interface Post {
  id: string,
  timestamp: number,
  title: string,
  text: string,
  category: string,
  authorId: string
}

export interface Author {
  id: string,
  name: string,
  thumbnail: string,
  posts: Post[]
}
