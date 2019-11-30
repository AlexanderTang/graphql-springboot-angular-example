package alexandertang.playground.graphql.repository;

import alexandertang.playground.graphql.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> getAllByAuthorId(String authorId);
}
