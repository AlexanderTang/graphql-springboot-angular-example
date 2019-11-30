package alexandertang.playground.graphql.resolver;

import alexandertang.playground.graphql.repository.AuthorRepository;
import alexandertang.playground.graphql.repository.PostRepository;
import alexandertang.playground.graphql.model.Author;
import alexandertang.playground.graphql.model.Post;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@AllArgsConstructor
@Component
public class RootQueryResolver implements GraphQLQueryResolver {

    private PostRepository postRepository;
    private AuthorRepository authorRepository;

    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }

    public List<Post> getAllPosts(){
        return postRepository.findAll();
    }

    public List<Post> getPosts(String authorId){
        return postRepository.getAllByAuthorId(authorId);
    }
}

