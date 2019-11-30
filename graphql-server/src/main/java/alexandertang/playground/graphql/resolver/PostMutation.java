package alexandertang.playground.graphql.resolver;

import alexandertang.playground.graphql.repository.PostRepository;
import alexandertang.playground.graphql.model.Post;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Use a MutationResolver if your API alters data (PUT/POST/DELETE)
 */
@AllArgsConstructor
@Component
public class PostMutation implements GraphQLMutationResolver {

    private PostRepository postRepository;

    public Post writePost(String title, String text, String category, String authorId) {
        Post post = new Post();
        post.setId(UUID.randomUUID().toString());
        post.setTitle(title);
        post.setText(text);
        post.setCategory(category);
        post.setAuthorId(authorId);
        postRepository.save(post);

        return post;
    }
}
